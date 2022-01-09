package com.hyman.common.model.form.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: GetDictInfoByConditionFORM <br>
 * @date: 2021/2/4 15:31 <br>
 * @author: hyman <br>
 */
@Data
@ApiModel("根据条件查询字典信息FROM")
public class GetDictInfoByConditionFORM {
    @NotBlank(message = "字典类型不能为空")
    @ApiModelProperty(name = "dictType", value = "字典类型", required = true)
    private String dictType;
    
    @ApiModelProperty(name = "isSystem", value = "是否是系统内置", required = false)
    private Boolean isSystem = false;
    
    @ApiModelProperty(name = "keyword", value = "关键字", required = false)
    private String keyword;
}
