package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sun
 * @Date 2021/7/1
 * @Describe 母人群枚举
 */
public enum DriverCrowdEnum {

    NOVICE(1, "小白"),
    BRING_CAR(2, "带车"),
    DRIVE_DRIVER(3, "开车司机");

    private Integer code;
    private String value;

    DriverCrowdEnum(Integer code, String value) {
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
            for (DriverCrowdEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverCrowdEnum getByValue(int value) {
        for (DriverCrowdEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}