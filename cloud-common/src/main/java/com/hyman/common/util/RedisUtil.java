package com.hyman.common.util;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import com.hyman.common.model.dto.common.RedisQueryParamDTO;
import com.hyman.common.model.dto.redis.GeoRadiusDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author:
 * @create: 2018-10-18
 * @description:
 **/
//@ConditionalOnBean({RedisTemplate.class})
@Component
@Slf4j
public final class RedisUtil {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    // =============================common============================
    
    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(@NotBlank String key, @Min(value = 0) long time) {
        try {
            return hasKey(key) ? redisTemplate.expire(key, time, TimeUnit.SECONDS) : Boolean.FALSE;
        } catch (Exception e) {
            log.error("指定缓存失效时间出现异常，异常信息:{}，key:{}",e,key);
            return false;
        }
    }
    
    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }
    
    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error("判断key是否存在出现异常，异常信息:{}，key:{}",e,key);
            return false;
        }
    }
    
    /**
     * 查询key
     *
     * @param
     * @return
     */
    public Set<String> getKeys(String key) {
        return redisTemplate.keys(key.concat("*"));
    }
    
    /**
     * scan 实现
     *
     * @param pattern  表达式
     * @param consumer 对迭代到的key进行操作
     */
    public void scan(String pattern, Consumer<byte[]> consumer) {
        redisTemplate.execute((RedisConnection connection) -> {
            try (Cursor<byte[]> cursor =
                         connection.scan(ScanOptions.scanOptions().count(Long.MAX_VALUE).match(pattern).build())) {
                cursor.forEachRemaining(consumer);
                return null;
            } catch (IOException e) {
                log.error("sacn操作出现异常，异常信息:{}",e);
                throw new RuntimeException(e);
            }
        });
    }
    
    public void scan2(String pattern, Set<Object> binaryKeys) {
        Set<Object> execute = redisTemplate.execute(new RedisCallback<Set<Object>>() {
            
            @Override
            public Set<Object> doInRedis(RedisConnection connection) throws DataAccessException {
                
                Cursor<byte[]> cursor =
                        connection.scan(new ScanOptions.ScanOptionsBuilder().match(pattern).count(1000).build());
                while (cursor.hasNext()) {
                    binaryKeys.add(new String(cursor.next()));
                }
                return binaryKeys;
            }
        });
    }
    
    /**
     * scan 实现
     *
     * @param pattern 表达式，如：abc*，找出所有以abc开始的键
     */
    public Set<String> scan(String pattern) {
        return redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
            Set<String> keysTmp = new HashSet<>();
            try (Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder()
                    .match(pattern)
                    .count(10).build())) {
                
                while (cursor.hasNext()) {
                    keysTmp.add(new String(cursor.next(), StandardCharsets.UTF_8));
                }
            } catch (Exception e) {
                log.error("scan出现异常，异常信息:{}",e);
                throw new RuntimeException(e);
            }
            return keysTmp;
        });
    }
    
    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }
    
    /**
     * 批量删除缓存
     *
     * @param keyList List
     * @author hucl
     */
    public void del(List<String> keyList) {
        if (CollectionUtil.isNotEmpty(keyList)) {
            redisTemplate.delete(keyList);
        }
    }
    // ============================String=============================
    
    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     * Warning: 包装类可能返回null
     * Warning: 包装类可能返回null
     * Warning: 包装类可能返回null
     * 如果不确信当前key存在，建议使用getby
     */
    public <V extends Object> V get(@NotBlank String key) {
        return key == null ? null : (V) redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存获取
     *
     * @param 多个keys 键
     * @return 值
     * Warning: 包装类可能返回null
     * Warning: 包装类可能返回null
     * Warning: 包装类可能返回null
     * 如果不确信当前key存在，建议使用getby
     */
    public List<Object> getList(@NotEmpty List<String> keys) {
       return this.redisTemplate.opsForValue().multiGet(keys);
    }
    
    /**
     * 根据key获取value
     *
     * @param key
     * @param <V>
     * @return Optional
     */
    public <V extends Object> Optional<V> getby(@NotBlank String key) {
        return Optional.ofNullable((V) redisTemplate.opsForValue().get(key));
    }
    
    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("普通缓存放入出现异常，异常信息:{}，key:{}",e,key);
            return false;
        }
    }
    
    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error("普通缓存放入并设置时间出现异常，异常信息:{}，key:{}",e,key);
            return false;
        }
    }
    
    /**
     * redis string 批量set
     *
     * @param map <key,Object> key->redis key, value->redis value
     * @return 成功 true, 失败 false
     */
    public boolean mSet(Map<String, ? extends Object> map) {
        try {
            redisTemplate.opsForValue().multiSet(map);
            return true;
        } catch (Exception e) {
            log.error("批量set出现异常，异常信息:{}，参数:{}",e, JSONObject.toJSON(map));
            return false;
        }
    }
    
    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }
    
    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }
    // ================================Map=================================
    
    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public <HK, HV> HV hget(String key, HK item) {
        return redisTemplate.<HK, HV>opsForHash().get(key, item);
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public <HK, HV> Map<HK, HV> hmget(String key) {
        return redisTemplate.<HK, HV>opsForHash().entries(key);
    }
    
    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            log.error("hmset出现异常，异常信息:{}，参数1:{}，参数2：{}",e,key, JSONObject.toJSON(map));
            return false;
        }
    }
    
    
    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("HashSet 并设置时间，异常信息:{}，参数1:{}，参数2：{}",e,key, JSONObject.toJSON(map));
            return false;
        }
    }
    
    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    public <HK, HV> boolean hset(String key, HK item, HV value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            log.error("向一张hash表中放入数据,如果不存在将创建操作异常，异常信息:{}，参数1:{}",e,key);
            return false;
        }
    }
    
    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public <HK, HV> boolean hset(String key, HK item, HV value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("向一张hash表中放入数据,如果不存在将创建操作异常，异常信息:{}，参数1:{}",e,key);
            return false;
        }
    }
    
    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }
    
    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public <HK> boolean hHasKey(String key, HK item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }
    
    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public <HK> Long hincr(String key, HK item, long by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }
    
    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public Long hdecr(String key, String item, long by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }
    
    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }
    
    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public double hdecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }
    // ============================set=============================
    
    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    public Set<Object> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            log.error("根据key获取Set中的所有值操作异常，异常信息:{}，参数1:{}",e,key);
            return null;
        }
    }
    
    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            log.error("根据value从一个set中查询,是否存在操作异常，异常信息:{}，参数1:{}",e,key);
            return false;
        }
    }
    
    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            log.error("将数据放入set缓存操作异常，异常信息:{}，参数1:{}",e,key);
            return 0;
        }
    }
    
    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime(String key, long time, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            log.error("将set数据放入缓存操作异常，异常信息:{}，参数1:{}",e,key);
            return 0;
        }
    }
    
    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            log.error("获取set缓存的长度操作异常，异常信息:{}，参数1:{}",e,key);
            return 0;
        }
    }
    
    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            log.error("移除值为value的操作异常，异常信息:{}，参数1:{}",e,key);
            return 0;
        }
    }
    
    /**
     * SISMEMBER key member
     * ----判断 member 元素是否是集合 key 的成员
     *
     * @param key
     * @return
     */
    public boolean sIsMember(@NotBlank String key, @NotNull Object member) {
        return redisTemplate.opsForSet().isMember(key, member);
    }
    
    /**
     * SREM key member1 [member2]
     * ---- 移除集合中一个或多个成员
     *
     * @param key
     * @param members
     * @return
     */
    public Long sRem(@NotBlank String key, @NotNull Object... members) {
        return redisTemplate.opsForSet().remove(key, members);
    }
    
    // ===============================list=================================
    
    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return
     */
    public List<Object> lGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            log.error("取list缓存的内容操作异常，异常信息:{}，参数1:{}",e,key);
            return null;
        }
    }
    
    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    public long lGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            log.error("获取list缓存的长度操作异常，异常信息:{}，参数1:{}",e,key);
            return 0;
        }
    }
    
    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            log.error("通过索引 获取list中的值操作异常，异常信息:{}，参数1:{}",e,key);
            return null;
        }
    }
    
    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            log.error("将list放入缓存操作异常，异常信息:{}，参数1:{}",e,key);
            return false;
        }
    }
    
    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("将list放入缓存操作异常，异常信息:{}，参数1:{}",e,key);
            return false;
        }
    }
    
    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, List value) {
        try {
            return redisTemplate.opsForList().rightPushAll(key, value) > 0;
        } catch (Exception e) {
            log.error("将list放入缓存操作异常，异常信息:{}，参数1:{}",e,key);
            return false;
        }
    }
    
    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lSet(String key, List value, long time) {
        if (time > 0) {
            if (redisTemplate.opsForList().rightPushAll(key, value) > 0) {
                return expire(key, time);
            } else {
                del(key);
            }
        }
        return false;
    }
    
    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean lUpdateIndex(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            log.error("根据索引修改list中的某条数据操作异常，异常信息:{}，参数1:{}",e,key);
            return false;
        }
    }
    
    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long lRemove(String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            log.error("移除N个值为value操作异常，异常信息:{}，参数1:{}",e,key);
            return 0;
        }
    }
    
    public boolean lock(String key, String requestId, long expire) {
        return (Boolean) redisTemplate.execute((RedisCallback) connection -> {
            Boolean result = connection.set(key.getBytes(), requestId.getBytes(), Expiration.from(expire,
                    TimeUnit.SECONDS), RedisStringCommands.SetOption.SET_IF_ABSENT);
            return result;
        });
    }
    
    public boolean releaseLock(String key, String requestId) {
        return (Boolean) redisTemplate.execute((RedisCallback) connection -> {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else " +
                    "return 0 end";
            Boolean result = connection.eval(script.getBytes(), ReturnType.BOOLEAN, 1, key.getBytes(),
                    requestId.getBytes());
            return result;
        });
    }
    
    /**
     * @description 根据keys批量获取String类型的value列表<br>
     * @Param: [keys]
     * @Return: java.util.List
     * @Date: 2020/7/22 16:02
     */
    public List multiGet(Set<String> keys) {
        if (CollectionUtils.isEmpty(keys)) {
            return new ArrayList();
        }
        return redisTemplate.opsForValue().multiGet(keys);
    }
    /**
     * @description 批量查询string中的信息 <br>
     * @Param: [keys]
     * @Return: java.util.List
     * @Author: hyman
     * @Date: 2021/1/19 20:13
     */
    public List batchGet(Set<String> keys) {
        try {
            return redisTemplate.executePipelined(new RedisCallback<Object>() {
                @Nullable
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    Iterator<String> iterator = keys.iterator();
                    while (iterator.hasNext()) {
                        connection.get(iterator.next().getBytes());
                    }
                    return null;
                }
            }, redisTemplate.getValueSerializer());
        } catch (Exception e) {
            log.error("批量查询用户角色的信息操作异常，异常信息:{}，参数1:{}",e,keys);
            return Lists.emptyList();
        }
    }
    
    /**
     * @description 批量查询hash中的数据<br>
     * @Param: [params]
     * @Return: java.util.List
     * @Author: hyman
     * @Date: 2021/1/19 20:14
     */
    public List batchHGet(List<RedisQueryParamDTO> params) {
        try {
            return redisTemplate.executePipelined(new RedisCallback<Object>() {
                @Nullable
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    for (RedisQueryParamDTO dto : params) {
                        connection.hGet(dto.getKey().getBytes(), dto.getField().getBytes());
                    }
                    return null;
                }
            }, redisTemplate.getValueSerializer());
        } catch (Exception e) {
            log.error("批量查询hash中的数据操作异常，异常信息:{}，参数1:{}",e,JSONObject.toJSON(params));
            return Lists.emptyList();
        }
    }
    /**
     * @Title: geoAdd
     * @Description: TODO(添加geo)
     * @param key key
     * @param point 经纬度
     * @param member 成员
     * @return Long 返回影响的行
     */
    public Long geoAdd(String key, Point point, String member) {
        return redisTemplate.opsForGeo().add(key,point,member);
    }

    /*@Test
    public void testAdd(){
        Long addedNum = redisTemplate.opsForGeo()
                .add(cityGeoKey,new Point(116.405285,39.904989),"北京");
        System.out.println(addedNum);
    }*/


    /**
     * @Title: geoRemove
     * @Description: TODO(删除成员)
     * @param key 
     * @param members 成员
     * @return Long 返回影响的行
     */
    public Long geoRemove(String key, String... members) {
        return redisTemplate.opsForGeo().remove(key, members);
    }

    /**
     * @Title: geoPos
     * @Description: TODO(查询地址的经纬度)
     * @param key key
     * @param members 成员
     * @return List<Point>
     */
    public List<Point> geoPos(String key, String... members) {
        return redisTemplate.opsForGeo().position(key, members);
    }

    /**
     * @Title: geoHash
     * @Description: TODO(查询位置的geohash)
     * @param key
     * @param members
     * @return List<String>
     */
    public List<String> geoHash(String key, String... members) {
        return redisTemplate.opsForGeo().hash(key, members);
    }

    /**
     * @Title: geoDist
     * @Description: TODO(查询2位置距离)
     * @param key key
     * @param member1 成员1
     * @param member2 成员2
     * @param metric 单位
     * @return Double 距离
     */
    public Double geoDist(String key, String member1, String member2, Metric metric) {
        return redisTemplate.opsForGeo().distance(key, member1, member2, metric).getValue();
    }

    /**
     * @Title: geoRadius
     * @Description: TODO(查询附近坐标地址)
     * @param key key
     * @param center 中心坐标
     * @param radius 半径
     * @param metric 半径单位
     * @param direction 排序
     * @return List<String>
     * @throws
     */
    public List<GeoRadiusDto> geoRadius(String key, Point center, Double radius, CustomMetric metric, Sort.Direction direction) {
        List<GeoRadiusDto> radiusDtos = new ArrayList<GeoRadiusDto>();
        Distance distance = new Distance(radius, metric);
        Circle within = new Circle(center, distance);
        RedisGeoCommands.GeoRadiusCommandArgs args = null;
        if(direction.isAscending()){
            args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().sortAscending().includeCoordinates();
        }
        if(direction.isDescending()){
            args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().sortDescending().includeCoordinates();
        }
        GeoResults<RedisGeoCommands.GeoLocation<Object>> geoResults = redisTemplate.opsForGeo().radius(key, within, args);
        List<GeoResult<RedisGeoCommands.GeoLocation<Object>>> geoResultList = geoResults.getContent();
        for(GeoResult<RedisGeoCommands.GeoLocation<Object>> geoResult:geoResultList){
            String name = (String) geoResult.getContent().getName();
            Point point = geoResult.getContent().getPoint();
            GeoRadiusDto radiusDto = new GeoRadiusDto();
            radiusDto.setKey(key);
            radiusDto.setMember(name);
            radiusDto.setX(point.getX());
            radiusDto.setY(point.getY());
            radiusDtos.add(radiusDto);
        }
        return radiusDtos;
    }

    /**
     * @Title: geoRadiusByMember
     * @Description: TODO(根据成员查询附近点)
     * @param key
     * @param member 成员
     * @param radius 半径
     * @param metric 半径单位
     * @param direction 排序
     * @return List<GeoRadiusDto>
     */
    public List<GeoRadiusDto> geoRadiusByMember(String key, String member, Double radius, Metric metric, Sort.Direction direction) {
        List<GeoRadiusDto> radiusDtos = new ArrayList<GeoRadiusDto>();
        Distance distance = new Distance(radius, metric);
        RedisGeoCommands.GeoRadiusCommandArgs args = null;
        if(direction.isAscending()){
            args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().sortAscending().includeCoordinates();;
        }
        if(direction.isDescending()){
            args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().sortDescending().includeCoordinates();;
        }
        GeoResults<RedisGeoCommands.GeoLocation<Object>> geoResults = redisTemplate.opsForGeo().geoRadiusByMember(key, member, distance, args);
        List<GeoResult<RedisGeoCommands.GeoLocation<Object>>> geoResultList = geoResults.getContent();
        for(GeoResult<RedisGeoCommands.GeoLocation<Object>> geoResult:geoResultList){
            String name = (String) geoResult.getContent().getName();
            Point point = geoResult.getContent().getPoint();
            GeoRadiusDto radiusDto = new GeoRadiusDto();
            radiusDto.setKey(key);
            radiusDto.setMember(name);
            radiusDto.setX(point.getX());
            radiusDto.setY(point.getY());
            radiusDtos.add(radiusDto);
        }
        return radiusDtos;
    }

    /**
     * 获取zset数据
     * @param key
     * @return
     */
    public Set<Object> zSetRange(String key,long l,long l1) {
        try {
            return redisTemplate.opsForZSet().range(key,l,l1);
        } catch (Exception e) {
            log.error("取zset缓存的内容操作异常，异常信息:{}，参数1:{}",e,key);
            return null;
        }
    }
    /**
     * 移除zset数据
     * @param key
     * @return
     */
    public long zSetRemove(String key ,Object... values) {
        try {
            return redisTemplate.opsForZSet().remove(key,values);
        } catch (Exception e) {
            log.error("删除zset缓存的内容操作异常，异常信息:{}，参数1:{}",e,key);
            return 0;
        }
    }
}
