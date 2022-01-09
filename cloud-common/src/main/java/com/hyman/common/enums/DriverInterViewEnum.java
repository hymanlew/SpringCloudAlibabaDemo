package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Param
 * @Return
 * @Date 2020/7/15 17:26
 * @Describe ©  司机面试表各种枚举
 */
public enum DriverInterViewEnum {

    INTERVIEW_INTENTDELIVERYMODE_STATION(1,"传站"),
    INTERVIEW_INTENTDELIVERYMODE_PROVINCIAL(2,"省内支线"),
    INTERVIEW_INTENTDELIVERYMODE_POINT_TO_POINT(3,"点对点"),
    INTERVIEW_INTENTDELIVERYMODE_IN_THE_CITY(4,"市内多点配"),

    //INTERVIEW_INTENTCARGOTYPE_EXPRESS(1,"快递"),

    ;

    private Integer code;
    private String value;

    DriverInterViewEnum(Integer code, String value) {
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
            for (DriverInterViewEnum driverInterViewEnum : values()) {
                if (code.equals(driverInterViewEnum.code)) {
                    return driverInterViewEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverInterViewEnum getByValue(int value) {
        for (DriverInterViewEnum driverInterViewEnum : values()) {
            if (driverInterViewEnum.getCode() == value) {
                return driverInterViewEnum;
            }
        }
        return null;
    }
}
