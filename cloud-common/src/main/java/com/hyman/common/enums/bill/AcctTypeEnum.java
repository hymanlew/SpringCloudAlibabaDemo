package com.hyman.common.enums.bill;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 账户类型
 * Created by tc on 2018/11/16.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum AcctTypeEnum {
    DEFAULT(0, "默认"),
    PERSONAL(1, "个人账户"),
    ORGANIZATION(2, "组织账户"),
    ;

    private Integer code;
    private String name;

}
