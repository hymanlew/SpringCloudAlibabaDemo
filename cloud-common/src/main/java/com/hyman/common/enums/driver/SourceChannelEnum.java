package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangchenghao
 * @Date 2020/9/27 16:39
 * @Describe 线索渠道/来源枚举
 */
public enum SourceChannelEnum {

    WTXQ_APPLET(0, "梧桐喜雀小程序"),
    WTYQ_APPLET(1, "梧桐云雀小程序"),
    ALL(2, "全部");

    private Integer code;
    private String value;

    SourceChannelEnum(Integer code, String value) {
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
            for (SourceChannelEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static SourceChannelEnum getByValue(int value) {
        for (SourceChannelEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }


}
