package com.hyman.common.msg.sms;

import com.hyman.common.feign.ICoreFeign;

import java.util.concurrent.Executor;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午3:51
 * @Description:
 */
public class VerifySmsMessageSender extends SmsMessageSender {
    public VerifySmsMessageSender(ICoreFeign coreFeign, Executor executor) {
        super(coreFeign, executor);
    }


}
