package com.hyman.common.enums.order;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2021/4/20 13:48
 * @Describe
 */
public enum OrderTerminationReasonsEnum {
    REFUND(1, "退费"),
    ORDER_ERROR(2, "订单录错"),
    ;

    private Integer code;
    private String value;

    OrderTerminationReasonsEnum(Integer code, String value) {
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
            for (OrderTerminationReasonsEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static OrderTerminationReasonsEnum getByValue(int value) {
        for (OrderTerminationReasonsEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
