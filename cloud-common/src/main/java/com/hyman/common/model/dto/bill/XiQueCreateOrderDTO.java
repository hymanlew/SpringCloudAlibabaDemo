package com.hyman.common.model.dto.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author
 * @date 2019-11-05
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("梧桐喜鹊，微信支付回调 v1.16 传递对象")
public class XiQueCreateOrderDTO implements Serializable {
    private static final long serialVersionUID = 7507272770546414038L;


    /**
     * 商户订单号(订单支付编号)
     */
    @ApiModelProperty(value = "商户订单号(订单支付编号)")
    private String outTradeNo;

    /**
     * 微信支付订单号(支付回调返回)
     */
    @ApiModelProperty(value = "微信支付订单号(支付回调返回)")
    private String transactionId;

    /**
     * 支付金额
     */
    @ApiModelProperty(value = "支付金额")
    private BigDecimal depositFee;

    /**
     * 押金状态
     * 【1微信收款尚未确认，2微信收款已经确认，3微信退款尚未确认，4微信退款已经确认】
     */
    @ApiModelProperty(value = "押金状态【1微信收款尚未确认，2微信收款已经确认，3微信退款尚未确认，4微信退款已经确认】")
    private Integer state;
}
