package com.hyman.common.msg.sms;

import org.apache.commons.lang3.RandomStringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午3:52
 * @Description:
 */
public interface VerifySmsSender<T extends VerifySmsMessage, R extends VerifySmsResponse> {

    /**
     * 默认验证码长度，6位
     */
    int DEFAULT_VERIFY_CODE_LENGTH = 6;

    /**
     * 发送验证码,默认是6位验证码
     *
     * @param msg
     * @return
     */
    default R sendCode(@NotNull T msg) {
        final String code = RandomStringUtils.randomNumeric(DEFAULT_VERIFY_CODE_LENGTH);
        return sendCode(msg, code);
    }


    /**
     * 强制发送code
     *
     * @param msg
     * @return
     */
    default R forceSendCode(@NotNull T msg) {
        final String code = RandomStringUtils.randomNumeric(DEFAULT_VERIFY_CODE_LENGTH);
        return forceSendCode(msg, code);
    }

    /**
     * 强制发送code
     *
     * @param msg
     * @param code
     * @return
     */
    default R forceSendCode(@NotNull T msg, @NotBlank String code) {
        clear(msg.getToSbId());
        return sendCode(msg, code);
    }


    /**
     * 发送验证码
     *
     * @param msg
     * @param code 验证码
     * @return
     */
    R sendCode(@NotNull T msg, @NotBlank String code);

    /**
     * 异步发送验证码,默认6位
     *
     * @param msg
     * @param listener
     */
    default void sendCode(T msg, Callback<R> listener) {
        sendCode(msg, RandomStringUtils.randomNumeric(DEFAULT_VERIFY_CODE_LENGTH), listener);
    }

    /**
     * 异步发送验证码
     *
     * @param msg
     * @param code
     * @param listener
     */
    void sendCode(T msg, @NotBlank String code, Callback<R> listener);


    /**
     * 是否允许重发
     *
     * @param phone
     * @return
     */
    boolean isAllowRepeatSend(@NotBlank String phone);


    /**
     * 验证码是否过期
     *
     * @param phone
     * @return
     */
    boolean isCodeExpired(@NotBlank String phone);


    /**
     * 获取验证码
     *
     * @param phone
     * @return
     */
    String getCode(@NotBlank String phone);

    /**
     * 清除所有数据
     *
     * @param phone
     * @return
     */
    boolean clear(@NotBlank String phone);

    /**
     * 根据手机号获取最后一次发送验证码的时间戳
     *
     * @param phone 手机号
     * @return 上次给当前手机号发验证码的时间戳
     */
    long getLastSendTime(@NotBlank String phone);


//    /**
//     * 获取下次可以发送验证码的时间间隔
//     *
//     * @param phone 手机号
//     * @return 获取下次可以发送验证码的时间间隔，单位：ms
//     */
//    default long getDurationOfNext(@NotBlank String phone) {
//        long lastSendTime = getLastSendTime(phone);
//        return 0L == lastSendTime ? 0L : lastSendTime;
//    }

    /**
     * 获取下次可以发送验证码的时间距离现在的秒数
     *
     * @param phone
     * @return 下次可以发送验证码的时间距离现在的秒数 如果返回0，则代表现在就可以发送
     */
    long getDelaySecondsOfNext(@NotBlank String phone);


}
