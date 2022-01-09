package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@ApiModel("创建用户信息对象")
public class InsertDriverUserInfoFORM implements Serializable {

    private static final long serialVersionUID = 7830269245148025265L;

    @ApiModelProperty(value = "微信的openId")
    @NotBlank(message = "openId不能为空")
    private String openId;

    @ApiModelProperty(value = "用户手机号")
    private Long phone;

    @ApiModelProperty(value = "微信昵称")
    private String nickName;

    @ApiModelProperty(value = "性别(1男，2女)")
    private Integer sex;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "用户头像")
    private String headImage;

    @ApiModelProperty(value = "用户来源(1:小程序自主注册 2:二维码 3:分享 4:朋友圈)")
    private Integer source;

    @ApiModelProperty(value = "推荐人、邀请人用户编号")
    private String pUserId;

    @ApiModelProperty(value = "微信的UnionId")
    private String unionId;
}