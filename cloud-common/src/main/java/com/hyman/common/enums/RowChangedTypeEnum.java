package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhang ya nuo
 * @Description 行数据改变类型 枚举
 * @since 2021/4/26
 */
public enum RowChangedTypeEnum {
    INSERT(1, "新增"),
    UPDATE(2, "修改"),
    DELETE(3, "删除");

    private Integer code;
    private String value;

    RowChangedTypeEnum(int code, String value) {
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
            for (RowChangedTypeEnum t : values()) {
                if (code.equals(t.code)) {
                    return t.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static RowChangedTypeEnum getByValue(int value) {
        for (RowChangedTypeEnum t : values()) {
            if (t.getCode() == value) {
                return t;
            }
        }
        return null;
    }
}
