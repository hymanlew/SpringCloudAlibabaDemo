package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangchenghao
 * @Date 2020/9/27 16:39
 * @Describe 线索是否成交枚举
 */
public enum ClueDealStatusEnum {
    NOT_DEAL(0, "未成交"),
    IS_DEAL(1, "已成交"),
    ;

    private Integer code;
    private String value;

    ClueDealStatusEnum(int code, String value) {
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
            for (ClueDealStatusEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static ClueDealStatusEnum getByValue(int value) {
        for (ClueDealStatusEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
