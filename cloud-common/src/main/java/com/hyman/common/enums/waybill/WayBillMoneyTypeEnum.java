package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyman
 * @description: 运费金额趟数回显类型
 * @createTime: 2020/10/7
 */
@Getter
public enum WayBillMoneyTypeEnum {
    /**
     * 运单状态
     */
    DRIVER("driver", 0),
    LINE("line", 1),
    CONFIRMED("confirm", 2);

    private String name;
    private Integer code;

    WayBillMoneyTypeEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }


    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (WayBillMoneyTypeEnum wayBillStatusEnum : values()) {
                if (code.intValue() == wayBillStatusEnum.code) {
                    return wayBillStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
