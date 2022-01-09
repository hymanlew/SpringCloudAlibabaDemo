package com.hyman.common.enums.driver;

public enum DriverChannelStatusEnum {
    ENABLE(1,"启用"),
    DISABLE(2,"禁用");


    private Integer code;
    private String value;

    DriverChannelStatusEnum(Integer code, String value) {
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
