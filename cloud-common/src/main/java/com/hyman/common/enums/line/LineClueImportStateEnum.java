package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yanwei
 */
@Getter
@AllArgsConstructor
public enum LineClueImportStateEnum {

    /**
     * 货主线索导入状态
     */
    IMPORTFAIL(0,"失败"),
    IMPORTSUCCESS(1,"成功"),
    IMPORTCONTINUE(2,"导入中");

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
