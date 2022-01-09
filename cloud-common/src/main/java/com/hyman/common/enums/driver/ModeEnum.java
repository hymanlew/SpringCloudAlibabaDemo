package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangchenghao
 * @Date 2020/9/27 16:39
 * @Describe 线索来源/方式枚举
 */
public enum ModeEnum {

    ALL(0, "全部"),
    SCAN_QRCODE(1, "扫加盟渠道码"),
    FORWARD(2, "转发"),
    WRITE_RECOMMENDATION_INFO(3, "填写推荐信息"),
    OTHER(4, "其他");

    private Integer code;
    private String value;

    ModeEnum(int code, String value) {
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
            for (ModeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static ModeEnum getByValue(int value) {
        for (ModeEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
