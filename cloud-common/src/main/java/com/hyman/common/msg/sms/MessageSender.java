package com.hyman.common.msg.sms;

import org.springframework.lang.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * @author Changyuan Su
 * @date 2020/12/7 上午11:45
 * @Description: 基础消息标准接口
 */
public interface MessageSender<T extends Message, R extends Response> {


    /**
     * 发送消息
     *
     * @param msg
     * @return
     */
    boolean send(T msg);


    /**
     * 有发送超时时间
     *
     * @param msg
     * @param duration
     * @param unit
     * @return
     */
    boolean send(T msg, long duration, TimeUnit unit);


    /**
     * 重试多次发送消息
     *
     * @param msg
     * @param tryTimes 重试次数，第一次不算，实际次数=tryTimes+1
     * @return
     */
    boolean send(T msg, int tryTimes);


    /**
     * 具有发送超时时间，重试多次发送消息
     *
     * @param msg
     * @param duration
     * @param unit
     * @return
     */
    boolean send(T msg, long duration, TimeUnit unit, int tryTimes);


    /**
     * 异步发送消息
     *
     * @param msg
     * @param listener 可以为空
     */
    void sendAsync(T msg, @Nullable Callback<R> listener);


}
