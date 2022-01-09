package com.hyman.common.model.vo.wechat.corp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@ApiModel("企业微信激活状态vo")
public class WxCpActivationStatusVO implements Serializable {

    private static final long serialVersionUID = -1522428880072377241L;

    @ApiModelProperty(value = "是否加入企业微信")
    private Boolean isJoinCorpWechat = Boolean.FALSE;
    @ApiModelProperty(value = "是否关注企业号")
    private Boolean isFollowWorkBench = Boolean.FALSE;
    @ApiModelProperty(value = "是否激活推送")
    private Boolean isActivationPush = Boolean.FALSE;
    @ApiModelProperty(value = "企业微信用户id")
    private Set<String> corpUserIds;

}
