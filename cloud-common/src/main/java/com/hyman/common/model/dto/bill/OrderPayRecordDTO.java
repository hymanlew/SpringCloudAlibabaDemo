package com.hyman.common.model.dto.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @description:
 * @author: WuYangXu
 * @date: 2020/7/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPayRecordDTO implements Serializable {

    private static final long serialVersionUID = -4074337485299176359L;

    //订单编号
    private String orderId;

    //订单商品金额
    private BigDecimal goodsAmount;

    //用户编号
    private Long userId;

    //订单支付信息
    private List<OrderPayRecordInfoDTO> orderPayRecordInfoDTOS;


}
