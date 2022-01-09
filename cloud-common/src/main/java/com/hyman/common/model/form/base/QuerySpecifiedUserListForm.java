package com.hyman.common.model.form.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: QuerySpecifiedUserListForm <br>
 * @date: 2020/10/9 16:42 <br>
 * @author: hyman <br>
 */
@Data
@ApiModel("")
public class QuerySpecifiedUserListForm {
    
    @NotBlank(message = "城市编码不能为空")
    @ApiModelProperty(name = "cityCode", value = "城市编码", dataType = "String",required = true)
    private String cityCode;
    
//    @NotNull(message = "产品线不能为空")
    @ApiModelProperty(value = "产品线，外线1,专车2，共享3,公共4,车资产5",required = false)
    private Integer productLine;
    
    @NotNull(message = "角色标识")
    @ApiModelProperty(name = "roleType", value = "角色标识。加盟经理roleId=1 外销销售=2,上岗经理=3",required = true)
    private Integer roleType;
    
    @ApiModelProperty(name = "keyword", value = "用户中文名/手机号，支持模糊查询", dataType = "String")
    private String keyword;
}
