package com.hyman.common.model.vo.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by tianc on 2019/8/28.
 */
@Data
@ApiModel("微信支付统一下单接口返回对象")
public class WxPayUnifiedOrderVo {
    @ApiModelProperty(value = "公众号、小程序id")
    private String appId;

    @ApiModelProperty(value = "时间戳")
    private String timeStamp;

    @ApiModelProperty(value = "随机字符串")
    private String nonceStr;

    @ApiModelProperty(value = "订单详情扩展字符串")
    private String packageValue;

    @ApiModelProperty(value = "签名方式")
    private String signType;

    @ApiModelProperty(value = "签名")
    private String paySign;
}
