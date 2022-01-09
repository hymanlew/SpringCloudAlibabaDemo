package com.hyman.common.msg.sms;

import lombok.Data;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午2:08
 * @Description:
 */
@Data
public class VerifySmsResponse extends SmsResponse {

    /**
     * 验证码
     */
    private String verifyCode;


    /**
     * 耗费时长,单位：毫秒
     */
    private long time;

}
