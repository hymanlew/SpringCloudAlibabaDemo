package com.hyman.common.enums.waybill;

/**
 * 运费账户-账户状态枚举
 *
 * @author wanghaitong
 * @date 2020/9/30 10:05
 */
public enum ShippingAcctStatusEnum {
    /**
     * 运费账户状态
     */
    TO_BE_ACTIVATED(1, "待激活"),
    ACTIVATED(2, "正常"),
    FROZEN(3, "冻结"),

    ;

    private final Integer code;
    private final String name;

    ShippingAcctStatusEnum(Integer code, String name) {
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
