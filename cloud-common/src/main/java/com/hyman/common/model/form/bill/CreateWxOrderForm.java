package com.hyman.common.model.form.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by tianc on 2019/8/28.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("调用微信统一下单对象")
public class CreateWxOrderForm {

    @NotNull(message = "线索编号不能为空")
    @ApiModelProperty(value = "线索编号", required = true)
    private String clueId;

    @NotNull(message = "小程序来源不能为空")
    @ApiModelProperty(value = "小程序来源，取业务分类，喜鹊（专车）0，云雀（共享）1", required = true)
    private Integer busiType;

    @NotBlank(message = "订单支付编号不能为空")
    @ApiModelProperty(value = "订单支付编号", required = true)
    private String outTradeNo;

    @NotNull(message = "本次支付金额不能为空")
    @ApiModelProperty(value = "支付金额（4000）", required = true)
    private BigDecimal payMoney;

    @NotBlank(message = "商品描述不能为空")
    @ApiModelProperty(value = "商品描述", required = true)
    private String body;

    @NotBlank(message = "openId不能为空")
    @ApiModelProperty(value = "openId", required = true)
    private String openId;
}
