package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2020/12/9 10:08
 * @Describe ©
 */
public enum DriverMarKetClueTypeEnum {
    //special Take the car
    SPECIAL_TAKE_THE_CAR_TYPE(1, "专车带车"),
    //special Novice
    SPECIAL_NOVICE_TYPE(2, "专车小白"),
    //share Take the car
    SHARE_TAKE_THE_CAR_TYPE(3, "共享带车"),
    //share Novice
    TOBEINTERVIEWED_STATUS(4, "共享小白");

    private Integer code;
    private String value;

    DriverMarKetClueTypeEnum(Integer code, String value) {
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
            for (DriverMarKetClueTypeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverMarKetClueTypeEnum getByValue(int value) {
        for (DriverMarKetClueTypeEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
