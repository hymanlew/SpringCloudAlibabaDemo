package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author: tianc
 * @create: 2020-03-10
 * @description: 司机的企业微信信息
 **/
@Data
@ApiModel("司机的企业微信信息")
public class CorpWechatOfDriverVO implements Serializable {

    private static final long serialVersionUID = -4936288477985995007L;
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    @ApiModelProperty(value = "加盟经理id")
    protected Long joinManagerId;

    @ApiModelProperty(value = "企业微信-外部联系人id")
    private String externalUserId;

    @ApiModelProperty(value = "企业微信-成员id")
    private String corpUserId;
}