package com.hyman.common.model.dto.line;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2020/3/5 15:03
 * @Description:
 */
@ApiModel("运单线路信息")
@Data
public class DispatchDeliveryRecordBasicLineInfoDTO implements Serializable {
    private static final long serialVersionUID = -6354821958868983298L;

    private String lineId;


    private String lineName;


    @ApiModelProperty(value = "收入结算方式：1:按趟结算 2:按提薪提成制结算")
    private Integer incomeSettlementMethod;


}
