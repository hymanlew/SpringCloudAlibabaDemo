package com.hyman.common.model.form.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author:
 * @create: 2019-08-28
 * @description: 收入支出信息
 **/
@Data
@ApiModel("收入支出信息 v1.11")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncomeAndExpenditureInformation implements Serializable {
    private static final long serialVersionUID = 7558742723263871564L;

    @ApiModelProperty(value = "合作年限")
    @NotNull(message = "合作年限不能为空")
    @Range(min = 0, max = 50, message = "合作年限值在[0,50]之间")
    private Integer yearOfCooperation;

    @ApiModelProperty(value = "合作年限[中文]")
    private String yearOfCooperationName;

    @ApiModelProperty(value = "保障收入")
    @NotNull(message = "保障收入不能为空")
    @Range(min = 0, max = 99, message = "保障收入值在[0,99]之间")
    private Integer protectAmountCalc;

    @ApiModelProperty(value = "保障收入[中文]")
    private String protectAmountCalcName;

    @ApiModelProperty(value = "线路管理费")
    @NotNull(message = "线路管理费不能为空")
    @Range(min = 0, max = 99, message = "线路管理费值在[0,99]之间")
    private Integer lineManagementFee;

    @ApiModelProperty(value = "线路管理费【中文】")
    private String lineManagementFeeName;

    @ApiModelProperty(value = "支付渠道")
    //@NotNull(message = "支付渠道不能为空")
    @Range(min = 0, max = 99, message = "支付渠道值在[0,99]之间")
    private Integer purchaseWay;

    @ApiModelProperty(value = "支付渠道[中文]")
    private String purchaseWayName;

    @ApiModelProperty(value = "管理费首款")
    @NotNull(message = "管理费首款不能为空")
    @Range(min = 0, max = 999999, message = "管理费首款值在[0,999999]之间")
    private Double managementFeeFirst;

    @ApiModelProperty(value = "管理费尾款")
    private Double managementFee;

    @ApiModelProperty(value = "交款单号尾数后四位")
    private String last4Nums;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "服务费抽佣")
    private String serviceFee;

}
