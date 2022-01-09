package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @Author shiyunlong
 * @Date 2021/3/29 11:50
 * @Description //冗余线路代办归属
 **/
@Getter
public enum RedundantAgentOwnershipEnum {
    /**
     * 线路类型枚举
     */
    LINE_OPERATION(1, "线路运营"),
    OUTSIDE_LINE_BD(2, "外线BD");

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

    RedundantAgentOwnershipEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
