package com.hyman.common.annotation;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author:
 * @create: 2019-03-05
 * @description:打印方法入参
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PrintParam {

    /**
     * 是否打印入参
     *
     * @return
     */
    boolean inputArgs() default true;


    /**
     * 是否打印出参
     *
     * @return
     */
    boolean outputArgs() default true;

    /**
     * 方法中文名
     *
     * @return
     */
    @AliasFor("name")
    String methodChName() default "";

    String name() default "";

}
