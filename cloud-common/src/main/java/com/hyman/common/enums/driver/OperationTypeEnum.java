package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2021/3/6 10:51
 * @Describe
 */
public enum OperationTypeEnum {
    CANCEL_INTERVIEW(1, "取消面试"),
    SIGN_CANCEL_INTERVIEW(2, "标记爽约");

    private Integer code;
    private String value;

    OperationTypeEnum(int code, String value) {
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
            for (OperationTypeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static OperationTypeEnum getByValue(int value) {
        for (OperationTypeEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
