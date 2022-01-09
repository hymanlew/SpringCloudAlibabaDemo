package com.hyman.common.aspect;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hyman.common.annotation.PrintParam;
import com.netflix.hystrix.contrib.javanica.utils.AopUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class PrintParamAspect {

    @Pointcut("execution( * com.hyman..*.*(..)) && @annotation(com.hyman.common.annotation.PrintParam)")
    public void printParamAnnotationPointcut() {
    }


    /**
     * 当切面有参数为HttpServletRequest之类的参数时，使用
     * Object[] args = joinPoint.getArgs();
     * 会占用HttpServletRequest中的上下文，当再次调用
     * JSON.toJSONString(args);
     * 为再次尝试获取request中的上下文，如果未开启Servlet异步处理,则会抛出
     * It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
     * 此异常
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "printParamAnnotationPointcut()")
    public Object printParam(final ProceedingJoinPoint joinPoint) throws Throwable {
        Method methodFromTarget = AopUtils.getMethodFromTarget(joinPoint);
        final PrintParam printParamAnnotation = methodFromTarget.getAnnotation(PrintParam.class);
        String methodName = methodFromTarget.getName();
        Object[] args = joinPoint.getArgs();
        args = Arrays.stream(args).filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse))).toArray();
        TimeInterval timer = DateUtil.timer();
        log.info("方法调用开始: 方法名: {}, 入参: {}", methodName, printParamAnnotation.inputArgs() ? formatParam(args) : null);
        Object result = joinPoint.proceed();
        log.info("方法调用结束: 方法名: {},调用时间:{}ms, 回参: {}", methodName, timer.intervalMs(), printParamAnnotation.outputArgs() ? formatParam(result) : null);
        return result;
    }

    /**
     * 格式化参数
     */
    private String formatParam(Object result) {
        String afterResult = "内容格式化失败";
        try {
            afterResult = JSONObject.toJSONStringWithDateFormat(result, DatePattern.NORM_DATETIME_PATTERN, SerializerFeature.WriteMapNullValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return afterResult;

    }
}
