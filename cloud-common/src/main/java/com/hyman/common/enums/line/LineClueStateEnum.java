package com.hyman.common.enums.line;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * @Author:yanwei
 * @Date: 2020/7/7 - 10:16
 *
 * 货主线索状态流转
 */
@Getter
@AllArgsConstructor
public enum  LineClueStateEnum {
    /**
     * 线索状态 —— 字典同步
     */
    FOLLBE(0,"待跟进"),
    FOLLWALLD(1,"已跟进"),
    TOCUSTOMER(2,"已转化"),
    EXPIRED(3,"无效");

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
