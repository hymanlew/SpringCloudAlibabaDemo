package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Param
 * @Return
 * @Date 2020/7/9 10:23
 * @Describe ©
 */
public enum DriverStatusEnum {

    FOLLOW_DOWN(1, "待跟进", 10),
    FOLLOW_UP(2,"已跟进",10),
    COMPLETED(3,"已成交",10),
    ABANDONED(4,"已放弃",10),
    ;


    private Integer code;
    private String value;
    private Integer sort;

    DriverStatusEnum(Integer code, String value, Integer sort) {
        this.code = code;
        this.value = value;
        this.sort = sort;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public Integer getSort() {
        return sort;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (DriverStatusEnum driverStateEnum : values()) {
                if (code.equals(driverStateEnum.code)) {
                    return driverStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverStatusEnum getByValue(int value) {
        for (DriverStatusEnum driverStateEnum : values()) {
            if (driverStateEnum.getCode() == value) {
                return driverStateEnum;
            }
        }
        return null;
    }
}
