package com.hyman.common.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.assertj.core.util.Lists;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 提供一些常用的工具方法
 *
 * @author wanghaitong
 * @date 2020/12/15 下午5:15
 */
public class AopUtil {

    /**
     * 获取方法上的注解
     *
     * @param joinPoint       方法入参
     * @param annotationClass 注解的Class
     * @param <T>             注解类型
     * @return 方法上的注解
     */
    public static <T extends Annotation> T getMethodAnnotation(JoinPoint joinPoint, Class<T> annotationClass) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        return method.getAnnotation(annotationClass);
    }

    public static <T extends Annotation> Object getParamValueWithAnnotation(JoinPoint joinPoint, Class<T> annotationClass) {
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return null;
        }

        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        Integer index = getParamValueFromMethod(annotationClass, method);
        return index == null ? null : args[index];
    }

    public static List<Object> getParamValueByFieldName(JoinPoint joinPoint, String fieldName) {
        List<Object> result = Lists.newArrayList();
        // 参数值
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return result;
        }
        try {
            for (Object arg : args) {
                Class<?> clazz = arg.getClass();
                // 防止父类中有子类的成员变量，导致一直循环
                int deepCount = 0;
                while (clazz != null && deepCount < 5) {
                    Field[] declaredFields = clazz.getDeclaredFields();
                    Optional<Field> fieldOptional = Arrays.stream(declaredFields).filter(e -> Objects.equals(e.getName(), fieldName)).findAny();
                    if (fieldOptional.isPresent()) {
                        Field field = fieldOptional.get();
                        field.setAccessible(true);
                        result.add(field.get(arg));
                        field.setAccessible(false);
                    }
                    clazz = clazz.getSuperclass();
                    deepCount ++;
                }
            }
        } catch (Exception e) {
            // ignore e
        }
        return result;
    }

    public static <T extends Annotation> Integer getParamValueFromMethod(Class<T> annotationClass, Method method) {
        Annotation[][] paramAnnotations = method.getParameterAnnotations();
        if (paramAnnotations.length == 0) {
            return null;
        }

        for (int i = 0, annotationsLength = paramAnnotations.length; i < annotationsLength; i++) {
            Annotation[] paramAnnotation = paramAnnotations[i];
            if (paramAnnotation == null || paramAnnotation.length == 0) {
                continue;
            }

            for (Annotation annotation : paramAnnotation) {
                if (annotation.annotationType().equals(annotationClass)) {
                    return i;
                }
            }
        }
        return null;
    }
}
