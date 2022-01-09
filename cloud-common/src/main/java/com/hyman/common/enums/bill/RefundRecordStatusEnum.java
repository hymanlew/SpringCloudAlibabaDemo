package com.hyman.common.enums.bill;

import org.apache.commons.lang3.StringUtils;

/**
 * 退款记录表审核状态
 * @author hucl
 */
public enum RefundRecordStatusEnum {
    TO_BE_APPROVE(1, "待审核"),
    NOT_APPROVED(2, "审核不通过"),
    APPROVED(3, "待退费"),
    REFUNDED(4, "已退费")
    ;

    private Integer code;
    private String name;

    RefundRecordStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (RefundRecordStatusEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
