package com.hyman.common.enums.order;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @description:
 * @author: ChenJingBin
 * @date: 2020/7/8
 */
@Getter
public enum PriceTypeEnum {


    PURCHASE_PRICE("采购价", 0),
    SALE_PRICE("销售价", 1),
    REBATE_PRICE("返利",2);

    private String Name;
    private Integer code;

    PriceTypeEnum(String Name, Integer code) {
        this.Name = Name;
        this.code = code;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (PriceTypeEnum p : values()) {
                if (code.intValue() == p.code) {
                    return p.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

}