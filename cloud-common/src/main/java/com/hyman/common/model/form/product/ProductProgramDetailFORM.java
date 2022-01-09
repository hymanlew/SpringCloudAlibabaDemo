package com.hyman.common.model.form.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author:
 * @create: 2019-03-23
 * @description: 产品方案创建提交表单 模板
 **/
@Data
@Builder
@AllArgsConstructor
@ApiModel("产品方案创建提交表单")
@NoArgsConstructor
public class ProductProgramDetailFORM {

    @ApiModelProperty(value = "产品方案名字")
    @NotBlank(message = "产品方案名字不能为空")
    @Length(min = 0, max = 200, message = "产品方案名字长度必须介于 0 和 200 之间")
    private String productName;

    @ApiModelProperty(value = "城市")
    @NotNull(message = "城市不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Integer city;

    @ApiModelProperty(value = "城市名字")
    private String cityName;

    @ApiModelProperty(value = "品牌")
    @NotBlank(message = "品牌不能为空")
    @Length(min = 0, max = 32, message = "品牌长度必须介于 0 和 32 之间")
    private String brand;

    @ApiModelProperty(value = "车型")
    @NotBlank(message = "车型不能为空")
    @Length(min = 0, max = 32, message = "车型长度必须介于 0 和 32 之间")
    private String carModel;

    @ApiModelProperty(value = "车型对应最低管理费")
    @NotBlank(message = "车型对应最低管理费不能为空")
    @Range(min = 0, max = 999999, message = "车型对应最低管理费[0,999999]之间")
    private Double carModelManagementFee;

    @ApiModelProperty(value = "参数")
    @NotBlank(message = "购车最关注哪些方面不能为空")
    @Length(min = 0, max = 32, message = "购车最关注哪些方面长度必须介于 0 和 32 之间")
    private String parameter;

    @ApiModelProperty(value = "购置税税率")
    @NotNull(message = "购置税税率不能为空")
    @Range(min = 0, max = 1, message = "range在[0,1]之间")
    private Double taxRate;

    @ApiModelProperty(value = "无税车价")
    @NotNull(message = "无税车价不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double noTax;

    @ApiModelProperty(value = "购置税")
    @NotNull(message = "购置税不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double purchaseTax;

    @ApiModelProperty(value = "佣金比例")
    @NotNull(message = "佣金比例不能为空")
    @Range(min = 0, max = 1, message = "range在[0,1]之间")
    private Double commission;

    @ApiModelProperty(value = "承保公司名称")
    @NotBlank(message = "承保公司名称不能为空")
    @Length(min = 0, max = 32, message = "承保公司名称长度必须介于 0 和 32 之间")
    private String insuranceName;

    @ApiModelProperty(value = "商业险")
    @NotNull(message = "商业险不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double commercialInsurance;

    @ApiModelProperty(value = "交强险")
    @NotNull(message = "交强险不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double toPayHighInsurance;

    @ApiModelProperty(value = "车船税")
    @NotNull(message = "车船税不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double travelTax;

    @ApiModelProperty(value = "GPS是否需要【1，需要，2不需要】")
    @NotNull(message = "GPS是否需要不能为空")
    @Range(min = 1, max = 2, message = "range在[1,2]之间")
    private Integer GPSNeed;

    @ApiModelProperty(value = "GPS厂商名称")
    @NotBlank(message = "购车最关注哪些方面不能为空")
    @Length(min = 0, max = 32, message = "购车最关注哪些方面长度必须介于 0 和 32 之间")
    private String GPSName;

    @ApiModelProperty(value = "GPS金额")
    @NotNull(message = "GPS金额不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double GPSPrice;

    @ApiModelProperty(value = "是否需要【1，需要，2不需要】")
    @NotNull(message = "是否需要不能为空")
    @Range(min = 1, max = 2, message = "range在[1,2]之间")
    private Integer otherNeed;

    @ApiModelProperty(value = "上牌费")
    @NotNull(message = "上牌费不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double boardFee;

    @ApiModelProperty(value = "临牌费")
    @NotNull(message = "临牌费不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double tempBoardFee;

    @ApiModelProperty(value = "金融是否需要【1，是，2否】")
    @NotNull(message = "金融是否需要【1，是，2否】")
    @Range(min = 1, max = 2, message = "range在[1,2]之间")
    private Integer financianlNeed;

    @ApiModelProperty(value = "金融服务商名称")
    @NotBlank(message = "金融服务商名称不能为空")
    @Length(min = 0, max = 32, message = "金融服务商名称长度必须介于 0 和 32 之间")
    private String financialName;

    @ApiModelProperty(value = "金融手续费")
    @NotNull(message = "金融手续费不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double financialFees;

    @ApiModelProperty(value = "贷款保证金")
    @NotNull(message = "贷款保证金不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double loanDeposit;

    @ApiModelProperty(value = "是否支持购置税分期【1，是，2否】")
    @NotNull(message = "是否支持购置税分期不能为空")
    @Range(min = 1, max = 2, message = "range在[1,2]之间")
    private Integer purchaseTaxStaging;

    @ApiModelProperty(value = "是否支持车险分期【1，是，2否】")
    @NotNull(message = "是否支持车险分期不能为空")
    @Range(min = 1, max = 2, message = "range在[1,2]之间")
    private Integer autoInsuranceStaging;

    @ApiModelProperty(value = "是否支持GPS分期【1，是，2否】")
    @NotNull(message = "是否支持GPS分期不能为空")
    @Range(min = 1, max = 2, message = "range在[1,2]之间")
    private Integer GPSStaging;

    @ApiModelProperty(value = "是否支持金融手续费分期【1，是，2否】")
    @NotNull(message = "是否支持金融手续费分期不能为空")
    @Range(min = 1, max = 2, message = "range在[1,2]之间")
    private Integer financialFeeStaging;

    @ApiModelProperty(value = "金融分期")
    @Valid
    private List<StagingFORM> staging;

    @ApiModelProperty(value = "线路管理费最低价")
    @NotNull(message = "线路管理费最低价不能为空")
    @Range(min = 0, max = 999999, message = "range在[0,999999]之间")
    private Double lowestLineManagementFee;

}

