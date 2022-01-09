package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author NiuZhiPeng
 * @date 2020/12/14 9:53
 * @Description： 意向失败原因枚举
 */
@Getter
public enum IntentionFailureTypeEnum {

    CANCEL(1, "取消意向"),

    BREAK_AN_APPOINTMENT(2, "爽约"),

    TURN_AROUND(3, "到场扭头就走"),

    LINE_HAS_BEEN_TRIED(4, "线路已试跑"),

    LINE_DUE_FAILURE(5, "线路到截止期"),

    LINE_MANUAL_OFF_SHELF(6, "线路手动下架"),

    MATCH_CANAL(7, "司撮取消意向");

    private final Integer code;
    private final String name;

    IntentionFailureTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (IntentionFailureTypeEnum intentionFailureTypeEnum : values()) {
                if (code.intValue() == intentionFailureTypeEnum.getCode()) {
                    return intentionFailureTypeEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static IntentionFailureTypeEnum getEnum(Integer code) {
        if (code != null) {
            for (IntentionFailureTypeEnum intentionFailureTypeEnum : values()) {
                if (code.intValue() == intentionFailureTypeEnum.getCode()){
                    return intentionFailureTypeEnum;
                }
            }
        }
        return null;
    }
}
