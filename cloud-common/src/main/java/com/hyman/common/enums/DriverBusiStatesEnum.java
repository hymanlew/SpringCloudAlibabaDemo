package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2020/8/27 14:38
 * @Describe ©
 */
public enum DriverBusiStatesEnum {

    INTERVIEWED(1, "已面试"),
    TODEAL(2, "待成交"),
    COMPLETED(3, "已成交"),
    ONDUTY(4,"已上岗"),
    EXITED(5,"已终止服务"),
    ;

    private Integer code;
    private String value;

    DriverBusiStatesEnum(Integer code, String value) {
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
            for (DriverBusiStatesEnum d : values()) {
                if (code.equals(d.code)) {
                    return d.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverBusiStatesEnum getByValue(int value) {
        for (DriverBusiStatesEnum d : values()) {
            if (d.getCode() == value) {
                return d;
            }
        }
        return null;
    }
}
