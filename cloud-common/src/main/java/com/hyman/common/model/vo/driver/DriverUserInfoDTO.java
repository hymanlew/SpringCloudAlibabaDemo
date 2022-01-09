package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by tc on 2019/5/9.
 */
@Data
@ApiModel("用户信息")
public class DriverUserInfoDTO implements Serializable {

    private static final long serialVersionUID = 4032803778549569607L;

    @ApiModelProperty(value = "用户编号")
    private String userId;

    @ApiModelProperty(value = "用户手机号")
    private Long phone;

    @ApiModelProperty(value = "微信的OpenId")
    private String openId;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户真实姓名")
    private String realName;

    @ApiModelProperty(value = "性别(1男，2女)")
    private Integer sex;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "用户头像")
    private String headImage;

    @ApiModelProperty(value = "推荐人、邀请人用户编号")
    private String pUserId;

    @ApiModelProperty(value = "微信的UnionId")
    private String unionId;

    /**
     * 来源
     */
    @ApiModelProperty(value = "来源")
    private Integer sourceChannel;

    /**
     * 外部联系人userid
     */
    @ApiModelProperty(value = "外部联系人userid")
    private String externalUserId;

    /**
     * 企业微信成员id
     */
    @ApiModelProperty(value = "企业微信成员id")
    private String corpUserId;
}
