package com.hyman.common.msg.sms;

import com.hyman.common.enums.SmsTemplateEnum;
import lombok.Data;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午2:08
 * @Description:
 */
@Data
public class SmsResponse extends Response {

    /**
     * 短信模板id
     */
    private SmsTemplateEnum templateEnum;


    /**
     * 接收者电话号码
     */
    private String phone;

    /**
     * 发送者（发送短信的源头方）
     */
    private String source;

    /**
     * 短信参数
     */
    private Object param;


}
