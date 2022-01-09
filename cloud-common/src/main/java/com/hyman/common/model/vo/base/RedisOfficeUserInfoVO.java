package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
public class RedisOfficeUserInfoVO implements Serializable {

    private static final long serialVersionUID = 1770231897548872997L;


    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("用户的姓名")
    private String name;

    @ApiModelProperty("组织名")
    private String officeName;

    @ApiModelProperty("组织id")
    private Integer officeId;

    //1启用，2禁用
    @ApiModelProperty("状态")
    private Integer status;
}
