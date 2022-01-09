package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author zhanglichao
 * @Date 2020-08-31 18:57
 * @description 线路标签枚举类
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LineInLineEnum {

    /**
     * 线路采线枚举
     */
    IS_IN_LINE(1, "已采线"),
    IS_NOT_IN_LINE(2, "未采线");

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

    LineInLineEnum(Integer code, String value) {
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
            for (LineInLineEnum lineInLineEnum : values()) {
                if (code.equals(lineInLineEnum.code)) {
                    return lineInLineEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineInLineEnum getByValue(int value) {
        for (LineInLineEnum lineInLineEnum : values()) {
            if (lineInLineEnum.getCode() == value) {
                return lineInLineEnum;
            }
        }
        return null;
    }
}
