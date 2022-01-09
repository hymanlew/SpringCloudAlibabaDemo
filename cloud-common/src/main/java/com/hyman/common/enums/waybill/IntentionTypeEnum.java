package com.hyman.common.enums.waybill;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author wuyangxu
 * @date 2020/02/03
 * @Description： 意向类型枚举
 */
@Getter
public enum IntentionTypeEnum {

    DEFAULT(0, "默认"),

    FOLLOW_CAR(1, "跟车"),

    RUN_TEST(2, "试跑");

    private final Integer code;
    private final String name;

    IntentionTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (IntentionTypeEnum intentionTypeEnum : values()) {
                if (code.intValue() == intentionTypeEnum.getCode()) {
                    return intentionTypeEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static IntentionTypeEnum getEnum(Integer code) {
        if (code != null) {
            for (IntentionTypeEnum intentionTypeEnum : values()) {
                if (code.intValue() == intentionTypeEnum.getCode()){
                    return intentionTypeEnum;
                }
            }
        }
        return null;
    }
}
