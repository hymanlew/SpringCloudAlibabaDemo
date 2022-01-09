package com.hyman.common.enums.label;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 当月新成交枚举
 *
 * @author hucl
 * @date 2021/5/11 3:42 下午
 */
@AllArgsConstructor
@Getter
public enum CurrentMontyDealEnum {
    CURRENT(0, "当月成交新司机"),
    PASS(1, "往期成交司机"),
    NOT_DEAL(2, "没有成交"),
    ;
    private final Integer code;
    private final String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CurrentMontyDealEnum getCurrentMontyDealEnumByCode(int code) {
        for (CurrentMontyDealEnum item : values()) {
            if(item.getCode() == code) {
                return item;
            }
        }

        return null;
    }
}
