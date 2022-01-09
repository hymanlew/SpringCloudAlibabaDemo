package com.hyman.common.model.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tianc on 2019/8/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("订单支付回调通知接口返回对象")
public class OrderPayNotifyVO {
    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "订单类型")
    private Integer orderType;

    @ApiModelProperty(value = "司机用户编号")
    private String userId;
}
