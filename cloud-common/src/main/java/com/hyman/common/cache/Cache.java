package com.hyman.common.cache;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Changyuan Su
 * @date 2020/12/1 上午11:18
 * @Description:
 */
public interface Cache<K extends Object, V extends Object> {
    /**
     * @param key   Can be any object but usually it is a {@link String}
     * @param value The result of a select.
     */
    void put(K key, V value);


    /**
     * 放置缓存
     *
     * @param key
     * @param function
     */
    void put(K key, Function<K, V> function);

    /**
     * @param key   Can be any object but usually it is a {@link String}
     * @param value The result of a select.
     * @param ttl   过期时长
     */
    void put(K key, V value, int ttl);

    /**
     * Copies all of the mappings from the specified map to the cache. The effect of this call is
     * equivalent to that of calling {@code put(k, v)} on this map once for each mapping from key
     * {@code k} to value {@code v} in the specified map. The behavior of this operation is undefined
     * if the specified map is modified while the operation is in progress.
     */
    void putAll(Map<K, V> m);

    /**
     * @param m
     * @param ttl
     */
    void putAll(Map<K, V> m, int ttl);

    /**
     * @param key The key
     * @return The object stored in the cache.
     */
    V get(K key);


    /**
     * @param keys keys
     * @return The objects stored in the cache.
     */
    Collection<V> get(Collection<K> keys);

    /**
     * @param key The key
     * @return Not used
     */
    V remove(K key);

    /**
     * Clears this cache instance
     */
    void clear();

    /**
     * Optional. This method is not called by the core.
     *
     * @return The number of elements stored in the cache (not its capacity).
     */
    int getSize();


    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    boolean contains(K key);

}
