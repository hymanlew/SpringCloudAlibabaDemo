package com.hyman.common.enums.order;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @description:订单状态
 * @author: hyman
 * @date: 2020/7/7
 */
@Getter
public enum OrderStatusEnum {

    INIT(0,"初始化"),
    TO_BE_PAY(5, "待支付"),
    HAVE_CANCEL(10, "已取消"),
    TO_CONFIRM(15, "待确认"),
    TO_AUDIT(20, "待审核"),
    AUDIT_NOT_PASS(25, "审核不通过"),
    HAVE_DEAL(30, "已成交"),
    TO_REFUND(35, "待退款"),
    HAVE_REFUND(40, "已退款"),
    HAVE_ABORT(45,"已终止");

    /**
     * 订单状态code
     */
    private Integer code;
    /**
     * 订单状态名字
     */
    private String name;

    OrderStatusEnum(Integer code, String Name) {
        this.name = Name;
        this.code = code;
    }


    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (OrderStatusEnum orderStatusEnum : values()) {
                if (code.intValue() == orderStatusEnum.code) {
                    return orderStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}

