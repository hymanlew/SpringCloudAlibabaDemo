package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是否可转化
 */
@Getter
@AllArgsConstructor
public enum LineClueIsTranEnum {
    /**
     * 线索转化状态
     */
    FAILTRAMFORM(1,"不可转化"),
    PASSTRANFORM(2,"可转化");

    /**
     * 状态值
     */
    @ApiModelProperty("编码值")
    private int code;

    /**
     * 属性说明
     */
    @ApiModelProperty("编码对应的value")
    private String value;

}
