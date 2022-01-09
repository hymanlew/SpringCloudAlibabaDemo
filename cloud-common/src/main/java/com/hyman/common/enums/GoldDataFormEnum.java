package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: tianchong
 * @create: 2020-01-08
 * @description: 金数据表单
 **/
public enum GoldDataFormEnum {

    FIRMIANA_DRIVER_INTERVIEW("AleZyO", "梧桐专车司机面试表"),
    PARTNER_DRIVER_INTERVIEW("qx2KCY", "梧桐共享司机面试表"),
    FIRMIANA_DRIVER_ASSESSMENT("gKsmHG", "梧桐专车司机评估表"),
    LINE_CUSTOMER_VISIT_FOLLOW("bkJFgS", "线路客户拜访跟进表"),
    ;

    private String code;
    private String value;

    GoldDataFormEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }


    public static String getValueByCode(String code) {
        if (code != null) {
            for (GoldDataFormEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
