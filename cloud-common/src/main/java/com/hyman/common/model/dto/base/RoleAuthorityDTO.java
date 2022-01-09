package com.hyman.common.model.dto.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色对应的权限信息
 * @author hucl
 * @date 2020/7/16 9:33
 */
@Data
@ApiModel("角色权限")
public class RoleAuthorityDTO implements Serializable {


    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    @ApiModelProperty(value = "权限名称")
    private String authorityName;

    @ApiModelProperty(value = "权限id")
    private String authorityId;

    @ApiModelProperty(value = "类型为功能时，数据控制类型:1需要，0无需")
    private Integer controlFlag;

    @ApiModelProperty(value = "权限类型：1根节点，2客户端, 3分类，4页面，5功能")
    private Integer type;

    @ApiModelProperty(value = "权限类型为页面时的地址")
    private String url;

    @ApiModelProperty(value = "可视范围类型:0全部，1大区，2城市，3小组，4个人，5业务线")
    private Integer dataScope;

    @ApiModelProperty(value = "产品线：0专车 1共享 2全部")
    private Integer productLine;

}
