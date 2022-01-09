package com.hyman.common.model.form.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @description: GetSpecifiedLowerUserListFORM <br>
 * @date: 2020/9/16 9:32 <br>
 * @author: hyman <br>
 */
@Data
@ApiModel("获取当前登录人下属的相关角色的用户列表FORM")
public class QuerySpecifiedLowerUserListFORM {

    @ApiModelProperty(name = "cityCode", value = "城市编码", dataType = "String")
    private String cityCode;

    @ApiModelProperty(value = "产品线，外线2,专车0，共享1,公共4,车资产5",required = false)
    private Integer productLine;
    
    @NotNull(message = "roleTypes不能为空")
    @ApiModelProperty(name = "roleTypes", value = "角色标识。加盟经理roleId=1 外销销售=2,上岗经理=3 ,渠道经理=4,专车BGP = 6" +
            "共享BGP=7,专车加盟经理=8,共享加盟经理=9,GMC=10")
    private Set<Integer> roleTypes;

    @NotNull(message = "roleType不能为空")
    @ApiModelProperty(name = "roleType", value = "1加盟 2渠道")
    private Integer roleType;
    
    @NotNull(message = "Uri不能为空")
    @ApiModelProperty(name = "uri", value = "权限标识")
    private String uri;
    
    @ApiModelProperty(name = "groupId", value = "加盟小组", dataType = "Integer")
    private Integer groupId;

    @ApiModelProperty(name = "keyword", value = "用户中文名/手机号，支持模糊查询", dataType = "String")
    private String keyword;
    
    public void setCityCode(String cityCode) {
        if (StringUtils.isBlank(cityCode)){
            this.cityCode = null;
        }
        this.cityCode = cityCode;
    }
    
    public String getCityCode() {
        if (StringUtils.isBlank(cityCode)){
            return null;
        }
        return cityCode;
    }
}
