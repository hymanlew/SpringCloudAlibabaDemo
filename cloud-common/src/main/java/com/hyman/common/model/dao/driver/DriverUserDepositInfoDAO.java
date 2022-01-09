package com.hyman.common.model.dao.driver;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Description;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "com.hyman.common.model.dao.driver.DriverUserDepositInfoDAO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "driver_user_deposit_info")
@Description("注意！！!目前这张表只有合伙用户使用")
public class DriverUserDepositInfoDAO extends BaseDAO implements Serializable {

    private static final long serialVersionUID = -3514949852426410410L;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    @ApiModelProperty(value = "用户编号")
    private String userId;

    /**
     * 商户订单号(订单支付编号)
     */
    @Column(name = "out_trade_no")
    @ApiModelProperty(value = "商户订单号(订单支付编号)")
    private String outTradeNo;

    /**
     * 微信支付订单号(支付回调返回)
     */
    @Column(name = "transaction_id")
    @ApiModelProperty(value = "微信支付订单号(支付回调返回)")
    private String transactionId;

    /**
     * 押金金额
     */
    @Column(name = "deposit_fee")
    @ApiModelProperty(value = "押金金额")
    private BigDecimal depositFee;

    /**
     * 押金状态
     * 【1微信收款尚未确认，2微信收款已经确认，3微信退款尚未确认，4微信退款已经确认】
     */
    @Column(name = "`state`")
    @ApiModelProperty(value = "押金状态【1微信收款尚未确认，2微信收款已经确认，3微信退款尚未确认，4微信退款已经确认】")
    private Integer state;

    @Column(name = "pay_type")
    @ApiModelProperty(value = "支付方式")
    private Integer payType;

    @Column(name = "url")
    @ApiModelProperty(value = "缴费截图url")
    private String url;

    @Column(name = "remarks")
    @ApiModelProperty(value = "备注")
    private String remarks;

}