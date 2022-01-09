package com.hyman.common.enums.line;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author:zhanglichao
 * @Date:2021/3/9 13:56
 * @Description:
 */
@Getter
public enum LineDenominatedEnum {
    //计价方式
    ACCORDING_SETTLEMENT(1, "按趟计费"),
    GUARANTEED_COMMISSION(2, "保底+提成");


    private int code;
    private String value;

    LineDenominatedEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (LineDenominatedEnum lineTaskEnum : values()) {
                if (code.equals(lineTaskEnum.code)) {
                    return lineTaskEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
