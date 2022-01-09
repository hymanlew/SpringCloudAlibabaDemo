package com.hyman.common.enums.bill;

/**
 * 支付操作类型
 * Created by tc on 2018/10/23.
 */
public enum PayOperateTypeEnum {
    FULL(1, "全款支付"),
    DEPOSIT(2, "押金支付"),
    FIRST(3, "首款支付"),
    TAIL(4, "尾款支付"),;

    private Integer code;
    private String name;

    PayOperateTypeEnum(Integer code, String name) {
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
