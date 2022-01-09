package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "司机收入")
@Data
public class DriverIncomeDTO implements Serializable {

    private static final long serialVersionUID = -2257136599552202951L;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 第三方司机id
     */
    @ApiModelProperty(value = "第三方司机id")
    private String thirdDriverId;

    /**
     * 第三方货主id
     */
    @ApiModelProperty(value = "第三方货主id")
    private String goodsOwnerId;

    /**
     * 云鸟 客户名称
     */
    @ApiModelProperty(value = "云鸟 客户名称")
    private String customerName;

    /**
     * 收入来源类型【1云鸟，2七只鸟】
     */
    @ApiModelProperty(value = "收入来源类型【1云鸟，2七只鸟】")
    private Byte incomeSource;

    /**
     * 司机总价格
     */
    @ApiModelProperty(value = "司机总价格")
    private int dpriceTotal;

    /**
     * 司机保障费总额
     */
    @ApiModelProperty(value = "司机保障费总额")
    private int driverInsuranceMoney;

    /**
     * 收入时间
     */
    @ApiModelProperty(value = "收入时间")
    private Date incomeDate;

    // --------------v1.9新加内容 start--------------

    /**
     * 司机基础运力价格
     */
    @ApiModelProperty(value = "司机基础运力价格")
    private int dpricePerDay;

    /**
     * 司机提成运费
     */
    @ApiModelProperty(value = "司机提成运费")
    private int driverBonusMoney;

    /**
     * 司机补贴总额
     */
    @ApiModelProperty(value = "司机补贴总额")
    private int dpriceSubsidyTotal;
    // --------------v1.9新加内容 end--------------


}