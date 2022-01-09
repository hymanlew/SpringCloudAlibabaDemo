package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Param
 * @Return
 * @Date 2020/7/30 11:53
 * @Describe ©
 */
public enum DriverBusiTypeEnum {
    /**
     * 三足金乌系统
     */
    FIRMIANA(0, "专车"),

    PARTNER(1, "共享"),
    ;

    private Integer code;
    private String value;

    DriverBusiTypeEnum(Integer code, String value) {
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
            for (DriverBusiTypeEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverBusiTypeEnum getByValue(int value) {
        for (DriverBusiTypeEnum orderStateEnum : values()) {
            if (orderStateEnum.getCode() == value) {
                return orderStateEnum;
            }
        }
        return null;
    }
}
