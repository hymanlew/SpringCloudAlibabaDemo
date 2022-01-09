package com.hyman.common.model.form.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @description: GetUserInfoByCityAndBusiLine <br>
 * @date: 2020/12/7 11:34 <br>
 * @author: hyman <br>
 */
@Data
@ApiModel("根据地市和产品线查询用户信息FROM")
public class GetUserInfoByCityAndBusiLineFORM {
    
    @NotBlank
    @ApiModelProperty(name = "cityCode", value = "城市编码", required = true, dataType = "String")
    private String cityCode;
    
    @NotNull
    @ApiModelProperty(name = "busiType", value = "业务线", required = true)
    private Integer busiType;
    
    @NotNull
    @ApiModelProperty(name = "roleTypes", value = "需要的角色类型", required = true)
    private Set<Integer> roleTypes;
}
