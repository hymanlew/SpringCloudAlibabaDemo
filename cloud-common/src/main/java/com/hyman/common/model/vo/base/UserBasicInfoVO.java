package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianchong
 * @date 2019/12/19
 * @Description:
 */
@ApiModel("用户基本信息VO")
@Data
public class UserBasicInfoVO implements Serializable {

    private static final long serialVersionUID = 26037336759214613L;
    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("登录名")
    private String loginName;

    @ApiModelProperty("企业微信成员id")
    private String corpUserId;
    
    @ApiModelProperty("状态：1启用，2禁用")
    private Integer status;

    @ApiModelProperty("角色名称")
    private String roleName;
    @ApiModelProperty("角色ID")
    private Integer roleId;

}
