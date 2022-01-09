package com.hyman.common.model.vo.wechat.corp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tianchong
 * @date 2020/03/17
 * @Description: 根据用户授权登录code换取用户信息vo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("根据用户授权登录code换取用户信息vo")
public class Oauth2UserInfoVO {

    @ApiModelProperty(value = "成员UserID")
    private String userId;

    @ApiModelProperty(value = "手机设备号(由企业微信在安装时随机生成，删除重装会改变，升级不受影响)")
    private String deviceId;

}
