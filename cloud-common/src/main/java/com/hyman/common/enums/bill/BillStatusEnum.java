package com.hyman.common.enums.bill;

/**
 * 账单状态
 * Created by tc on 2018/11/16.
 */
public enum BillStatusEnum {
    WAIT(0, "待处理"),
    ONGOING(1, "进行中"),
    SUCCESS(2, "成功"),
    FAIL(3, "失败"),
    REFUND(4, "退款"),;

    private Integer code;
    private String name;

    BillStatusEnum(Integer code, String name) {
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
