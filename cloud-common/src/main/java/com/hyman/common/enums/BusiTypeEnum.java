package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: tianchong
 * @create: 2020-01-11
 * @description: 业务类型
 **/
public enum BusiTypeEnum {

    /**
     * 七只鸟系统
     */
    FIRMIANA(0, "梧桐专车"),
    /*合伙系统*/
    PARTNER(1, "梧桐共享"),

    FIRMIANA_PARTNER(9, "共享/专车")
    //SELF(2, "自承运/城配"),
    ;

    private Integer code;
    private String value;

    BusiTypeEnum(Integer code, String value) {
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
            for (BusiTypeEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static BusiTypeEnum getByValue(int value) {
        for (BusiTypeEnum orderStateEnum : values()) {
            if (orderStateEnum.getCode() == value) {
                return orderStateEnum;
            }
        }
        return null;
    }
}
