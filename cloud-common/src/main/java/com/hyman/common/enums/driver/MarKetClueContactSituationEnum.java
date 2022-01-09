package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2020/12/8 10:20
 * @Describe 市场部线索联系情况枚举
 */
public enum MarKetClueContactSituationEnum {

    //No intention 无意向
    NOINTENTION_SITUATION(1, "无意向"),
    //Intention 有意向
    INTENTION_SITUATION(2, "有意向"),
    //High intention 高意向
    HIGHINTENTION_SITUATION(3, "高意向"),
    //Contact later 稍后联系
    CONTACTLATER_SITUATION(4,"稍后联系"),
    //no answer 无人接听
    NOANSWER_SITUATION(5,"无人接听"),
    //Wrong number 号码错误
    WRONGNUMBER_SITUATION(6,"号码错误");

    private Integer code;
    private String value;

    MarKetClueContactSituationEnum(Integer code, String value) {
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
            for (MarKetClueContactSituationEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static MarKetClueContactSituationEnum getByValue(int value) {
        for (MarKetClueContactSituationEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
