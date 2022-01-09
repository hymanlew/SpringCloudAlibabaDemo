package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 线路检查状态枚举
 **/
@Getter
public enum LineShelfInspectionStatusEnum {


    WAIT_CHECKED(1, "等待检查"),
    PASSED(2, "检查通过"),
    FAILED(3, "检查不通过");

    LineShelfInspectionStatusEnum(Integer code, String value) {
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
            for (LineShelfInspectionStatusEnum lineShelfInspectionStatusEnum : values()) {
                if (code.equals(lineShelfInspectionStatusEnum.code)) {
                    return lineShelfInspectionStatusEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
