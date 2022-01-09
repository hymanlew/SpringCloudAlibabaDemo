package com.hyman.common.model.form.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description:
 * @author: WuYangXu
 * @date: 2020/7/17
 */
@Data
@ApiModel("查询字典值form")
public class DictDataListFORM implements Serializable {

    private static final long serialVersionUID = -3704970302219429148L;

    @ApiModelProperty(value = "字典类型",required = true)
    @NotBlank(message = "字典类型不能为空")
    private String dictType;
}
