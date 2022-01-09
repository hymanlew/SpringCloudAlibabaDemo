package com.hyman.common.service;

import com.hyman.common.vo.Lock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * suchangyuan：
 * *  * 此分布式锁实现问题非常大（宕机和原子性均无法保证，锁失效问题），建议使用Redisson替代
 * *  * Zookeeper比redis作为分布式锁更具优势，redis需要自旋获取锁，zookeeper具备监听机制不需自旋，更加节省资源
 * *  * <p>
 * Created by lp on 2017/5/9.
 */
@Deprecated
@Slf4j
public class LockService {
    private final static long LOCK_EXPIRE = 2 * 1000L; //单个业务持有锁的时间2s,防止死锁

    private final static long LOCK_TRY_INTERVAL = 30L; //默认30ms尝试一次

    private final static long LOCK_TRY_TIMEOUT = 3 * 1000L; // 默认尝试3s

    @Autowired
    private StringRedisTemplate template;

    /**
     * 操作redis获取全局锁
     *
     * @param lock           锁的名称
     * @param timeout        获取的超时时间
     * @param tryInterval    多少ms尝试一次
     * @param lockExpireTime 获取成功后锁的过期时间
     * @return true 获取成功，false获取失败
     */
    public boolean getLock(Lock lock, long timeout, long tryInterval, long lockExpireTime) {

        try {
            if (StringUtils.isEmpty(lock.getName()) || StringUtils.isEmpty(lock.getValue())) {
                return false;
            }
            long startTime = System.currentTimeMillis();
            while (true) {
                if (template.opsForValue().setIfAbsent(lock.getName(), lock.getValue())) {
                    template.opsForValue().set(lock.getName(), lock.getValue(), lockExpireTime, TimeUnit.MILLISECONDS);
                    log.debug(Thread.currentThread().getName() + " : get lock");
                    return true;
                } else {
                    log.debug(Thread.currentThread().getName() + " : ----> locking is exist!!!");
                }
                if (System.currentTimeMillis() - startTime > timeout) {
                    return false;
                }
                Thread.sleep(tryInterval);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }


    /**
     * 尝试获取全局锁
     *
     * @param lock 锁的名称
     * @return true 获取成功，false获取失败
     */
    public boolean tryLock(Lock lock) {
        return getLock(lock, LOCK_TRY_TIMEOUT, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }


    /**
     * 尝试获取全局锁
     *
     * @param lock    锁的名称
     * @param timeout 获取超时时间 单位ms
     * @return true 获取成功，false获取失败
     */
    public boolean tryLock(Lock lock, long timeout) {
        return getLock(lock, timeout, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }


    /**
     * 尝试获取全局锁
     *
     * @param lock        锁的名称
     * @param timeout     获取锁的超时时间
     * @param tryInterval 多少毫秒尝试获取一次
     * @return true 获取成功，false获取失败
     */
    public boolean tryLock(Lock lock, long timeout, long tryInterval) {
        return getLock(lock, timeout, tryInterval, LOCK_EXPIRE);
    }


    /**
     * 尝试获取全局锁
     *
     * @param lock           锁的名称
     * @param timeout        获取锁的超时时间
     * @param tryInterval    多少毫秒尝试获取一次
     * @param lockExpireTime 锁的过期
     * @return true 获取成功，false获取失败
     */
    public boolean tryLock(Lock lock, long timeout, long tryInterval, long lockExpireTime) {
        return getLock(lock, timeout, tryInterval, lockExpireTime);
    }

    /**
     * 释放锁
     */
    public void releaseLock(Lock lock) {
        if (!StringUtils.isEmpty(lock.getName())) {
            log.debug(Thread.currentThread().getName() + " : del lock");
            template.delete(lock.getName());
        }
    }


}
