package com.hyman.common.enums.bill;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2020/11/25 11:23
 * @Describe 退款方式枚举
 */
public enum RefundTypeEnum {
    WECHAT(1, "微信"),
    ALIPAY(2, "支付宝"),
    CREDIT_CARD(3, "信用卡"),
    CASH(4, "现金"),
    SELF_CARRIAGE(5, "自承运"),
    BANK_CARD(6, "银行卡"),
    ;

    private Integer code;
    private String value;

    RefundTypeEnum(int code, String value) {
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
            for (RefundTypeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static RefundTypeEnum getByValue(int value) {
        for (RefundTypeEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
