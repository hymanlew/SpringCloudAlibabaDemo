package com.hyman.common.model.form.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author:
 * @create: 2019-03-26
 * @description: 金融分期form
 **/
@Data
@Builder
@AllArgsConstructor
@ApiModel("金融分期form")
@NoArgsConstructor
public class StagingFORM {

    @ApiModelProperty(value = "分期参数")
    @NotNull(message = "分期参数不能为空")
    private Integer proCardFee;

    @ApiModelProperty(value = "分期参数名称")
//    @NotBlank(message = "分期参数名称不能为空")
    private String proCardFeeName;

    @ApiModelProperty(value = "首付比")
    @NotNull(message = "首付比不能为空")
    private String paymentRatio;

    @ApiModelProperty(value = "年化率")
    @NotNull(message = "年化率不能为空")
    private String annualizedRate;

    @ApiModelProperty(value = "有多少个月[1年 是 11]")
    @NotNull(message = "有多少个月不能为空")
    @Range(min = 0, max = 990, message = "有多少个月[0,999]之间")
    private Integer monthCount;

    @ApiModelProperty(value = "有多少个月[1年 是 12 ，算月平均使用]")
    @NotNull(message = "有多少个月不能为空")
    @Range(min = 0, max = 990, message = "有多少个月[0,999]之间")
    private Integer monthCountAll;

    /**
     * 首付比
     */
    @ApiModelProperty(value = "首付比[小数点格式]")
    private String paymentRatioPoint;

    /**
     * 年费率
     */
    @ApiModelProperty(value = "年费率【小数点格式】")
    private String annualizedRatePoint;
}
