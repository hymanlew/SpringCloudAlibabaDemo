package com.hyman.common.enums.bill;

import org.apache.commons.lang3.StringUtils;

/**
 * @description: PayStatusEnum <br>
 * @date: 2020/12/16 13:41 <br>
 * @author: hyman <br>
 */
public enum PayStatusEnum {
    WAIT(0, "待审核"),
    SUCCESS(1, "审核通过"),
    FAIL(2, "审核不通过");
    
    private Integer code;
    private String name;
    
    PayStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public Integer getCode() {
        return this.code;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (PayStatusEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
