package com.hyman.common.msg.sms;

import cn.hutool.core.lang.Assert;
import cn.hutool.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午2:22
 * @Description:
 */
@Slf4j
public abstract class AbstractMessageSender<T extends Message, R extends Response> implements MessageSender<T, R> {

    protected final Executor executor;

    public AbstractMessageSender() {
        Executor threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() << 2);
        this.executor = threadPool;
    }

    public AbstractMessageSender(Executor executor) {
        this.executor = executor;
    }

    @Override
    public boolean send(T msg) {
        return send(msg, Long.MAX_VALUE, TimeUnit.MILLISECONDS, 0);
    }

    @Override
    public boolean send(T msg, long duration, TimeUnit unit) {
        return send(msg, duration, unit, 0);
    }

    @Override
    public boolean send(T msg, int tryTimes) {
//        boolean res;
//        int tryTime = 0;
//        do {
//            res = send(msg);
//        } while (!res && tryTime++ <= tryTimes);
//        return res;

        return send(msg, Long.MAX_VALUE, TimeUnit.MILLISECONDS, tryTimes);
    }

    /**
     * 发送消息
     *
     * @param msg
     * @param duration 为约数，如果尝试发送一次的时间就超过了给定的值，那么也会忽略当前值继续执行
     * @param unit
     * @param tryTimes
     * @return
     */
    @Override
    public boolean send(T msg, long duration, TimeUnit unit, int tryTimes) {
        Assert.notNull(msg, "消息不能为空");
        if (0L == duration) {
            return false;
        }

        long start = System.currentTimeMillis();
        boolean res;
        int tryTime = 0;
        do {
            res = doSend(msg, tryTimes);
        } while (!res && (System.currentTimeMillis() - start) <= unit.toMillis(duration) && tryTime++ <= tryTimes);
        return res;
    }


    /**
     * 发送消息
     *
     * @param msg
     * @param tryTimes
     * @return
     */
    protected abstract boolean doSend(T msg, int tryTimes);

    @Override
    public void sendAsync(T msg, Callback<R> listener) {
        executor.execute(() -> {
            LocalDateTime now = LocalDateTime.now();
            boolean res = send(msg);
            log.debug("短信发送成功=[{}]", res);
            if (Objects.isNull(listener)) {
                return;
            }
            // fixme: 应该使用反射实例化对象才能解耦
//            R r = getType();
            R r = getMeType();
            r.setSendTime(now);
            r.setFinishedTime(LocalDateTime.now());
            afterSend(msg, r);
            if (res) {
                r.setCode(HttpStatus.HTTP_OK);
                listener.onSuccess(r);
            } else {
                r.setCode(HttpStatus.HTTP_BAD_REQUEST);
                listener.onFail(r, null);
            }
        });
    }

    /**
     * todo: 权宜之计，采用模板方法获取对象
     *
     * @return
     */
    protected R getMeType() {
        throw new UnsupportedOperationException("必须重写getMeType方法");
    }


    /**
     * 创建对象
     *
     * @return
     */
    private R getType() {
        R r = null;
        try {
            // fixme: 通过反射获取泛型对象
//            Type superClass = getClass().getGenericSuperclass();
//            Type type = ((ParameterizedType) superClass).getActualTypeArguments()[1];
//            Class<?> clazz = getRawType(type);
//            R r1 = (R) clazz.newInstance();


            // 通过反射获取model的真实类型
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<R> clazz = (Class<R>) pt.getActualTypeArguments()[1];
//             通过反射创建model的实例
            r = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return r;
    }

    /**
     * 异步发送后，处理响应结果
     *
     * @param r
     * @param msg
     * @return
     */
    protected abstract R afterSend(T msg, R r);


    // type不能直接实例化对象，通过type获取class的类型，然后实例化对象
    private Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            return Array.newInstance(getRawType(componentType), 0).getClass();
        } else if (type instanceof TypeVariable) {
            return Object.class;
        } else if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + className);
        }
    }

}
