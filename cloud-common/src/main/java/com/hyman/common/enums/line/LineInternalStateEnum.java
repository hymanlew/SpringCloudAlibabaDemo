package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author shiyunlong
 * @Date 2021/3/2 17:46
 * @Description 线路内部状态变更枚举
 **/
@Getter
@AllArgsConstructor
public enum LineInternalStateEnum {

    CREATE(1, "创建/复制"),
    EDIT(2, "编辑"),
    ACTIVATION(3, "激活"),
    OFF_SHELF(4, "下架");


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
