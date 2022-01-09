package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2020/9/28 10:09
 * @Describe 司机线索状态枚举
 */
public enum DriverClueEnum {

    TOBEFOLLOWUP(1, "待跟进"),
    CONVERTED(2, "已转化"),
    ;

    private Integer code;
    private String value;

    DriverClueEnum(Integer code, String value) {
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
            for (DriverClueEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverClueEnum getByValue(int value) {
        for (DriverClueEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
