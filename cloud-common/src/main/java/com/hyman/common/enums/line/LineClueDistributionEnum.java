package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是否分配所属销售
 */
@Getter
@AllArgsConstructor
public enum LineClueDistributionEnum {
    /**
     * 线索分配状态
     */
    GEGITHIS(1,"已分配"),
    GEGINULL(0,"待分配");

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
