package com.hyman.common.model.vo.order;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: ChenJingBin
 * @date: 2020/7/7
 */
@Data
@ApiModel("交付信息")
public class OrderDeliverVO {

    /**
     * 订单详情
     */
    @ApiModelProperty(value = "订单详情")
    private OrderInfoVO orderInfoVO;


    /**
     * 返利详情
     */
    @ApiModelProperty(value = "返利详情")
    private List<OrderDeliverRebateVO> orderDeliverRebateVOs;

    /**
     * 逻辑主键
     */
    @ApiModelProperty(value = "逻辑主键")
    private Integer id;

    /**
     * 业务主键
     */
    @ApiModelProperty(value = "业务主键")
    private String orderId;

    /**
     * 合作模式
     */
    @ApiModelProperty(value = "合作模式")
    private Integer cooperationModel;

    /**
     * 合作模式中文描述
     */
    @ApiModelProperty(value = "合作模式中文描述")
    private String cooperationModelName;


    /**
     * 交付状态
     */
    @ApiModelProperty(value = "交付状态")
    private Integer status;

    /**
     * 交付状态中文描述
     */
    @ApiModelProperty(value = "交付状态中文描述")
    private String statusName;


    /**
     * 交付人
     */
    @ApiModelProperty(value = "交付人")
    private Integer dealId;

    /**
     * 交付人姓名
     */
    @ApiModelProperty(value = "交付人姓名")
    private String dealName;

    /**
     * 交付完成时间
     */
    @ApiModelProperty(value = "交付完成时间")
    private Date dealTime;

    /**
     * 运营经理
     */
    @ApiModelProperty(value = "运营经理")
    private Integer operationId;

    /**
     * 运营经理姓名
     */
    @ApiModelProperty(value = "运营经理姓名")
    private String operationName;

    /**
     * 交车日期
     */
    @ApiModelProperty(value = "交车日期")
    private Date deliveryTime;

    /**
     * 发动机号
     */
    @ApiModelProperty(value = "发动机号")
    private String engineNo;

    /**
     * 发动机发票号
     */
    @ApiModelProperty(value = "发动机发票号")
    private String engineInvoiceNo;

    /**
     * 金融返利
     */
    @ApiModelProperty(value = "金融返利")
    private BigDecimal financialRebate;

    /**
     * 保险返利
     */
    @ApiModelProperty(value = "保险返利")
    private BigDecimal insuranceRebate;

    /**
     * 上牌返利
     */
    @ApiModelProperty(value = "上牌返利")
    private BigDecimal plateNoRebate;

    /**
     * 其他返利
     */
    @ApiModelProperty(value = "其他返利")
    private BigDecimal otherRebate;

    /**
     * gps供应商
     */
    @ApiModelProperty(value = "gps供应商")
    private Integer gpsSupplier;

    /**
     * gps供应商文字描述
     */
    @ApiModelProperty(value = "gps供应商文字描述")
    private String gpsSupplierName;

    /**
     * gps设备号
     */
    @ApiModelProperty(value = "gps设备号")
    private String gpsDeviceNo;

    /**
     * gps的sim号
     */
    @ApiModelProperty(value = "gps的sim号")
    private String gpsSimNo;
}
