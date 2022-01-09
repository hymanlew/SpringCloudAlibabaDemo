package com.hyman.common.model.dto.bill;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: WuYangXu
 * @date: 2020/7/30
 */
@Data
public class OrderPayRecordInfoDTO implements Serializable {

    private static final long serialVersionUID = -2244842778004016821L;

    /**
     * 支付金额
     */
    private BigDecimal money;

    /**
     * 支付方式(1账户 2微信支付 3云鸟钱包 4支付宝 5银联支付 9梧桐平台)
     */
    @ApiModelProperty(value = "支付方式(1账户 2微信支付 3云鸟钱包 4支付宝 5银联支付 9梧桐平台")
//    @NotNull(message = "支付方式不能为空")
    private Integer payType;

    //支付方式名称
    private String payTypeName;

    /**
     * 支付时间
     */
    private Date payDate;

    /**
     * 支付状态(1待支付 2支付中 3已支付 4取消支付 5回调支付成功 6回调支付失败)
     */
    private Integer status;

    /**
     * 预支付交易会话标识
     */
    @Column(name = "prepay_id")
    private String prepayId;

    /**
     * 商户订单号(订单支付编号)
     */
    @Column(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 交易编号
     */
    @Column(name = "transaction_id")
    private String transactionId;

    /**
     * 订单支付截图路径
     */
    private String payImageUrl;

    /**
     * 备注
     */
    @Column(name="remarks")
    private String remarks;

    /**
     * 删除标记
     */
    private Integer delFlag;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人编号
     */
    private Integer createId;

    /**
     * 是否使用可提现金额
     */
    private Integer useWithdrawable;




}
