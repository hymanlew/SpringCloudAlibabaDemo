package com.hyman.common.enums.driver;

/**
 * @author
 * @date 2019-10-25
 **/
public enum SelfDriverDepositStateEnum {
    INIT(0, "初始化"),
    PAYMENT_NOT_CONFIRMED(1, "微信收款尚未确认-待支付"),
    RECEIPT_CONFIRMATION(2, "微信收款已经确认-已支付"),
    RECEIPT_CONFIRMING(3, "微信收款确认中-支付中"),
    PAY_FAIL(4, "支付失败"),
    REFUND_NOT_CONFIRMED(5, "微信退款尚未确认-待审核"),
    REFUND_CONFIRMING(6, "微信退款确认中-退款中"),
    REFUND_CONFIRMATION(7, "微信退款已经确认-已退款"),
    REFUND_NOT_THROUGH(8, "退款审核不通过"),
    REFUND_FAIL(9, "退款失败")
    ;

    private Integer code;
    private String value;

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    SelfDriverDepositStateEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
