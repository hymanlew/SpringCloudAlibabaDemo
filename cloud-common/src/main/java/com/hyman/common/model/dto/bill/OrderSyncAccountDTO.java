package com.hyman.common.model.dto.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 同步账户相关金额DTO
 *
 * @author hucl
 * @date 2020/10/9 17:43
 */
@Getter
@Setter
@ApiModel
public class OrderSyncAccountDTO implements Serializable {

    private static final long serialVersionUID = 5043620132976764106L;
    /**
     * 可提现金额
     */
    @ApiModelProperty(value = "可提现金额")
    @NotNull(message = "可提现金额不能为空")
    private BigDecimal canExtractMoney;

    /**
     * 冻结金额
     */
    @ApiModelProperty(value = "冻结金额")
    @NotNull(message = "冻结金额不能为空")
    private BigDecimal freezingMoney;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    @NotBlank(message = "订单编号不能为空")
    private String orderId;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    @NotBlank(message = "司机编号不能为空")
    private String driverId;

    /**
     * 支付方式(1账户 2微信支付 3云鸟钱包 4支付宝 5银联支付 9梧桐平台)
     */
    /*@ApiModelProperty(value = "支付方式(1账户 2微信支付 3云鸟钱包 4支付宝 5银联支付 9梧桐平台")
    @NotNull(message = "支付方式不能为空")
    private Integer payType;*/

    /**
     * 订单审核(待审核、审核通过、不通过)时间
     */
    @ApiModelProperty(value = "订单审核(待审核、审核通过、不通过)时间")
    @NotNull(message = "订单审核(待审核、审核通过、不通过)时间不能为空")
    private Date happenedDate;

    //订单支付信息
    private List<OrderPayRecordInfoDTO> orderPayRecordInfoDTOS;


    /**
     * 订单待审核节点
     * 对可提金额(在此应为负数或0)和冻结金额(在此应为正数或0)的正负做判断
     *
     * @return 金额格式正确返回true，否则返回false
     */
    public boolean orderToBeApprovedMoneyCheck() {
        return getCanExtractMoney().signum() <= 0 && getFreezingMoney().signum() >= 0;
    }

    /**
     * 订单审核不通过节点
     * 对可提金额(在此 应为正数)和冻结金额(在此应为负数)的正负做判断
     *
     * @return 金额格式正确返回true，否则返回false
     */
    public boolean orderNotApprovedMoneyCheck() {
        return getCanExtractMoney().signum() >= 0 && getFreezingMoney().signum() <= 0;
    }

}
