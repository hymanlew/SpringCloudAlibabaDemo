package com.hyman.common.enums.order;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @description:
 * @author: hyman
 * @date: 2020/7/8
 */
@Getter
public enum DeliverStatusEnum {


    NOT_DELIVERED("待交付", 0),
    DELIVERED("已交付", 1);

    private String Name;
    private Integer code;

    DeliverStatusEnum(String Name, Integer code) {
        this.Name = Name;
        this.code = code;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (DeliverStatusEnum deliverStatusEnum : values()) {
                if (code.intValue() == deliverStatusEnum.code) {
                    return deliverStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

}
