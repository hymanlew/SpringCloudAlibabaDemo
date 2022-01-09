package com.hyman.common.cache;

import com.hyman.common.enums.RedisKeyEnum;
import com.hyman.common.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Changyuan Su
 * @date 2020/12/1 上午11:49
 * @Description:
 */
public class DriverRedisCache extends AbstractCache<String, DriverCacheInfo> {

    private final Cache<String, DriverCacheInfo> delegate;

    private static final String BASE_KEY = RedisKeyEnum.DRIVER_BASE_INFO_REDIS_KEY.getKey();

    private final RedisUtil redisUtil;


    /**
     * @param redisUtil
     * @param delegate  下一级缓存
     */
    public DriverRedisCache(RedisUtil redisUtil, Cache delegate) {
        this.redisUtil = redisUtil;
        this.delegate = delegate;
    }


    @Override
    public DriverCacheInfo get(String key) {
        final String cacheKey = getCacheKey(key);
        if (contains(cacheKey)) {
            return redisUtil.get(cacheKey);
        } else {
            DriverCacheInfo info = delegate.get(key);
            put(key, info);
            return info;
        }
    }

    /**
     * @param keys keys
     * @return The objects stored in the cache.
     */
    @Override
    public Collection<DriverCacheInfo> get(Collection<String> keys) {
        if (CollectionUtils.isEmpty(keys)) {
            return null;
        }

        Set<String> queryKeys = keys.stream().filter(StringUtils::isNotBlank).collect(Collectors.toSet());
        if (CollectionUtils.isEmpty(queryKeys)) {
            return null;
        }

        List<DriverCacheInfo> finalResult = redisUtil.multiGet(queryKeys.stream().map(this::getCacheKey).collect(Collectors.toSet()));
        if (CollectionUtils.isEmpty(finalResult)) {
            return null;
        } else {
            // redis中的数据不为空
            finalResult = finalResult.stream().filter(Objects::nonNull).collect(Collectors.toList());
            queryKeys.removeAll(finalResult.stream().filter(Objects::nonNull).map(DriverCacheInfo::getDriverId).collect(Collectors.toList()));
            if (!CollectionUtils.isEmpty(queryKeys)) {
                // 说明redis中数据不全
                Collection<DriverCacheInfo> dbInfos = delegate.get(queryKeys);
                if (!CollectionUtils.isEmpty(dbInfos)) {
                    Map<String, DriverCacheInfo> infoMap = dbInfos.stream().collect(Collectors.toMap(DriverCacheInfo::getDriverId, v -> v, (m1, m2) -> m1));
                    putAll(infoMap);
                    finalResult.addAll(dbInfos);
                }
            }
            return finalResult;
        }
    }


    /**
     * 注意此方法返回值可能不实时精准
     *
     * @return
     */
    @Override
    public int getSize() {
        Set<String> set = getKeys();
        return CollectionUtils.isEmpty(set) ? 0 : set.size();
    }

    /**
     * 获取所有缓存数据
     *
     * @return
     */
    public Set<String> getKeys() {
        return redisUtil.scan(getCacheKey("*"));
    }

    @Override
    public boolean contains(@NotBlank String key) {
        return redisUtil.hasKey(key);
    }

    @Override
    public void put(String key, DriverCacheInfo value, int ttl) {
        put(key, value, ttl, false);
    }


    /**
     * 保存数据
     *
     * @param key
     * @param value
     * @param ttl
     * @param isForce 是否强制保存，强制保存时，会保存空值
     */
    protected void put(String key, DriverCacheInfo value, int ttl, boolean isForce) {
        if (!isForce && Objects.isNull(value)) return;
        redisUtil.set(getCacheKey(key), value, ttl);
    }


    /**
     * 存数据,会自动向下寻找数据
     *
     * @param key 键
     */
    public void put(@NotBlank String key) {
        if (StringUtils.isBlank(key)) return;
        put(key, delegate.get(key));
    }


    /**
     * 强制性保存数据，主要是保存结果为空的数据
     *
     * @param key   Can be any object but usually it is a {@link String}
     * @param value The result of a select.
     */
    @Override
    public void forcePut(@NotBlank String key, @NotNull DriverCacheInfo value) {
        put(key, value, DEFAULT_CACHE_EXPIRE_SECONDS, true);
    }


    @Override
    public void putAll(Map<String, DriverCacheInfo> m, int ttl) {
        if (CollectionUtils.isEmpty(m)) {
            return;
        }
        Map<String, DriverCacheInfo> infoMap = m.entrySet().stream().collect(Collectors.toMap(k -> getCacheKey(k.getKey()), v -> v.getValue()));
        redisUtil.mSet(infoMap);
        infoMap.keySet().stream().forEach(k -> this.expire(k, DEFAULT_CACHE_EXPIRE_SECONDS));
    }

    /**
     * 使key过期
     *
     * @param key
     * @param ttl
     * @return
     */
    private boolean expire(String key, int ttl) {
        return redisUtil.expire(key, ttl);
    }

    /**
     * 删除后不返回数据
     *
     * @param key The key
     * @return
     */
    @Override
    public DriverCacheInfo remove(String key) {
        String cacheKey = getCacheKey(key);
        redisUtil.del(cacheKey);
        return null;
    }


    /**
     * 批量删除
     *
     * @param keys
     * @return
     */
    public DriverCacheInfo remove(@NotEmpty Collection<String> keys) {
        redisUtil.del(keys.stream().map(k -> getCacheKey(k)).collect(Collectors.toList()));
        return null;
    }


    @Override
    public void clear() {
        remove(getKeys());
    }

    /**
     * 获取缓存key
     *
     * @param key
     * @return
     */
    @Override
    protected String getCacheKey(@NotBlank String key) {
        return new StringBuilder().append(BASE_KEY).append(':').append(key).toString();
    }


}
