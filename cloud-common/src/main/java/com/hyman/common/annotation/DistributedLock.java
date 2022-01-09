package com.hyman.common.annotation;


import java.lang.annotation.*;

/**
 * 表示当前方法需要加分布式锁
 *
 * @author wanghaitong
 * @date 2020/12/15 下午4:33
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DistributedLock {

    String index() default "";

    int expireTime() default 30;

}
