package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @description:
 * @author: WuYangXu
 * @date: 2020/8/31
 */
@Getter
public enum DroppedReasonEnum {

    CUSTOMER_NOT_COPPERATING(1, "客户不合作/撤线"),
    DEMAND_CHANGE(2, "配送要求变更"),
    DRIVER_SKIP_ORDER(3, "司机跳单"),
    DRIVER_CHANGE_LINE(4, "司机换线"),
    TIME_OUT(5, "系统超时"),
    MIGRATION_DROPPED(6,"数据迁移掉线"),
    CREATE_HISTORICAL(7,"创建历史试跑"),
    DRIVER_NOT_COPPERATING (8,"司机不合作"),
    OTHER(9,"其他");


    private Integer code;
    private String name;

    DroppedReasonEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (DroppedReasonEnum droppedReasonEnum : values()) {
                if (code.intValue() == droppedReasonEnum.code) {
                    return droppedReasonEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }


    public static DroppedReasonEnum getEnum(Integer code) {
        if (code != null) {
            for (DroppedReasonEnum droppedReasonEnum : values()) {
                if (code.intValue() == droppedReasonEnum.code) {
                    return droppedReasonEnum;
                }
            }
        }
        return null;
    }
}
