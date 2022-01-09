package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @description:
 * @author: WuYangXu
 * @date: 2020/9/2
 */
@Getter
public enum RunTestRunTypeEnum {

    HAVE_TRY_RUN(200, "试跑"),

    HAVE_FOLLOW_CAR(300, "跟车");


    private Integer code;

    private String name;

    RunTestRunTypeEnum(Integer code, String Name) {
        this.name = Name;
        this.code = code;
    }


    public static RunTestRunTypeEnum getEnum(Integer code) {
        if (code != null) {
            for (RunTestRunTypeEnum runTestRunTypeEnum : values()) {
                if (code.intValue() == runTestRunTypeEnum.code) {
                    return runTestRunTypeEnum;
                }
            }
        }
        return null;
    }


    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (RunTestRunTypeEnum runTestRunTypeEnum : values()) {
                if (code.intValue() == runTestRunTypeEnum.code) {
                    return runTestRunTypeEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
