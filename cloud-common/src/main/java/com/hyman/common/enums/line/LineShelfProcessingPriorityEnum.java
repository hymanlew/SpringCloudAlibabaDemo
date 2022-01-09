package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 新线待办处理优先级枚举
 **/
@Getter
public enum LineShelfProcessingPriorityEnum {
    WAIT_ING(1, "暂不处理"),
    PENDING(2, "待处理");

    LineShelfProcessingPriorityEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

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

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (LineShelfProcessingPriorityEnum lineShelfProcessingPriorityEnum : values()) {
                if (code.equals(lineShelfProcessingPriorityEnum.code)) {
                    return lineShelfProcessingPriorityEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
