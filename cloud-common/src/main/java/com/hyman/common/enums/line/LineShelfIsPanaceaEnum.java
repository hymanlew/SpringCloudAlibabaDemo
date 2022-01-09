package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * 是否万金油
 **/
@Getter
public enum LineShelfIsPanaceaEnum {
    IS_PANACEA(1, "是万金油"),
    NO_PANACEA(0, "不是万金油");

    LineShelfIsPanaceaEnum(Integer code, String value) {
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
}
