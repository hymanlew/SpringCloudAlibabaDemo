package com.hyman.common.enums.line;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:yanwei
 * @Date: 2020/8/31 - 10:16
 *
 * 项目线索状态流转
 */
@Getter
@AllArgsConstructor
public enum LineProjectStateEnum {
    /**
     * 项目状态 —— 字典同步
     */
    DISABLE(1,"禁用"),
    ENABLE(2,"启用");

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
