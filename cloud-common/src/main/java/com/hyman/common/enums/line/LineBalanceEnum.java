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
public enum LineBalanceEnum {

    /**
     * 线路是否有余额枚举
     */
    IS_BALANCE(1, "有余额"),
    NO_BALANCE(2, "无余额");

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

    LineBalanceEnum(Integer code, String value) {
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
            for (LineBalanceEnum lineBalanceEnum : values()) {
                if (code.equals(lineBalanceEnum.code)) {
                    return lineBalanceEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineBalanceEnum getByValue(int value) {
        for (LineBalanceEnum lineBalanceEnum : values()) {
            if (lineBalanceEnum.getCode() == value) {
                return lineBalanceEnum;
            }
        }
        return null;
    }
}
