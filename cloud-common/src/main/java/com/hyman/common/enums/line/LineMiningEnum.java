package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum LineMiningEnum {

    /**
     * 文件类型
     */

    WAREHOUSE_LOADING_PICTURES(1, "仓位置URL"),
    OTHER_PICTURES(2,"其他图片URL"),
    LOADING_VIDEO(3, "视频URL");

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
