package com.hyman.common.enums.driver;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyman
 * @description: 市场部线索分配机制枚举
 * @createTime: 2021/3/6
 */
@Getter
public enum MarketClueAllocationEnum {
    /**
     * 市场部线索分配机制枚举
     */
    ARTIFICIAL_ALLOCATION("人工分配", 0),
    RANDOM_POLICY_ALLOCATION("随机分配+policy", 1);

    private String name;
    private Integer code;

    MarketClueAllocationEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (MarketClueAllocationEnum marketClueAllocationEnum : values()) {
                if (code.intValue() == marketClueAllocationEnum.code) {
                    return marketClueAllocationEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
