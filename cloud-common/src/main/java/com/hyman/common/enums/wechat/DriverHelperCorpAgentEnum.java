package com.hyman.common.enums.wechat;

/**
 * @author: tianc
 * @create: 2020-03-10
 * @description: 企业微信应用-司机助手（朱雀）
 **/
public enum DriverHelperCorpAgentEnum {

    D2("d2", 1000015),
    M1("m1", 1000013),
    PROD("prod", 1000016),
    ;

    private String code;
    private Integer value;

    DriverHelperCorpAgentEnum(String code, Integer value) {
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
            for (DriverHelperCorpAgentEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return null;
    }

}
