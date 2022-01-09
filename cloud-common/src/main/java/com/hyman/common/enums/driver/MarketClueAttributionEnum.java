package com.hyman.common.enums.driver;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyman
 * @description:
 * @createTime: 2021/3/6
 */
@Getter
public enum MarketClueAttributionEnum {
    /**
     * 市场部线索归属枚举
     */
    MARKET_CLUE("市场部线索", 0),
    LOCAL_CLUE("本地线索", 1),
    OTHER_CLUE("其他线索", 2),
    CLIENT_CLUE("端线索", 3),
    ;

    private String name;
    private Integer code;

    MarketClueAttributionEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (MarketClueAttributionEnum marketClueAttributionEnum : values()) {
                if (code.intValue() == marketClueAttributionEnum.code) {
                    return marketClueAttributionEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
