package com.hyman.common.enums.wechat;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: tianc
 * @create: 2020-03-10
 * @description: 企业微信应用
 **/
public enum CorpAgentEnum {

    ADDRESS_BOOK(8888888, "通讯录"),
    EXTERNAL_CONTACT(9000001, "客户联系"),
    DRIVER_LINE_GMV_REMIND(1000014, "司机运费上报助手"),
    FIRMIANA_MEMBER(1000019, "梧桐会员"),
    ;

    private Integer code;
    private String value;

    CorpAgentEnum(Integer code, String value) {
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
            for (CorpAgentEnum orderStateEnum : values()) {
                if (code.equals(orderStateEnum.code)) {
                    return orderStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static CorpAgentEnum getByValue(int value) {
        for (CorpAgentEnum orderStateEnum : values()) {
            if (orderStateEnum.getCode() == value) {
                return orderStateEnum;
            }
        }
        return null;
    }


}
