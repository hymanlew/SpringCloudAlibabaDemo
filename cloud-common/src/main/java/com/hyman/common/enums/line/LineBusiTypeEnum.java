package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Authorzhanglichao
 * @Date 2021-03-24 10:57
 * @description 线路业务线标识枚举
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LineBusiTypeEnum {

    /**
     * 线路业务线标识枚举
     */
    LINE_FIRMIANA(0, "梧桐专车"),
    LINE_PARTNER(1, "梧桐共享"),
    LINE_FIRMIANA_PARTNER(9, "共享/专车");

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

    LineBusiTypeEnum(Integer code, String value) {
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
            for (LineBusiTypeEnum LineBusiTypeEnum : values()) {
                if (code.equals(LineBusiTypeEnum.code)) {
                    return LineBusiTypeEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineBusiTypeEnum getByValue(int value) {
        for (LineBusiTypeEnum LineBusiTypeEnum : values()) {
            if (LineBusiTypeEnum.getCode() == value) {
                return LineBusiTypeEnum;
            }
        }
        return null;
    }
}
