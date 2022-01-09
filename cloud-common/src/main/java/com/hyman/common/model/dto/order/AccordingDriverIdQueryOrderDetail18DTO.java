package com.hyman.common.model.dto.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:
 * @create: 2019-07-22
 * @description: 根据司机id查询订单详情，这里提供给司机域使用  v1.8
 **/
@Data
public class AccordingDriverIdQueryOrderDetail18DTO implements Serializable {
    private static final long serialVersionUID = -7073345111424631660L;

    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "意向车型")
    private Integer carType;

    @ApiModelProperty(value = "意向车型[中文]")
    private String carTypeName;

    @ApiModelProperty(value = "标书编号")
    private String bidIds;

    @ApiModelProperty(value = "线路编号")
    private String lineIds;

    @ApiModelProperty(value = "订单状态[1待成交，2成交，3下线]")
    private Integer state;

    @ApiModelProperty(value = "订单状态[1待成交，2成交，3下线]")
    private String stateName;

    @ApiModelProperty(value = "成交时间")
    private Date dealTime;
}
