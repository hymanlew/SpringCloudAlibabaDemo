package com.hyman.common.aspect;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.hyman.common.annotation.DistributedLock;
import com.hyman.common.annotation.LockKey;
import com.hyman.common.util.AopUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;

/**
 * 封装Redis锁相关操作
 *
 * @author Haitong Wang
 * @date 2020/12/9 下午5:44
 */
@Aspect
@Component
@Slf4j
public class RedisLockAop {

    @Resource
    private RedisLockRegistry lockRegistry;

    @Pointcut("execution( * com.hyman..*.*(..)) && @annotation(com.hyman.common.annotation.DistributedLock)")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 0. 获取index和key
        DistributedLock annotation = AopUtil.getMethodAnnotation(joinPoint, DistributedLock.class);
        String index = annotation.index();
        if ("".equals(index)) {
            MethodSignature sign = (MethodSignature) joinPoint.getSignature();
            index = sign.getClass().getName() + sign.getMethod().getName();
        }

        Assert.isTrue(StrUtil.isNotBlank(index), "index不能为空，methodName:{}", joinPoint.getSignature().getName());

        Object source = AopUtil.getParamValueWithAnnotation(joinPoint, LockKey.class);
        Assert.isTrue(source != null, "key不能为空，methodName:{}", joinPoint.getSignature().getName());
        String key = source.toString();

        // 1. 加锁
        Lock lock = lockRegistry.obtain(index + key);
        lock.lock();
        try {
            return joinPoint.proceed();
        } finally {
            lock.unlock();
        }
    }
}
