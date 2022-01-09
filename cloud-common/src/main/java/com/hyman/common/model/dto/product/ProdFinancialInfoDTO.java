package com.hyman.common.model.dto.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-08-13
 * @description: 金融服务商信息
 **/
@Data
public class ProdFinancialInfoDTO implements Serializable {
    private static final long serialVersionUID = -4077841833060472282L;

    /**
     * 自增ID
     */
    @ApiModelProperty(value = "自增ID")
    protected Long id;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private Integer city;

    /**
     * 金融服务商名称
     */
    @ApiModelProperty(value = "金融服务商名称")
    private String financialName;

    /**
     * 金融手续费
     */
    @ApiModelProperty(value = "金融手续费 ")
    private String financialFees;

    /**
     * 贷款保证金
     */
    @ApiModelProperty(value = "贷款保证金 ")
    private String loanDeposit;

    /**
     * 是否支持购置税分期【1，是，2否】
     */
    @ApiModelProperty(value = "是否支持购置税分期【1，是，2否】")
    private Integer purchaseTaxStaging;

    /**
     * 是否支持车险分期【1，是，2否】
     */
    @ApiModelProperty(value = "是否支持车险分期【1，是，2否】")
    private Integer autoInsuranceStaging;

    /**
     * 是否支持GPS分期【1，是，2否】
     */
    @ApiModelProperty(value = "是否支持GPS分期【1，是，2否】")
    private Integer gpsStaging;

    /**
     * 是否支持金融手续费分期【1，是，2否】
     */
    @ApiModelProperty(value = "是否支持金融手续费分期【1，是，2否】")
    private Integer financialFeeStaging;

    /**
     * 使用状态【默认是0，0上架，1下架】
     */
    @ApiModelProperty(value = "使用状态【默认是0，0上架，1下架】")
    private Integer useState;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;


}