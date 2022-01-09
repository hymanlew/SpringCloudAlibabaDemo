package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @description 线路状态检查枚举
 */
@Getter
public enum LineCheckStateEnum {
    /**
     * 线路是否有余额枚举
     */
    IS_CHECK(1, "未检查通过"),
    NO_CHECK(2, "已检查通过");

    /**
     * 对用于字典中的 键值
     */
    @ApiModelProperty("编码值")
    private int code;

    /**
     * 对用于字典 标签
     */
    @ApiModelProperty("编码对应的value")
    private String value;

    LineCheckStateEnum(Integer code, String value) {
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
            for (LineCheckStateEnum lineCheckStateEnum : values()) {
                if (code.equals(lineCheckStateEnum.code)) {
                    return lineCheckStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineCheckStateEnum getByValue(int value) {
        for (LineCheckStateEnum lineCheckStateEnum : values()) {
            if (lineCheckStateEnum.getCode() == value) {
                return lineCheckStateEnum;
            }
        }
        return null;
    }
}
