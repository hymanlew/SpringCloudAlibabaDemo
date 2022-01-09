package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: tianchong
 * @create: 2020-01-13
 * @description: 用户信息
 **/
@Data
@ApiModel("用户信息VO")
public class UserVO implements Serializable {
    private static final long serialVersionUID = 3584134765026312255L;

    @ApiModelProperty("用户id")
    private String id;

    @ApiModelProperty("登录名")
    private String loginName;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("业务权限")
    private String busiPermission;

}