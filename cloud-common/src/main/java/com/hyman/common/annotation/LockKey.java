package com.hyman.common.annotation;

import java.lang.annotation.*;

/**
 * 用于标识用于Redis锁的key
 *
 * @author wanghaitong
 * @date 2020/12/15 下午5:26
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LockKey {
}
