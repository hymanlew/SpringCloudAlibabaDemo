package com.hyman.common.annotation;

import java.lang.annotation.*;

/**
 * 消费去重
 *
 * @author hucl
 * @date 2021/6/8 2:45 下午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ConsumeDuplicationCheck {

    /**
     * 缓存key前缀
     * <p>例如 mq:consume:duplication_check:
     *
     * @return 前缀
     */
    String redisPrefix() default "mq:consume:duplication_check:";

    /**
     * 缓存后缀名
     * <p>例如 123
     *  <b>redisPrefix + redisSuffix = mq:consume:duplication_check:123(完整的redis key)
     *
     * @return 后缀的属性名
     */
    String redisSuffix() default "uniqueId";

    /**
     * redis 过期时间，单位秒
     * 默认五分钟
     *
     * @return 过期时间
     */
    long expire() default 5 * 60;


}
