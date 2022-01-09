package com.hyman.common.model.dto.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * description: UserDTO <br>
 * date: 2020/7/15 17:47 <br>
 * author: hyman <br>
 */
@Data
@ApiModel("Base模块向Auth模块同步数据用")
public class UserDTO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "id不能为空")
    private Integer id;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "类型标记：BSS ,APP")
    private String type;

    @ApiModelProperty(value = "第三方id")
    private String thirdPartyId;

    @ApiModelProperty(value = "状态：1启用，2禁用")
    private Integer status;

    @ApiModelProperty(value = "角色Id")
    private Integer roleId;

    @ApiModelProperty(value = "组织Id")
    private Integer officeId;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "更新状态 1 删除 2更新 3新增")
    @NotNull(message = "更新状态Id不能为空")
    private Integer updateStatus;

}
