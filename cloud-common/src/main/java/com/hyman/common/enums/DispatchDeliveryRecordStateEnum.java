package com.hyman.common.enums;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Changyuan Su
 * @date 2020/3/4 下午4:27
 * @Description:
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DispatchDeliveryRecordStateEnum {


    /**
     * 待确认
     */
    CONFIRMING(1, "待确认"),

    /**
     * 已确认
     */
    CONFIRMED(2, "已确认"),
    NOT_RUNNING(3, "未出车"),
    DEV_CONFIRMED(4, "运维确认");


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
