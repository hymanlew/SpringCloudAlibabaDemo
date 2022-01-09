package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author shiyunlong
 * @Date 2020/9/3 18:56
 * @Description //客户渠道枚举
 **/
@Getter
@AllArgsConstructor
public enum LineCustomerChannelsEnum {
    /**
     * 客户状态 —— 字典同步
     */
    STRAIGHTOFF(1,"直客"),
    TRIPARTITE(2,"三方");

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
