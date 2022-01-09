package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName LineCustomerStateEnum
 * @Description Customer状态枚举
 * @Author shiyunlong
 * @Date 2020/9/2 17:03
 */
@Getter
@AllArgsConstructor
public enum LineCustomerStateEnum {

    /**
     * 客户状态 —— 字典同步
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
