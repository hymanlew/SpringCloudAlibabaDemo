package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author:zhanglichao
 * @Date:2021/3/24 18:01
 * @Description: 待办所属类型枚举
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LineShelfTypeEnum {

    /**
     * 待办所属类型枚举
     */
    REDUNDANT_TO_DO(1, "冗余待办"),
    WILL_TO_DO(2, "即将到期待办");

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

    LineShelfTypeEnum(Integer code, String value) {
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
            for (LineShelfTypeEnum lineShelfTypeEnum : values()) {
                if (code.equals(lineShelfTypeEnum.code)) {
                    return lineShelfTypeEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineShelfTypeEnum getByValue(int value) {
        for (LineShelfTypeEnum lineShelfTypeEnum : values()) {
            if (lineShelfTypeEnum.getCode() == value) {
                return lineShelfTypeEnum;
            }
        }
        return null;
    }
}
