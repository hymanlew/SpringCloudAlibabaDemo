package com.hyman.common.model.form.bill;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("校验订单支付编号FORM")
public class CheckOrderTransactionFORM implements Serializable {

    private static final long serialVersionUID = 5544211666775795236L;

    @ApiModelProperty(value = "司机编号")
    @NotBlank(message = "司机编号不能为空")
    private String driverId;

    @ApiModelProperty(value = "订单支付流水编号")
    @Size(min = 1,message = "订单支付流水编号不能为空")
    private List<String> transactionIds;

}
