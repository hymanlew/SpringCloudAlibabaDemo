package com.hyman.common.model.vo.driver;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author:
 * @create: 2019-04-17
 * @description: 支出汇总
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("支出汇总")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ExpenditureSummaryVO {


    @ApiModelProperty(value = "订单编号")
    private String orderId;


    @ApiModelProperty(value = "产品编号")
    private String productId;


    @ApiModelProperty(value = "产品名称")
    private String productName;


    @ApiModelProperty(value = "司机保障")
    private String protection;


    @ApiModelProperty(value = "支付金额")
    private String paymentAmount;


    @ApiModelProperty(value = "贷款金额")
    private String loanAmount;


    @ApiModelProperty(value = "状态")
    private String state;


    @ApiModelProperty(value = "时间")
    private Date time;
}
