package com.hyman.common.enums.bill;

/**
 * 账单类型
 * Created by tc on 2018/12/24.
 */
public enum BillTypeEnum {
    IN(1, "收入"),
    OUT(2, "支出");

    private Integer code;
    private String name;

    BillTypeEnum(Integer code, String name) {
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
