package com.hyman.common.model.vo.wechat.corp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianchong
 * @date 2020/03/17
 * @Description: jsapi签名
 */
@Data
@ApiModel("jsapi签名vo")
public class WxJsapiSignatureVO implements Serializable {
    private static final long serialVersionUID = -418651856472713628L;
    @ApiModelProperty(value = "企业id")
    private String corpId;

    @ApiModelProperty(value = "企业微信的应用id")
    private Integer agentId;

    @ApiModelProperty(value = "生成签名的随机串")
    private String nonceStr;

    @ApiModelProperty(value = "生成签名的时间戳")
    private long timestamp;

    @ApiModelProperty(value = "当前网页的URL")
    private String url;

    @ApiModelProperty(value = "签名")
    private String signature;

}
