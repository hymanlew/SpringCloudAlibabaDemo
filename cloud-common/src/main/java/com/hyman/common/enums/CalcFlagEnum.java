package com.hyman.common.enums;

/**
 * @author:
 * @create: 2019-08-16
 * @description: 同步司机收入
 **/
public enum CalcFlagEnum {

    START(1, "开始同步"),
    STOP(2, "停止同步"),
    ;

    private Integer code;
    private String value;

    CalcFlagEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
