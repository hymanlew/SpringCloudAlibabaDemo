package com.hyman.common.log;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: hyman
 * @Date: 2018/6/28 18:36
 * @Description:     在主启动类中添加此注解 即可使用自定义日志
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LogConfigure.class)
@Documented
@Inherited
public @interface EnableCustomLog {
}
