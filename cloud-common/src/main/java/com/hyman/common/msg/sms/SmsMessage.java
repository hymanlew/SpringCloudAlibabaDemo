package com.hyman.common.msg.sms;

import com.hyman.common.enums.SmsTemplateEnum;
import lombok.Data;

import java.util.Map;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午2:57
 * @Description:
 */
@Data
public class SmsMessage extends Message {

    /**
     * 短信模板id
     */
    private SmsTemplateEnum templateEnum;

    /**
     * 发送者（发送短信的源头方）
     */
    private String source;

    /**
     * 短信参数
     */
    private Map<String, Object> param;


}
