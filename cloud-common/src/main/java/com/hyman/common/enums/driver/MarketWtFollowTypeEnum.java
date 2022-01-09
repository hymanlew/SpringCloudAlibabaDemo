package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2021/3/3 15:14
 * @Describe
 */
public enum MarketWtFollowTypeEnum {

    OFFLINE_FOLLOW(1, "线下跟进"),

    PHONE_FOLLOW(2, "电话跟进");

    private Integer code;
    private String value;

    MarketWtFollowTypeEnum(Integer code, String value) {
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
            for (MarketWtFollowTypeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static MarketWtFollowTypeEnum getByValue(int value) {
        for (MarketWtFollowTypeEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
