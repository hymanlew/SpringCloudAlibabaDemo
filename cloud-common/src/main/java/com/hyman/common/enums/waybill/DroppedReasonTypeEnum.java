package com.hyman.common.enums.waybill;

import lombok.Getter;

import java.util.Objects;

/**
 * @description:
 * @author: WuYangXu
 * @date: 2021/1/15
 */
@Getter
public enum DroppedReasonTypeEnum {

    CUSTOMER_REASON(1, "客户原因"),
    DRIVER_REASON(2, "司机原因"),
    SYSTEM_TIME_OUT(3, "系统超时"),
    DEFAULT(0, "系统默认");

    private Integer code;
    private String name;

    DroppedReasonTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


    public static String getNameByCode(Integer code) {
        if (Objects.nonNull(code)) {
            for (DroppedReasonTypeEnum droppedReasonTypeEnum : values()) {
                if (code.intValue() == droppedReasonTypeEnum.code) {
                    return droppedReasonTypeEnum.getName();
                }
            }
        }
        return DEFAULT.getName();
    }


    public static DroppedReasonTypeEnum getEnum(Integer code) {
        if (Objects.nonNull(code)) {
            for (DroppedReasonTypeEnum droppedReasonTypeEnum : values()) {
                if (code.intValue() == droppedReasonTypeEnum.code) {
                    return droppedReasonTypeEnum;
                }
            }
        }
        return DEFAULT;
    }

    /**
     * 判断线路是否直接下架不激活（true:直接下架，不激活   false：不直接下架，可能会激活）
     *
     * @param code
     * @return
     */
    public static Boolean isOffShelfForLine(Integer code) {
        if (Objects.nonNull(code)) {
            boolean customerNotCopperating = DroppedReasonEnum.CUSTOMER_NOT_COPPERATING.getCode().equals(code);
            boolean demandChange = DroppedReasonEnum.DEMAND_CHANGE.getCode().equals(code);
            boolean migrationDropped = DroppedReasonEnum.MIGRATION_DROPPED.getCode().equals(code);
            boolean createHistorical = DroppedReasonEnum.CREATE_HISTORICAL.getCode().equals(code);
            boolean other = DroppedReasonEnum.OTHER.getCode().equals(code);
            if (customerNotCopperating || demandChange || migrationDropped || createHistorical  || other) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }


    /**
     * 根据掉线原因获取掉线原因类型
     *
     * @param code
     * @return
     */
    public static Integer getDroppedReasonTypeByReason(Integer code) {
        if (Objects.nonNull(code)) {
            if (DroppedReasonEnum.CUSTOMER_NOT_COPPERATING.getCode().equals(code)
                    || DroppedReasonEnum.DEMAND_CHANGE.getCode().equals(code)) {
                return CUSTOMER_REASON.code;
            }
            if (DroppedReasonEnum.DRIVER_SKIP_ORDER.getCode().equals(code)
                    || DroppedReasonEnum.DRIVER_CHANGE_LINE.getCode().equals(code)) {
                return DRIVER_REASON.code;
            }
            if (DroppedReasonEnum.TIME_OUT.getCode().equals(code)) {
                return SYSTEM_TIME_OUT.code;
            }
        }
        return DEFAULT.code;
    }
}

