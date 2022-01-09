package com.hyman.common.enums.order;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: xiefujiang
 * @create: 2020-08-7
 * @description: 订单状态
 **/
public enum QznOrderStateEnum {

    DELETE(-1, "订单删除"),

    NOINIT(0, "未初始化，当前状态下的订单不应该存在"),

    NOTYET(1, "待成交"),
    DEAL(2, "成交"),
    DOWN(3, "下线"),
    PAIDTOBECONFIRMED(4, "已支付待确认"),
    CONFIRMREJECTION(5, "确认驳回"),
    TERMINATED(10, "已终止"),
    ;

    private Integer code;
    private String value;

    QznOrderStateEnum(Integer code, String value) {
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
            for (QznOrderStateEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static QznOrderStateEnum getByValue(int value) {
        for (QznOrderStateEnum orderStateEnum : values()) {
            if (orderStateEnum.getCode() == value) {
                return orderStateEnum;
            }
        }
        return null;
    }
}
