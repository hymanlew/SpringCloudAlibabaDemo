package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyman
 * @description:
 * @createTime: 2020/10/14
 */
@Getter
public enum WayBillCarStatusEnum {
    /**
     * 运单状态
     */
    WAIT_CAR("待出车", 0),
    NOT_CAR("未出车", 1),
    HAVE_CAR("已出车", 2);

    private String name;
    private Integer code;

    WayBillCarStatusEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (WayBillCarStatusEnum wayBillGMSaleStatusEnum : values()) {
                if (code.intValue() == wayBillGMSaleStatusEnum.code) {
                    return wayBillGMSaleStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
