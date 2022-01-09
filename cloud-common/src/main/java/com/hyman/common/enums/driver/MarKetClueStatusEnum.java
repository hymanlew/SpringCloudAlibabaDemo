package com.hyman.common.enums.driver;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yantao
 * @Date 2020/12/8 10:27
 * @Describe 市场部线索状态枚举
 */
public enum MarKetClueStatusEnum {

    //To be allocated
    TOBEALLOCATED_STATUS(10, "待分配"),
    //To be followed up
    TOBEFOLLOWEDUP_STATUS(20, "待跟进"),
    //Follow up
    FOLLOWUP_STATUS(30, "跟进中"),
    //To be interviewed
    TOBEINTERVIEWED_STATUS(40, "待面试"),
    //Interviewed
    INTERVIEWED_STATUS(50, "已面试"),
    //deal
    DEAL_STATUS(60, "已成交");

    private Integer code;
    private String value;

    MarKetClueStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }


    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (MarKetClueStatusEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static MarKetClueStatusEnum getByValue(int value) {
        for (MarKetClueStatusEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
