package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * @Author shiyunlong
 * @Date 2020/9/3 14:38
 * @Description 审核状态枚举
 **/
@Getter
@AllArgsConstructor
public enum LineCustomerReviewStateEnum {
    /**
     * 客户状态 —— 字典同步
     */
    PENDING(1,"待审核"),
    PASSED(2,"审核通过"),
    AUDIT_NOT_PASSED(3,"审核不通过");
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
