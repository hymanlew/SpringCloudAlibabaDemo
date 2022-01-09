package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2020/7/8 下午4:04
 * @Description:
 */
@ApiModel("小程序创建司机")
@Data
public class MinAppCreateDriverUserFORM implements Serializable {
    private static final long serialVersionUID = -2225741004559244387L;

    //    @Range(min = 13000000001L, max = 19000000000L, message = "手机号有误")
//    @NotNull(message = "手机号不能为空")
    @Nullable
    @ApiModelProperty(value = "用户手机号")
    private Long phone;

    /**
     * 微信的OpenId
     */
    @NotBlank(message = "openId不能为空")
    @ApiModelProperty(value = "微信的OpenId")
    private String openId;

    /**
     * 微信的UnionId
     */
//    @NotBlank(message = "微信的UnionId不能为空")
    @ApiModelProperty(value = "微信的UnionId")
    private String unionId;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 用户真实姓名
     */
    @ApiModelProperty(value = "用户真实姓名")
    private String realName;

    /**
     * 性别(1男，2女)
     */
    @Nullable
    @ApiModelProperty(value = "性别(1男，2女)")
    private Integer sex;

    /**
     * 省
     */
    @Nullable
    @ApiModelProperty(value = "省")
    private String province;

    /**
     * 市
     */
    @Nullable
    @ApiModelProperty(value = "市")
    private String city;

    /**
     * 用户头像
     */
    @Nullable
    @ApiModelProperty(value = "用户头像")
    private String headImage;

    /**
     * 来源
     */
    @Nullable
    @ApiModelProperty(value = "来源")
    private Integer sourceChannel;

//    /**
//     * 城市
//     */
//    @JsonIgnore
//    @Nullable
//    @ApiModelProperty(value = "城市")
//    private Integer workCity;

}
