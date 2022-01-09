package com.hyman.common.cache;

import cn.hutool.core.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Changyuan Su
 * @date 2020/12/1 上午11:49
 * @Description:
 */
public abstract class AbstractDriverDbCache extends AbstractCache<String, DriverCacheInfo> {

    @Override
    public DriverCacheInfo get(@NotBlank String key) {
        Assert.notBlank(key, "司机编号不能为空");
//        List<DriverCacheInfo> driverCacheInfos = null;
        return doContains(key);
//        return contains(key) && !CollectionUtils.isEmpty(driverCacheInfos = doGet(Collections.singletonList(key))) ? driverCacheInfos.get(0) : null;
    }

    /**
     * 获取数据
     *
     * @param keys 多个key
     * @return
     */
    protected abstract Collection<DriverCacheInfo> doGet(@NotEmpty Collection<String> keys);


    /**
     * @param keys keys
     * @return The objects stored in the cache.
     */
    @Override
    public Collection<DriverCacheInfo> get(Collection<String> keys) {
        if (CollectionUtils.isEmpty(keys)) {
            return null;
        }

        Set<String> keySet = keys.stream().filter(StringUtils::isNotBlank).collect(Collectors.toSet());
        return doGet(keySet);
    }


    @Override
    public void put(String key, DriverCacheInfo value, int ttl) {
        throw new UnsupportedOperationException("不支持对DB中的数据执行更新操作");
    }

    @Override
    public void putAll(Map<String, DriverCacheInfo> m, int ttl) {
        throw new UnsupportedOperationException("不支持对DB中的数据执行更新操作");
    }

    /**
     * 删除后不返回数据
     *
     * @param key The key
     * @return
     */
    @Override
    public DriverCacheInfo remove(String key) {
        throw new UnsupportedOperationException("不支持对DB中的数据执行删除操作");
    }


    /**
     * 批量删除
     *
     * @param keys
     * @return
     */
    public DriverCacheInfo remove(@NotEmpty Collection<String> keys) {
        throw new UnsupportedOperationException("不支持对DB中的数据执行删除操作");
    }


    @Override
    public void clear() {
        throw new UnsupportedOperationException("不支持对DB中的数据执行删除操作");
    }

    @Override
    public boolean contains(String key) {
        return Objects.nonNull(doContains(key));
    }

    /**
     * 查看是否包含当前key，并返回数据
     *
     * @param key
     * @return
     */
    protected DriverCacheInfo doContains(@NotBlank String key) {
        Collection<DriverCacheInfo> infos = doGet(Collections.singletonList(key));
        return CollectionUtils.isEmpty(infos) ? null : infos.stream().findFirst().orElse(null);
    }

}
