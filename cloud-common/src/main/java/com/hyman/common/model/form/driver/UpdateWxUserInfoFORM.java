package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel("更新微信用户信息对象")
public class UpdateWxUserInfoFORM implements Serializable {

    private static final long serialVersionUID = 7830269245148025251L;

    @ApiModelProperty(value = "id")
    @NotNull(message = "id不能为空")
    private Long id;

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

    @ApiModelProperty(value = "微信的UnionId")
    private String unionId;
}