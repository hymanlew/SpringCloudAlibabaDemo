package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangyanuo
 * @Date 2020/4/26
 * @Describe 成交日期标签-枚举
 */
public enum DealDateLabelEnum {

    NOTDEALED(1, "未成交"),
    DEALED(2, "已成交"),
    EXITED(3, "已退出");

    private Integer code;
    private String value;

    DealDateLabelEnum(int code, String value) {
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
            for (DealDateLabelEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DealDateLabelEnum getByValue(int value) {
        for (DealDateLabelEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
