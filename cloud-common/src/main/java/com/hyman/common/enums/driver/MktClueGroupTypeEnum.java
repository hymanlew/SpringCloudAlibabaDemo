package com.hyman.common.enums.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 市场部线索客户人群枚举
 *
 * @author hucl
 * @date 2021/6/24 7:07 下午
 */
@Getter
@AllArgsConstructor
public enum MktClueGroupTypeEnum {

    B(1, "B客户"),
    C(2, "C客户"),
    ;

    private final Integer code;

    private final String desc;
}
