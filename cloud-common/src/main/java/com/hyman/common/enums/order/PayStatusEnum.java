package com.hyman.common.enums.order;

import org.apache.commons.lang3.StringUtils;

/**
 * 支付状态
 * Created by tianc on 2019/8/28.
 */
public enum PayStatusEnum {

    NULL(0, "空值"),
    WAIT_PAYMENT(1, "待支付"),
    IN_PAYMENT(2, "支付中"),
    PAYMENT_COMPLETION(3, "支付完成"),
    PARTIAL_PAYMENT_COMPLETION(4, "部分支付完成"),
    PAYMENT_FAIL(5, "支付失败"),
    IN_TAIL_PAYMENT(6, "尾款支付中"),;

    private Integer code;
    private String name;

    PayStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (PayStatusEnum payStatusEnum : values()) {
                if (code.equals(payStatusEnum.code)) {
                    return payStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
