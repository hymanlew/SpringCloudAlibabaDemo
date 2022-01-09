package com.hyman.common.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by tc on 2019/6/18.
 */
@Data
@ApiModel(description = "动态表单信息")
public class DynamicFormListVO implements Serializable {

    private static final long serialVersionUID = -5128997623770640398L;
    @ApiModelProperty(value = "字段id")
    private String fieldEn;

    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @ApiModelProperty(value = "字段类型")
    private String type;

    @ApiModelProperty(value = "字段批注（单位）")
    private String notes;

    @ApiModelProperty(value = "字段值")
    private String value;
}
