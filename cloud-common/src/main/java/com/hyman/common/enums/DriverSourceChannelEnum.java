package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Param
 * @Return
 * @Date 2020/7/15 14:15
 * @Describe ©
 */
public enum DriverSourceChannelEnum {

    DRIVER_SOURCE_CHANNEL_INVIEW(1,"面试转化"),
    DRIVER_SOURCE_CHANNEL_CREATE(2,"自动创建"),
            ;

    private Integer code;
    private String value;

    DriverSourceChannelEnum(Integer code, String value) {
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
            for (DriverSourceChannelEnum driverSourceChannelEnum : values()) {
                if (code.equals(driverSourceChannelEnum.code)) {
                    return driverSourceChannelEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverSourceChannelEnum getByValue(int value) {
        for (DriverSourceChannelEnum driverSourceChannelEnum : values()) {
            if (driverSourceChannelEnum.getCode() == value) {
                return driverSourceChannelEnum;
            }
        }
        return null;
    }
}
