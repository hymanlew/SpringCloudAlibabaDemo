package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: tc
 * @create: 2019-04-25
 * @description: 户口类型
 **/
public enum HouseholdRegistrationTypeEnum {

    AUTHORIZE(1, "城镇户口"),
    RECOMMEND(2, "农村户口");

    private Integer code;
    private String value;

    HouseholdRegistrationTypeEnum(Integer code, String value) {
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
            for (HouseholdRegistrationTypeEnum driverStateEnum : values()) {
                if (code.equals(driverStateEnum.code)) {
                    return driverStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
