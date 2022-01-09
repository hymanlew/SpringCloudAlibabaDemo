package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: tianchong
 * @create: 2020-01-07
 * @description: 司机类型
 **/
public enum DriverTypeEnum {

    FIRMIANA(0, "梧桐专车"),
    PARTNER(1, "梧桐共享"),
    //SELF(2, "自承运/城配"),
    COMMON(99, "公共"),
    ;

    private Integer code;
    private String value;

    DriverTypeEnum(Integer code, String value) {
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
            for (DriverTypeEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverTypeEnum getByValue(int value) {
        for (DriverTypeEnum orderStateEnum : values()) {
            if (orderStateEnum.getCode() == value) {
                return orderStateEnum;
            }
        }
        return null;
    }
}
