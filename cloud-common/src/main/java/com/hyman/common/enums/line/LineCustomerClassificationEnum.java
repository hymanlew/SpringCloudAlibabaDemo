package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author shiyunlong
 * @Date 2020/9/3 18:45
 * @Description //客户分类枚举
 **/
@Getter
@AllArgsConstructor
public enum LineCustomerClassificationEnum {
    /**
     * 客户状态 —— 字典同步
     */
    OUTSIDE_CUSTOMER(1,"外线客户"),
    SELFCARRYING_CUSTOMER(2,"自承运客户"),
    GROUP_CUSTOMER(3,"集团客户");
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
