package com.hyman.common.model.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-03-28
 * @description: 生成订单返回对象
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("生成订单返回对象")
public class GenerateOrderDTO implements Serializable {

    private static final long serialVersionUID = -8030811724311596115L;
    @ApiModelProperty(value = "返回标记")
    private boolean flag;

    @ApiModelProperty(value = "返回内容")
    private String msg;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "再此以前是否有过订单  0:再此之前没有生成,当前订单为未成交 ；1已经生成过订单，当前订单未成交；2已经生成过订单，当前订单成交状态")
    private int currentOrderState;
}
