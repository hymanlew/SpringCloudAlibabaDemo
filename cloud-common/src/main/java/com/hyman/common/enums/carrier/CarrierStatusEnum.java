package com.hyman.common.enums.carrier;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lishuai
 */

public enum CarrierStatusEnum {

    /**
     * 待上岗
     */
    WAIT_TO_WORK(0, "待上岗"),
    /**
     * 上岗
     */
    WORKING(1, "上岗"),
    /**
     * 停用
     */
    STOP_WORK(2, "停用");

    private Integer code;
    private String value;

    CarrierStatusEnum(Integer code, String value) {
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
            for (CarrierStatusEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static CarrierStatusEnum getByValue(int value) {
        for (CarrierStatusEnum orderStateEnum : values()) {
            if (orderStateEnum.getCode() == value) {
                return orderStateEnum;
            }
        }
        return null;
    }
}
