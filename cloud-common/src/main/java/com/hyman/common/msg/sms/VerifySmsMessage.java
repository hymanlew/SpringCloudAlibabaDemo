package com.hyman.common.msg.sms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午4:06
 * @Description:
 */
@Data
public class VerifySmsMessage extends SmsMessage {


    /**
     * 验证码
     */
    private String verifyCode;

    /**
     * 禁止重发时长,默认1min
     */
    private long repeatDuration = 1L;

    /**
     * 禁止重发时长单位
     */
    private TimeUnit repeatUnit = TimeUnit.MINUTES;

    /**
     * 失效时长,默认5min
     */
    private long expireDuration = 5L;

    /**
     * 失效时长单位
     */
    private TimeUnit expireUnit = TimeUnit.MINUTES;


    @JsonIgnore
    public long getRepeatTime() {
        return repeatUnit.toMillis(repeatDuration);
    }

    @JsonIgnore
    public long getExpireTime() {
        return expireUnit.toMillis(expireDuration);
    }

}
