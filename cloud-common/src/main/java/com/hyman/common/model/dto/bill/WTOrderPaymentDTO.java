package com.hyman.common.model.dto.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 梧桐司机账户--订单线下缴费数据迁移DTO
 *
 * @author hucl
 * @date 2020/10/27 13:38
 */
@Getter
@Setter
@ApiModel
public class WTOrderPaymentDTO implements Serializable {

    private static final long serialVersionUID = 618449145985051849L;

    /**
     * 交易日期
     */
    @ApiModelProperty(value = "交易日期")
    private Date tradeDate;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String cityName;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * 司机姓名
     */
    @ApiModelProperty(value = "司机姓名")
    private String driverName;

    /**
     * 成交人(姓名)
     */
    @ApiModelProperty(value = "成交人(姓名)")
    private String donePerson;

    /**
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式")
    private String payType;

    /**
     * 支付金额
     */
    @ApiModelProperty(value = "支付金额")
    private BigDecimal payment;

    /**
     * 支付单号
     */
    @ApiModelProperty(value = "支付单号")
    private String payNo;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 缴费订单编号
     */
    @ApiModelProperty(value = "缴费订单编号")
    private String orderId;

    /**
     * 被使用余额订单编号
     */
    @ApiModelProperty(value = "被使用余额订单编号")
    private String usedToPayOrderId;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark1;

    /**
     * 线下缴费备注2
     */
    @ApiModelProperty(value = "线下缴费备注2")
    private String remark2;
}
