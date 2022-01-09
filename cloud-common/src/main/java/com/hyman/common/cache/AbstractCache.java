package com.hyman.common.cache;


import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Changyuan Su
 * @date 2020/12/1 上午11:15
 * @Description: 当前类只是弄了一些模板方法，并没有具体实现
 */
@Slf4j
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    /**
     * 默认缓存过期时长（单位：秒）, 默认3天
     */
    protected int DEFAULT_CACHE_EXPIRE_SECONDS = 3600 * 24 * 3;

    /**
     * Constructor for use by subclasses.
     */
    protected AbstractCache() {
    }

    /**
     * 设置缓存过期时长（单位：秒）
     *
     * @param cacheExpireSeconds 缓存过期时长（单位：秒）
     */
    protected AbstractCache(int cacheExpireSeconds) {
        if (cacheExpireSeconds < 5) {
            log.info("过期时长=[{}]s", DEFAULT_CACHE_EXPIRE_SECONDS);
        } else {
            DEFAULT_CACHE_EXPIRE_SECONDS = cacheExpireSeconds;
        }
    }

    /**
     * @param key   Can be any object but usually it is a {@link String}
     * @param value The result of a select.
     */
    @Override
    public void put(K key, V value) {
        put(key, value, DEFAULT_CACHE_EXPIRE_SECONDS);
    }

    @Override
    public void put(K key, Function<K, V> function) {
        put(key, function.apply(key));
    }

    /**
     * 强制性保存数据，主要是保存结果为空的数据
     * NB: 主要场景是缓存穿透
     *
     * @param key   Can be any object but usually it is a {@link String}
     * @param value The result of a select.
     */
    public void forcePut(K key, V value) {
        put(key, value);
    }

    /**
     * Copies all of the mappings from the specified map to the cache. The effect of this call is
     * equivalent to that of calling {@code put(k, v)} on this map once for each mapping from key
     * {@code k} to value {@code v} in the specified map. The behavior of this operation is undefined
     * if the specified map is modified while the operation is in progress.
     */
    @Override
    public void putAll(Map<K, V> m) {
        putAll(m, DEFAULT_CACHE_EXPIRE_SECONDS);
    }

    @Override
    public void putAll(Map<K, V> m, int ttl) {
        m.entrySet().stream().forEach(s -> put(s.getKey(), s.getValue(), ttl));
    }


    /**
     * @param key The key
     * @return Not used
     */
    @Override
    public V remove(K key) {
        return null;
    }

    /**
     * Clears this cache instance
     */
    @Override
    public void clear() {

    }

    /**
     * 获取缓存key
     *
     * @param key
     * @return
     */
    protected K getCacheKey(@NotBlank K key) {
        return key;
    }

    /**
     * @param keys keys
     * @return The objects stored in the cache.
     */
    @Override
    public Collection<V> get(Collection<K> keys) {
        return keys.stream().filter(Objects::nonNull).map(k -> get(k)).collect(Collectors.toList());
    }


    @Override
    public int getSize() {
        return 0;
    }

}
