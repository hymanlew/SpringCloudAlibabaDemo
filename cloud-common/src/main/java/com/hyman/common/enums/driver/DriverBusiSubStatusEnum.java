package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2021/3/30 16:40
 * @Describe
 */
public enum DriverBusiSubStatusEnum {

    INTERVIEWED(10, "已面试"),
    TOBEREVIEWED(20, "待审核"),
    REJECTED(30, "已驳回"),
    WAITINGRUN(40, "待试跑"),
    COMPLETEDRUN(50, "已试跑"),
    REFUNDPROGRESS(60, "退费中"),
    REFUNDED(70, "已退费"),
    ORDERERROR(80, "订单录错"),
    ;

    private Integer code;
    private String value;

    DriverBusiSubStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }


    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (DriverBusiSubStatusEnum d : values()) {
                if (code.equals(d.code)) {
                    return d.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverBusiSubStatusEnum getByValue(int value) {
        for (DriverBusiSubStatusEnum d : values()) {
            if (d.getCode() == value) {
                return d;
            }
        }
        return null;
    }
}
