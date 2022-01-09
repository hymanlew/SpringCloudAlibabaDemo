package com.hyman.common.model.vo.bill;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiefujiang
 * @Classname OrderPayRecordInfoVO
 * @Description
 * @Date 2020/7/8
 */
@Data
public class OrderPayRecordInfoVO implements Serializable {
    private static final long serialVersionUID = -2244842778004016821L;

    /**
     * 支付金额
     */
    @ApiModelProperty(value = "支付金额")
    private BigDecimal money;

    /**
     * 支付方式(1账户 2微信支付 3云鸟钱包 4支付宝 5银联支付)
     */
    @ApiModelProperty(value = "支付方式(1账户 2微信支付 3云鸟钱包 4支付宝 5银联支付)")
    private Integer payType;

    private String payTypeName;

    /**
     * 支付时间
     */
    @ApiModelProperty(value = "支付时间")
    private Date payDate;

    /**
     * 支付状态(1待支付 2支付中 3已支付 4取消支付 5回调支付成功 6回调支付失败)
     */
    @ApiModelProperty(value = "支付状态(1待支付 2支付中 3已支付 4取消支付 5回调支付成功 6回调支付失败)")
    private Integer status;

    /**
     * 操作类型(1全款支付 2首款支付 3尾款支付)
     */
    @ApiModelProperty(value = "操作类型(1全款支付 2首款支付 3尾款支付)")
    private Integer operateType;

    /**
     * 手续费
     */
    @ApiModelProperty(value = "手续费")
    private BigDecimal serviceFee;

    /**
     * 预支付交易会话标识
     */
    @ApiModelProperty(value = "预支付交易会话标识")
    private String prepayId;

    /**
     * 商户订单号(订单支付编号)
     */
    @ApiModelProperty(value = "商户订单号(订单支付编号)")
    private String outTradeNo;

    /**
     * 交易编号
     */
    @ApiModelProperty(value = "交易编号")
    private String transactionId;

    /**
     * 订单支付截图路径
     */
    @ApiModelProperty(value = "订单支付截图路径")
    private String payImageUrl;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 最后一次修改时间
     */
    @ApiModelProperty(value = "最后一次修改时间")
    private Date updateDate;

    /**
     * 是否使用可提现金额
     */
    @ApiModelProperty(value = "是否使用可提现金额")
    private Integer useWithdrawable;

}
