package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author zhanglichao
 * @Date 2020-08-31 18:57
 * @description 线路状态枚举类
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LineCategoryEnum {

    /**
     * 线路分类枚举
     */
    STABLE_LINE(1, "稳定线路"),
    TEMPORARY_LINE(2, "临时线路");

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

    LineCategoryEnum(Integer code, String value) {
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
            for (LineCategoryEnum lineCategoryEnum : values()) {
                if (code.equals(lineCategoryEnum.code)) {
                    return lineCategoryEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineCategoryEnum getByValue(int value) {
        for (LineCategoryEnum lineCategoryEnum : values()) {
            if (lineCategoryEnum.getCode() == value) {
                return lineCategoryEnum;
            }
        }
        return null;
    }
}
