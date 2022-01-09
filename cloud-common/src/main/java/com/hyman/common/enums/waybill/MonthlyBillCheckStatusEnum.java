package com.hyman.common.enums.waybill;

/**
 * 对账状态
 *
 * @author wanghaitong
 * @date 2020/9/29 17:01
 */
public enum MonthlyBillCheckStatusEnum {
    /**
     * 对账状态
     */
    UNCHECK(0, "待对账"),
    CHECKED(1, "已对账");

    private Integer code;
    private String name;

    MonthlyBillCheckStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
