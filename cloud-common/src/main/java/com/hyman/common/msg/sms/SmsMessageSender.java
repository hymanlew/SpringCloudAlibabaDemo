package com.hyman.common.msg.sms;

import cn.hutool.core.lang.PatternPool;
import com.alibaba.fastjson.JSON;
import com.hyman.common.enums.SmsTemplateEnum;
import com.hyman.common.feign.ICoreFeign;
import com.hyman.common.msg.Result;
import io.jsonwebtoken.lang.Assert;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午2:47
 * @Description:
 */
public class SmsMessageSender<T extends SmsMessage, R extends SmsResponse> extends AbstractMessageSender<T, R> {

    private final ICoreFeign coreFeign;

    public SmsMessageSender(ICoreFeign coreFeign, Executor executor) {
        super(executor);
        this.coreFeign = coreFeign;
    }

    public SmsMessageSender(ICoreFeign coreFeign) {
        this.coreFeign = coreFeign;
    }


    @Override
    protected boolean doSend(T msg, int tryTimes) {
        String phone = msg.getToSbId();
        Map<String, Object> param = msg.getParam();
        SmsTemplateEnum templateEnum = msg.getTemplateEnum();
        Assert.isTrue(PatternPool.MOBILE.matcher(phone).matches(), "手机号不合法");
        Assert.notNull(templateEnum, "短信模板不能为空");
        Result<Object> sendSmsResult = null;
        try {
            sendSmsResult = coreFeign.sendSms(phone, JSON.toJSONString(param), templateEnum.getCode());
        } finally {
            return Objects.nonNull(sendSmsResult) && sendSmsResult.getSuccess();
        }
    }

    @Override
    protected R afterSend(T msg, R smsResponse) {
        smsResponse.setPhone(msg.getToSbId());
        smsResponse.setSource(msg.getSource());
        smsResponse.setTemplateEnum(msg.getTemplateEnum());
        smsResponse.setParam(msg.getParam());
        return smsResponse;
    }

    @Override
    protected R getMeType() {
        return (R) new SmsResponse();
    }
}
