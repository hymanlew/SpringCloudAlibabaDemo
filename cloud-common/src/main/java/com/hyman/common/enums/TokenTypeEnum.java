package com.hyman.common.enums;

/**
 * @author:
 * @create: 2018-10-11
 * @description: token type 类型
 **/
public enum TokenTypeEnum {

    APP("1", "梧桐车服App端"),

    Applets("2", "小程序端"),

    BSS("3", "BSS端"),

    WuTongApplets("4", "梧桐小程序端登录");

    private String value;
    private String description;

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    TokenTypeEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static TokenTypeEnum getByValue(String value) {
        for (TokenTypeEnum tokenTypeEnum : values()) {
            if (tokenTypeEnum.getValue().equals(value)) {
                return tokenTypeEnum;
            }
        }
        return null;
    }

}
