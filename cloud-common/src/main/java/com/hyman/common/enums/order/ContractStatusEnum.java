package com.hyman.common.enums.order;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: 合同状态
 * @author: hyman
 * @date: 2020/5/11
 */
@Getter
public enum ContractStatusEnum {
    /**
     * 签约状态
     */
    NOT_SIGN("未签约", 1),
    SIGN("已签约", 2),
    EXPIRED("已过期", 3),
    ABOLISHED("已作废", 4),
    WITHDRAWN("已撤回",5);

    private String Name;
    private Integer code;

    ContractStatusEnum(String Name, Integer code) {
        this.Name = Name;
        this.code = code;
    }


    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (ContractStatusEnum contractStatusEnum : values()) {
                if (code.intValue() == contractStatusEnum.code) {
                    return contractStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
