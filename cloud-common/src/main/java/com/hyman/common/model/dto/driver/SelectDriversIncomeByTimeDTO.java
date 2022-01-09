package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-06-28
 * @description:
 **/
@Data
public class SelectDriversIncomeByTimeDTO implements Serializable {

    private static final long serialVersionUID = -7398487110107901649L;

    @ApiModelProperty(value = "司机编号")
    private String driverId;


    @ApiModelProperty(value = "第三方司机id")
    private String thirdDriverId;

    @ApiModelProperty(value = "云鸟 客户名称")
    private String customerName;

    @ApiModelProperty(value = "司机总价格")
    private Integer dpriceTotal;

    @ApiModelProperty(value = "司机保障费总额")
    private Integer driverInsuranceMoney;

    @ApiModelProperty(value = "基础运费价格【基础运费价格=司机总价格+司机保障费 】 ")
    private Integer basicFreightPrice;

    /**
     * v1.5 其他扣款 取自   司机财务账户 >账户列表 >业务流水详情列表 中 变动金额-减少 字段
     * v1.9 之后，其他扣款（注意不算管理费【补充：涵盖管理费三个字的扣减项，都不进行统计】）
     */
    @ApiModelProperty(value = "变动金额-减少")
    private Integer moneyDecrease;

    @ApiModelProperty(value = "扣款项备注")
    private String sourceType;

    @ApiModelProperty(value = "出车天数")
    private Integer days;

    @ApiModelProperty(value = "日期")
    private String incomeDateToDay;

    @ApiModelProperty(value = "司机收入合计【=司机基础运力价格”+“司机提成运费】")
    private Integer totalDriverIncome;

    @ApiModelProperty(value = "司机基础运力价格合计")
    private Integer dpricePerDayTotal;

    @ApiModelProperty(value = "司机提成运费合计")
    private Integer driverBonusMoney;

    @ApiModelProperty(value = "司机补贴总额合计")
    private Integer dpriceSubsidyTotal;

    @ApiModelProperty(value = "司机收入总数值 v1.11")
    private Integer moneyAll;

    @ApiModelProperty(value = "司机收入正值 v1.11")
    private Integer moneyPositive;

    @ApiModelProperty(value = "司机收入负值 v1.11")
    private Integer moneyNegative;


}