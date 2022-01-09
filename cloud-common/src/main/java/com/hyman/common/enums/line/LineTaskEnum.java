package com.hyman.common.enums.line;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author zhanglichao
 * @Date 2020-05-19 16:43
 * @description
 */
@Getter
public enum LineTaskEnum {
    //结算方式
    INCOME_SETTLEMENT(1, "整车"),
    PAY_ON_COMMISSION(2, "多点配");


    private int code;
    private String value;

    LineTaskEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public static boolean isLineTaskEnum(String value) {
        for (LineTaskEnum lk : LineTaskEnum.values()) {
            if (lk.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (LineTaskEnum lineTaskEnum : values()) {
                if (code.equals(lineTaskEnum.code)) {
                    return lineTaskEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
