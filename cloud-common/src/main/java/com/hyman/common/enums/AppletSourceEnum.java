package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: tianchong
 * @create: 2019-12-18
 * @description: 小程序来源
 **/
public enum AppletSourceEnum {

    FIRMIANA(0, "梧桐专车"),
    PARTNER(1, "梧桐共享"),
    SELF(2, "自承运/城配"),
    ;

    private Integer code;
    private String value;

    AppletSourceEnum(Integer code, String value) {
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
            for (AppletSourceEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static AppletSourceEnum getByValue(int value) {
        for (AppletSourceEnum orderStateEnum : values()) {
            if (orderStateEnum.getCode() == value) {
                return orderStateEnum;
            }
        }
        return null;
    }
}
