package com.hyman.common.model.form.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @description: GetUserByCityAndKeyword <br>
 * @date: 2020/12/28 11:05 <br>
 * @author: hyman <br>
 */
@Data
@ApiModel("根据地市和产品线查询用户信息FROM")
public class GetUserByCityAndKeywordFORM {
    
    @ApiModelProperty(name = "cityCodes", value = "城市编码", required = false, dataType = "Integer")
    private Set<Integer> cityCodes;
    
    @NotNull
    @NotNull(message = "roleType不能为空")
    @ApiModelProperty(name = "roleTypes", value = "角色标识。加盟经理roleId=1 外销销售=2,上岗经理=3 ,渠道经理=4,专车BGP = 6" +
            "共享BGP=7", required = true)
    private Set<Integer> roleTypes;
    
    @ApiModelProperty(name = "keyword", value = "关键字", required = false, dataType = "String")
    private String keyword;
    
    @ApiModelProperty(value = "产品线，外线2,专车0，共享1,公共4,车资产5",required = false)
    private Integer productLine;
}
