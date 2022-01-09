package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Authorzhanglichao
 * @Date 2020-03-10 16:12
 * @description 线路是否枚举类
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LineWhetherOrNotEnum {

    /**
     * 线路是否枚举类
     */
    LINE_IS(1, "是"),
    LINE_NO(2, "否");

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

    LineWhetherOrNotEnum(Integer code, String value) {
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
            for (LineWhetherOrNotEnum lineWhetherOrNotEnum : values()) {
                if (code.equals(lineWhetherOrNotEnum.code)) {
                    return lineWhetherOrNotEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineWhetherOrNotEnum getByValue(int value) {
        for (LineWhetherOrNotEnum lineWhetherOrNotEnum : values()) {
            if (lineWhetherOrNotEnum.getCode() == value) {
                return lineWhetherOrNotEnum;
            }
        }
        return null;
    }
}
