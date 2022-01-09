package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author mzll
 */
@Data
@AllArgsConstructor
public class CluePayRecordFORM implements Serializable {

    @ApiModelProperty("支付编号")
    @NotBlank(message = "支付编号不能为空")
    private String outTradeNo;

    @ApiModelProperty("支付金额")
    @NotNull(message = "支付金额不能为空")
    private Integer payMoney;

    @ApiModelProperty("支付时间")
    @NotBlank(message = "支付时间不能为空")
    private String payTime;

    @ApiModelProperty("微信支付订单")
    private String transactionId;
}
