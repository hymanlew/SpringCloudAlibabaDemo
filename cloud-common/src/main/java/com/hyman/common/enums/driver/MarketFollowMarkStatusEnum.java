package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2021/3/4 11:11
 * @Describe 线下跟进标记状态
 */
public enum MarketFollowMarkStatusEnum {

    CAN_INTO_THE_POOL_FOLLOW(1, "可入池"),

    NO_INTO_THE_POOL_FOLLOW(2, "不可入池"),

    WAIT_INTO_THE_POOL_FOLLOW(3, "待入池"),

    ALREAD_POOL_FOLLOW(4, "已入池"),

    INTENTION_FOLLOW(5, "有意向"),

    NOT_INTENTION_FOLLOW(6, "无意向"),

    ALREAD_TO_FANCY_FOLLOW(7, "已看中"),

    DEAL_STATUS_FOLLOW(8, "已成交");

    private Integer code;
    private String value;

    MarketFollowMarkStatusEnum(Integer code, String value) {
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
            for (MarketFollowMarkStatusEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static MarketFollowMarkStatusEnum getByValue(int value) {
        for (MarketFollowMarkStatusEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
