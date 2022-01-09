package com.hyman.common.enums.bill;

/**
 * 财务科目
 * Created by tc on 2018/11/16.
 */
public enum FinanceSubjectEnum {
    /**
     * 前两位：
     * 10商品消费 11提现、转账
     * 55收入
     */
    ORDER_PAY_MANAGEMENTFEE_FIRST(1001, "线路服务费-首款"),
    ORDER_PAY_MANAGEMENTFEE_END(1002, "线路服务费-尾款"),
    ORDER_PAY_OIL(1003, "梧桐加油宝"),
    CASH_OUT_BALANCE(1101, "余额提现"),
    DRIVER_RECOMMEND_REWARD(5501, "推荐司机奖励"),;

    private Integer code;
    private String name;

    FinanceSubjectEnum(Integer code, String name) {
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
