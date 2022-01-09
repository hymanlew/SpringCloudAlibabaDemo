package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 外线处理状态
 **/
@Getter
public enum LineShelfBdProcessingStatusEnum {
    PENDING(1, "待处理"),
    COMPLETED(2, "已完成");

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

    LineShelfBdProcessingStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (LineShelfBdProcessingStatusEnum lineShelfBdProcessingStatusEnum : values()) {
                if (code.equals(lineShelfBdProcessingStatusEnum.code)) {
                    return lineShelfBdProcessingStatusEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

}
