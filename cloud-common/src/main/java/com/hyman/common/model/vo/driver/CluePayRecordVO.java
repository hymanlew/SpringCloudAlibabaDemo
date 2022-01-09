package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lishuai
 */
@Data
public class CluePayRecordVO implements Serializable {

    /**
     * 线索id

     */
    @ApiModelProperty("线索id")
    private String clueId;

    /**
     * 支付金额
     */
    @ApiModelProperty("支付金额")
    private BigDecimal money;

    /**
     * 订单支付编号
     */
    @ApiModelProperty("完整流水号")
    private String outTradeNo;

    /**
     * 支付方式(1账户 2微信支付 3云鸟钱包 4支付宝 5银联支付)
     */
    @ApiModelProperty("支付类型")
    private Integer payType;

    /**
     * 支付状态(1待支付 2支付成功 3支付失败)
     */
    @ApiModelProperty("支付状态")
    private Integer status;

    /**
     * 支付时间
     */
    @ApiModelProperty("支付日期")
    private Date payDate;

}
