package com.hyman.common.enums.order;

import org.apache.commons.lang3.StringUtils;

/**
 * 退款状态
 * Created by tianc on 2019/8/28.
 */
public enum RefundStatusEnum {

    NULL(0, "空值"),
    WAIT_VERIFY(1, "待审核"),
    WAIT_REFUND(2, "审核通过（待退款）"),
    VERIFY_FAIL(3, "审核失败"),
    IN_REFUND(4, "退款中"),
    REFUND_COMPLETION(5, "退款成功"),
    FEFUND_FAIL(6, "退款失败"),;

    private Integer code;
    private String name;

    RefundStatusEnum(Integer code, String name) {
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
            for (RefundStatusEnum refundStatusEnum : values()) {
                if (code.equals(refundStatusEnum.code)) {
                    return refundStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
