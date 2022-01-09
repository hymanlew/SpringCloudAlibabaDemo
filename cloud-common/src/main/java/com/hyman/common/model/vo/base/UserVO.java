package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * description: UserVO <br>
 * date: 2020/7/9 13:58 <br>
 * author: hyman <br>
 */
@Data
@ApiModel("用户列表VO")
public class UserVO extends BasicUserInfoVO implements Serializable {

    private static final long serialVersionUID = 1061235697229071609L;


    @ApiModelProperty(value = "英文名", required = false)
    private String engName;

    @ApiModelProperty(value = "组织Id")
    private Integer officeId;

    @ApiModelProperty(value = "组织名")
    private String officeName;

    //设置未设密码
    @ApiModelProperty(value = "0 已设置密码，1未设置密码")
    private Integer settingFlag;

    /**
     * 权限管理系统三期已被弃用
     */
    @Deprecated
    @ApiModelProperty(value = "角色Id")
    private Integer roleId;

    @ApiModelProperty(value = "角色id集合")
    private List<Integer> roleIds;

    @ApiModelProperty(value = "角色名")
    private String roleName;
    /**
     * 状态：1启用，2禁用
     */
    @ApiModelProperty(value = "状态：1启用，2禁用")
    private Integer status;

    /**
     * Crm 唯一标识
     */
    @ApiModelProperty(value = "Crm 唯一标识")
    private String crmUserId;

    /**
     * 企业微信信息
     */
    @ApiModelProperty(value = "企业微信信息 唯一标识")
    private String corpUserId;

    @ApiModelProperty(value = "是否同步到CRM")
    private boolean syncStatus;

    @ApiModelProperty(value = "crm用户的状态")
    private String crmUserStatus;

    @ApiModelProperty(value = "是否有同步到Crm的权限")
    private boolean syncPermission;


    /**
     * 产品线：0专车，1共享，9全部
     */
    private Integer busiType;
}
