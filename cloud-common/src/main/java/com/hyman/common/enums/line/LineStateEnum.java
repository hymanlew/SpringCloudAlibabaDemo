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
public enum LineStateEnum {

    /**
     * 线路状态枚举
     */
    IS_SHELVES(1, "已上架"),
    IS_RUNNING(2, "已开跑"),
    NO_RUNNING_SHELVES(4, "未开跑下架"),
    IS_RUNNING_SHELVES(3, "已开跑下架");

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

    LineStateEnum(Integer code, String value) {
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
            for (LineStateEnum lineStateEnum : values()) {
                if (code.equals(lineStateEnum.code)) {
                    return lineStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineStateEnum getByValue(int value) {
        for (LineStateEnum lineStateEnum : values()) {
            if (lineStateEnum.getCode() == value) {
                return lineStateEnum;
            }
        }
        return null;
    }
}
