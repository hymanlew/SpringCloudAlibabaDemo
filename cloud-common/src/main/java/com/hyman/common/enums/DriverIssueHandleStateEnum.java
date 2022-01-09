package com.hyman.common.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Changyuan Su
 * @date 2019/8/19 18:48
 * @Description: 司机线索处理状态枚举类
 */
@ApiModel(value = "司机反馈处理状态枚举类,字典字段[driver_issue_handle_state]")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DriverIssueHandleStateEnum {

    UNPROCESSED(1, "未处理"),
    UNSOLVED(2, "未解决"),
    SOLVED(3, "已解决");

    @ApiModelProperty("字典编码")
    private Integer code;

    @ApiModelProperty("字典中文值")
    private String value;

}
