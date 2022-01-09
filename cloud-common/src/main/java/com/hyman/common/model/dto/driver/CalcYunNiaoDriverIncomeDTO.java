package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-08-15
 * @description: 定时调度同步云鸟司机收入对象
 **/
@Data
@ApiModel("定时调度同步云鸟司机收入对象")
@ToString
public class CalcYunNiaoDriverIncomeDTO implements Serializable {
    private static final long serialVersionUID = -4380794700318441743L;

//    @ApiModelProperty(value = "同步标记位【1启用同步 ，2停止同步】 参看 CalcFlagEnum ")
//    private Integer calcFlag;

    /**
     * 在司机维度停止同步收入赋予的值
     */
    @ApiModelProperty(value = "同步截止时间【如果为空表示没有停止】")
    private String stopCalcTime;

    @ApiModelProperty(value = "司机编号")
    private String driverId;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "云鸟司机编号")
    private String thirdDriverId;

    /**
     * v1.6之后就不再使用
     */
    @ApiModelProperty(value = "货主编号")
    private String goodsOwnerId;

    @ApiModelProperty(value = "获取收入开始时间")
    private String startTime;

    @ApiModelProperty(value = "获取收入截止时间")
    private String endTime;
}
