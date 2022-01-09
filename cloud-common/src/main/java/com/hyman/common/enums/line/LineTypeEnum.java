package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author zhanglichao
 * @Date 2020-08-31 18:57
 * @description 线路类型枚举类
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LineTypeEnum {

    /**
     * 线路类型枚举
     */
    IN_CITY_LINE(1, "城市线"),
    ACROSS_CITY_LINE(2, "跨城支线");

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

    LineTypeEnum(Integer code, String value) {
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
            for (LineTypeEnum lineTypeEnum : values()) {
                if (code.equals(lineTypeEnum.code)) {
                    return lineTypeEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineTypeEnum getByValue(int value) {
        for (LineTypeEnum lineTypeEnum : values()) {
            if (lineTypeEnum.getCode() == value) {
                return lineTypeEnum;
            }
        }
        return null;
    }
}
