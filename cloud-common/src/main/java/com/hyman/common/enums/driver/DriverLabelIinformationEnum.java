package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2021/4/22 17:22
 * @Describe 司机标签-司机情况
 */
public enum DriverLabelIinformationEnum {

    //Try to run in a hurry
    TRY_TO_RUN_HURRY(1, "着急试跑"),
    //want to follow the car
    WANT_TO_FOLLOW_CAR(2, "想跟车"),
    //Scare the company to refund
    SCARE_THE_COMPANY_TO_REFUND(3, "吓唬司撮退款"),
    //don't want to renew it
    NO_WANT_TO_RENEW(4, "不想续费"),
    //I want to ask for leave
    WANT_TO_ASK_LEAVE(5, "想请假"),
    //Determined to refund
    DETERMINED_TO_REFUND(6, "铁了心要退费"),
    //Don't call me
    DONT_CALL_ME(7, "别给我打电话");

    private Integer code;
    private String value;

    DriverLabelIinformationEnum(Integer code, String value) {
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
            for (DriverLabelIinformationEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverLabelIinformationEnum getByValue(int value) {
        for (DriverLabelIinformationEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
