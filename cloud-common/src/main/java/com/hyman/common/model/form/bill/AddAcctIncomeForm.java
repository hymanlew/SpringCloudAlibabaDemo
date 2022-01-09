package com.hyman.common.model.form.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("增加账户收入请求对象")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddAcctIncomeForm {

    @NotNull(message = "用户编号不能为空")
    @ApiModelProperty(value = "用户编号", required = true)
    private String userId;

    @NotNull(message = "收入金额不能为空")
    @ApiModelProperty(value = "收入金额", required = true)
    @Min(value = 1, message = "收入金额1元起")
    private BigDecimal money;

    @NotBlank(message = "业务单号不能为空")
    @ApiModelProperty(value = "业务单号", required = true)
    private String orderNo;

    @NotBlank(message = "商品描述不能为空")
    @ApiModelProperty(value = "商品描述", required = true)
    private String description;

    @NotNull(message = "财务科目不能为空")
    @ApiModelProperty(value = "财务科目", required = true)
    @Min(value = 1000, message = "财务科目有误")
    private Integer subject;

}