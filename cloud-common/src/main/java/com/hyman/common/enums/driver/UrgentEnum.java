package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2021/5/8 11:11
 * @Describe 司机情况
 */
public enum UrgentEnum {
    ZJSP(1, "着急试跑"),
    XGC(2, "想跟车"),
    XHSJTK(3, "吓唬司撮退款"),
    BSTF(4, "不想退费"),
    XQJ(5, "想请假"),
    TLXXTF(6, "铁了心要退费"),
    BGWDDH(7, "别给我打电话"),
    ;

    private Integer code;
    private String value;

    UrgentEnum(Integer code, String value) {
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
            for (UrgentEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static UrgentEnum getByValue(int value) {
        for (UrgentEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
