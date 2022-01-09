package com.hyman.common.enums.bill;

/**
 * 校验订单金额与已支付金额和支付金额总和的关系结果枚举类
 */
public enum VerifyOrderPayMoneyEnum {

    ORDER_MONEY_GT_PAY_MONEY_SUM(1, "订单金额大于支付金额"),
    ORDER_MONEY_EQ_PAY_MONEY_SUM(0, "订单金额等于支付金额"),
    ORDER_MONEY_LT_PAY_MONEY_SUM(-1, "订单金额小于支付金额"),;

    private Integer code;
    private String name;

    VerifyOrderPayMoneyEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
