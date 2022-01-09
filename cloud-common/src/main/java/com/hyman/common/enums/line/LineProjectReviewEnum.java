package com.hyman.common.enums.line;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:yanwei
 * @Date: 2020/8/31 - 10:16
 *
 * 项目审核状态枚举
 */
@Getter
@AllArgsConstructor
public enum LineProjectReviewEnum {
    /**;1待审核,2审核通过
     * 项目审核状态 —— 字典同步
     */
    WAIT_AUDIT(1,"待审核"),
    PASS_AUDIT(2,"审核通过"),
    FAIL_AUDIT(3,"审核未通过");

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
