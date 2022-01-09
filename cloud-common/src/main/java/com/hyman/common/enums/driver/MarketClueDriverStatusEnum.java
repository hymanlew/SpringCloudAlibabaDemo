package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2021/3/2 11:15
 * @Describe 市场部线索状态
 */
public enum MarketClueDriverStatusEnum {

    TOBEALLOCATED_STATUS(0, "待分配"),

    TOBEFOLLOWEDUP_STATUS(10, "待跟进"),

    FOLLOWUP_STATUS(20, "跟进中"),

    CAN_INTO_THE_POOL(22, "可入池"),

    WAIT_INTO_THE_POOL(23, "待入池"),

    ALREAD_POOL(24, "已入池"),

    INTERVIEW_SUCCESS(30, "邀约成功"),

    INTENTION(32, "有意向"),

    ALREAD_TO_FANCY(35, "已看中"),

    INTERVIEWED_STATUS(40, "已面试"),

    DEAL_STATUS(50, "已成交");

    private Integer code;
    private String value;

    MarketClueDriverStatusEnum(Integer code, String value) {
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
            for (MarketClueDriverStatusEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static MarketClueDriverStatusEnum getByValue(int value) {
        for (MarketClueDriverStatusEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
