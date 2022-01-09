package com.hyman.common.model.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by tianc on 2019/8/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("订单退款申请返回对象")
public class OrderRefundVO {

    @ApiModelProperty(value = "退款金额")
    private BigDecimal refundMoney;
}
