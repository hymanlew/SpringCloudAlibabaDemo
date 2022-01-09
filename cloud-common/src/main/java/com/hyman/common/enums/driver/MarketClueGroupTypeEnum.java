package com.hyman.common.enums.driver;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyman
 * @description:
 * @createTime: 2021/3/6
 */
@Getter
public enum MarketClueGroupTypeEnum {
    /**
     * 市场部线索归属枚举
     */
    CUSTOMERB("B客户", 1),
    CUSTOMERC("C客户", 2)
    ;

    private String name;
    private Integer code;

    MarketClueGroupTypeEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (MarketClueGroupTypeEnum marketClueGroupTypeEnum : values()) {
                if (code.intValue() == marketClueGroupTypeEnum.code) {
                    return marketClueGroupTypeEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
