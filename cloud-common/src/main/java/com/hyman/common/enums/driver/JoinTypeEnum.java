package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2020/9/27 19:59
 */
public enum JoinTypeEnum {
    ALL(0, "全部"),
    WECHAT_AUTH(1, "微信授权"),
    SETTLED(2, "入驻"),
    RECOMMEND(3, "推荐");

    private Integer code;
    private String value;


    JoinTypeEnum(Integer code, String value) {
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
            for (JoinTypeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static JoinTypeEnum getByValue(int value) {
        for (JoinTypeEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
