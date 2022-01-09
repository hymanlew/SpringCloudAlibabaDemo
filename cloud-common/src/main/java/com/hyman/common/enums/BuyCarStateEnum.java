package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author:
 * @create: 2019-04-11
 * @description: 买车状态
 **/
public enum BuyCarStateEnum {

    NOINIT(0, "未初始化，当前状态不应该存在"),

    NOTYET(1, "未交付"),// 显示 车辆交付 按钮
    DELIVERY(2, "待上岗"),// 显示 上岗 按钮
    HAVINGGOTOWORK(3, "已交付已上岗"),// 不显示  按钮
    ;

    private Integer code;
    private String value;

    BuyCarStateEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (BuyCarStateEnum buyCarStateEnum : values()) {
                if (code.equals(buyCarStateEnum.code)) {
                    return buyCarStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static BuyCarStateEnum getByValue(int value) {
        for (BuyCarStateEnum buyCarStateEnum : values()) {
            if (buyCarStateEnum.getCode() == value) {
                return buyCarStateEnum;
            }
        }
        return null;
    }
}
