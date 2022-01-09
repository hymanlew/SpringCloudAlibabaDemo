package com.hyman.common.model.form.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by tianc on 2019/8/28.
 */
@Data
@Builder
@ApiModel("订单退款申请对象")
public class OrderRefundForm {
    @NotBlank(message = "订单编号不能为空")
    @ApiModelProperty(value = "订单编号", required = true)
    private String orderId;

    @NotNull(message = "支付方式不能为空")
    @ApiModelProperty(value = "支付方式(1账户 2微信支付 3支付宝 4云鸟钱包 5银联支付)", required = true)
    private Integer payType;

    @NotNull(message = "支付金额不能为空")
    @ApiModelProperty(value = "支付金额", required = true)
    private BigDecimal payMoney;

    @NotNull(message = "退款金额不能为空")
    @ApiModelProperty(value = "退款金额", required = true)
    private BigDecimal refundMoney;
}
