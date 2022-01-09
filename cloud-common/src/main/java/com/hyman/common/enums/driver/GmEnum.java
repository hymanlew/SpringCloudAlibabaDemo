package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangchenghao
 * @Date 2020/9/27 16:39
 * @Describe 经理枚举
 */
public enum  GmEnum {

    SC(1, "渠道经理"),
    GM(2, "加盟经理");

    private Integer code;
    private String value;

    GmEnum(int code, String value) {
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
            for (GmEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static GmEnum getByValue(int value) {
        for (GmEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
