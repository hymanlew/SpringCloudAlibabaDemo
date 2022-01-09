package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyman
 * @description:
 * @createTime: 2020/10/16
 */
@Getter
public enum WayBillChangeTypeEnum {
    /**
     * 运单调整变动类型
     */
    INIT("初始化",0),
    NOT_REPORTED("待上报", 5),
    TO_BE_CONFIRMED("待单边确认", 10),
    CONFIRMED("单边已确认", 20),
    SECOND_TO_BE_CONFIRMED("待交叉确认", 30),
    SECOND_CONFIRMED("已交叉确认", 40),
    ADUJUST("运费调整",50);

    private String name;
    private Integer code;

    WayBillChangeTypeEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }


    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (WayBillChangeTypeEnum wayBillStatusEnum : values()) {
                if (code.intValue() == wayBillStatusEnum.code) {
                    return wayBillStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
