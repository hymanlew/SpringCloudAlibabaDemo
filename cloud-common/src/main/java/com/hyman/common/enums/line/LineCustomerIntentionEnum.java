package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author shiyunlong
 * @Date 2020/9/3 14:20
 * @Description 客户意向度枚举
 **/
@Getter
@AllArgsConstructor
public enum LineCustomerIntentionEnum {

    /**
     * 客户状态 —— 字典同步
     */
    HIGH(1,"高意向"),
    MEDIUM(2,"中意向"),
    LOW(3,"低意向");
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
