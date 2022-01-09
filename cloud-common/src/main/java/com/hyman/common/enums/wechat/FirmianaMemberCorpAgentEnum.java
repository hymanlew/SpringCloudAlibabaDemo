package com.hyman.common.enums.wechat;

/**
 * @author: tianc
 * @create: 2020-03-10
 * @description: 企业微信应用-梧桐会员
 **/
public enum FirmianaMemberCorpAgentEnum {

    D2("d2", 1000020),
    M1("m1", 1000020),
    PROD("prod", 1000019),
    ;

    private String code;
    private Integer value;

    FirmianaMemberCorpAgentEnum(String code, Integer value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public Integer getValue() {
        return value;
    }


    public static Integer getValueByCode(String code) {
        if (code != null) {
            for (FirmianaMemberCorpAgentEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return null;
    }

}
