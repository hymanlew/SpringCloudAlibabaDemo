package com.hyman.common.model.form.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author:
 * @create: 2019-03-23
 * @description: 产品方案基于模板提交的详情
 **/
@Data
@Builder
@ApiModel("产品方案基于模板提交的详情")
@AllArgsConstructor
@NoArgsConstructor
public class ProductProgramDetailRealFORM implements Serializable {
    private static final long serialVersionUID = -1281727499186501814L;

    // =============================产品信息============================

    @ApiModelProperty(value = "产品Id")
    @NotBlank(message = "产品Id不能为空")
    @Length(min = 0, max = 200, message = "产品Id长度必须介于 0 和 200 之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String productId;

    @ApiModelProperty(value = "产品方案名字")
    @NotBlank(message = "产品方案名字不能为空")
    @Length(min = 0, max = 200, message = "产品方案名字长度必须介于 0 和 200 之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String productName;

    @ApiModelProperty(value = "城市")
    @NotNull(message = "城市不能为空")
    @Range(min = 0, max = 999999, message = "城市值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer city;

    @ApiModelProperty(value = "城市名字")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String cityName;

    @ApiModelProperty(value = "品牌")
    @NotBlank(message = "品牌不能为空")
    @Length(min = 0, max = 32, message = "品牌长度必须介于 0 和 32 之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String brand;

    @ApiModelProperty(value = "车型")
    @NotBlank(message = "车型不能为空")
    @Length(min = 0, max = 32, message = "车型长度必须介于 0 和 32 之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String carModel;

    @ApiModelProperty(value = "参数")
    @NotBlank(message = "参数不能为空")
    @Length(min = 0, max = 32, message = "参数长度必须介于 0 和 32 之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String parameter;

    @ApiModelProperty(value = "购置税税率")
    @NotNull(message = "购置税税率不能为空")
    @Range(min = 0, max = 1, message = "购置税税率值在[0,1]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double taxRate;

    @ApiModelProperty(value = "无税车价")
    @NotNull(message = "无税车价不能为空")
    @Range(min = 0, max = 999999, message = "无税车价值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double noTax;

    @ApiModelProperty(value = "购置税")
    @NotNull(message = "购置税不能为空")
    @Range(min = 0, max = 999999, message = "购置税值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double purchaseTax;

    @ApiModelProperty(value = "佣金比例")
    @NotNull(message = "佣金比例不能为空")
    @Range(min = 0, max = 1, message = "佣金比例值在[0,1]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double commission;

    // =============================保险============================

    @ApiModelProperty(value = "承保公司名称")
    @NotBlank(message = "承保公司名称不能为空")
    @Length(min = 0, max = 32, message = "承保公司名称长度必须介于 0 和 32 之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String insuranceName;

    @ApiModelProperty(value = "商业险")
    @NotNull(message = "商业险不能为空")
    @Range(min = 0, max = 999999, message = "商业险值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double commercialInsurance;

    @ApiModelProperty(value = "交强险")
    @NotNull(message = "交强险不能为空")
    @Range(min = 0, max = 999999, message = "交强险值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double toPayHighInsurance;

    @ApiModelProperty(value = "车船税")
    @NotNull(message = "车船税不能为空")
    @Range(min = 0, max = 999999, message = "车船税值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double travelTax;

    // =============================gps============================

    @ApiModelProperty(value = "GPS是否需要【1，需要，2不需要】")
    @NotNull(message = "GPS是否需要不能为空")
    @Range(min = 1, max = 2, message = "GPS是否需要值在[1,2]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer GPSNeed;

    @ApiModelProperty(value = "GPS厂商名称")
    @NotBlank(message = "GPS厂商名称不能为空")
    @Length(min = 0, max = 32, message = "GPS厂商名称长度必须介于 0 和 32 之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String GPSName;

    @ApiModelProperty(value = "GPS金额")
    @NotNull(message = "GPS金额不能为空")
    @Range(min = 0, max = 999999, message = "GPS金额值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double GPSPrice;

    // =============================其它购车服务============================

    @ApiModelProperty(value = "其他购车服务是否需要【1，需要，2不需要】")
    @NotNull(message = "其他购车服务是否需要不能为空")
    @Range(min = 1, max = 2, message = "其他购车服务是否需要值在[1,2]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer otherNeed;

    @ApiModelProperty(value = "上牌费")
    @NotNull(message = "上牌费不能为空")
    @Range(min = 0, max = 999999, message = "上牌费值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double boardFee;

    @ApiModelProperty(value = "临牌费")
    @NotNull(message = "临牌费不能为空")
    @Range(min = 0, max = 999999, message = "临牌费值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double tempBoardFee;

    // =============================金融============================

    @ApiModelProperty(value = "金融是否需要【1，是，2否】")
    @NotNull(message = "金融是否需要【1，是，2否】")
    @Range(min = 1, max = 2, message = "金融是否需要值在[1,2]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer financianlNeed;

    @ApiModelProperty(value = "金融服务商名称")
    @NotBlank(message = "金融服务商名称不能为空")
    @Length(min = 0, max = 32, message = "金融服务商名称长度必须介于 0 和 32 之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String financialName;

    @ApiModelProperty(value = "金融手续费")
    @NotNull(message = "金融手续费不能为空")
    @Range(min = 0, max = 999999, message = "金融手续费值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double financialFees;

    @ApiModelProperty(value = "贷款保证金")
    @NotNull(message = "贷款保证金不能为空")
    @Range(min = 0, max = 999999, message = "贷款保证金值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double loanDeposit;

    @ApiModelProperty(value = "是否支持购置税分期【1，是，2否】")
    @NotNull(message = "是否支持购置税分期不能为空")
    @Range(min = 1, max = 2, message = "是否支持购置税分期值在[1,2]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer purchaseTaxStaging;

    @ApiModelProperty(value = "是否支持车险分期【1，是，2否】")
    @NotNull(message = "是否支持车险分期不能为空")
    @Range(min = 1, max = 2, message = "是否支持车险分期值在[1,2]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer autoInsuranceStaging;

    @ApiModelProperty(value = "是否支持GPS分期【1，是，2否】")
    @NotNull(message = "是否支持GPS分期不能为空")
    @Range(min = 1, max = 2, message = "是否支持GPS分期值在[1,2]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer GPSStaging;

    @ApiModelProperty(value = "是否支持金融手续费分期【1，是，2否】")
    @NotNull(message = "是否支持金融手续费分期不能为空")
    @Range(min = 1, max = 2, message = "是否支持金融手续费分期值在[1,2]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer financialFeeStaging;

    @ApiModelProperty(value = "分期参数")
    @NotNull(message = "分期参数不能为空")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer stagingParam;

    @ApiModelProperty(value = "分期参数名称")
//    @NotBlank(message = "分期参数名称不能为空")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String stagingParamName;

    @ApiModelProperty(value = "有多少个月")
    @NotNull(message = "有多少个月不能为空")
    @Range(min = 0, max = 990, message = "有多少个月值在[0,999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double monthCount;

    @ApiModelProperty(value = "有多少个月[1年 是 12 ，算月平均使用]")
    @NotNull(message = "有多少个月不能为空")
    @Range(min = 0, max = 990, message = "有多少个月值在[0,999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double monthCountAll;

    @ApiModelProperty(value = "首付比")
    @NotNull(message = "首付比不能为空")
    @Range(min = 0, max = 1, message = "首付比值在[0,1]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double paymentRatio;

    @ApiModelProperty(value = "年化率")
    @NotNull(message = "年化率不能为空")
    @Range(min = 0, max = 1, message = "年化率值在[0,1]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double annualizedRate;

    @ApiModelProperty(value = "首付【计算而来】")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double downPaymentCalc;

    @ApiModelProperty(value = "月供【计算而来】")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double monthPaymentCalc;

    @ApiModelProperty(value = "客户总利息【计算而来】")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double totalInterestCalc;

    @ApiModelProperty(value = "贷款金额【前台输入而来】")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double loanAmountCalc;

    // =============================司机收入支出============================
    /**
     * 司机月收入
     */
    @ApiModelProperty(value = "司机月收入")
//    @NotNull(message = "司机月收入不能为空")
//    @Range(min = 0, max = 999999, message = "司机月收入[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double driverMonthIncome;

    /**
     * 合作年限
     */
    @ApiModelProperty(value = "合作年限")
    @NotNull(message = "合作年限不能为空")
    @Range(min = 0, max = 50, message = "合作年限值在[0,50]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer yearOfCooperation;


    @ApiModelProperty(value = "保障收入【计算而来】")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double protectAmountCalc;


    /**
     * 裸车首付
     */
    @ApiModelProperty(value = "裸车首付")
    @NotNull(message = "裸车首付不能为空")
    @Range(min = 0, max = 999999, message = "裸车首付值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double bareCarDownPayment;


    /**
     * 其它购车服务
     */
    @ApiModelProperty(value = "其它购车服务")
    @NotNull(message = "其它购车服务不能为空")
    @Range(min = 0, max = 999999, message = "其它购车服务值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double otherCarPurchaseServices;

    /**
     * 线路管理费
     */
    @ApiModelProperty(value = "线路管理费")
    @NotNull(message = "线路管理费不能为空")
    @Range(min = 0, max = 999999, message = "线路管理费值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double lineManagementFee;

    /**
     * 首次支付总计
     */
    @ApiModelProperty(value = "首次支付总计")
    @NotNull(message = "首次支付总计不能为空")
    @Range(min = 0, max = 999999, message = "首次支付总计值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double totalPayment;

    /**
     * 贷款总额
     */
    @ApiModelProperty(value = "贷款总额")
    @NotNull(message = "贷款总额不能为空")
    @Range(min = 0, max = 999999, message = "贷款总额值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double loanAmount;

    /**
     * 违章押金
     * v1.4 新增
     */
    @ApiModelProperty(value = "违章押金")
    @NotNull(message = "违章押金不能为空")
    @Range(min = 0, max = 999999, message = "违章押金范围值在[0,999999]之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Double depositViolation;

    /**
     * 线路管理费支付凭证
     * v1.4 新增
     */
    @ApiModelProperty(value = "线路管理费支付凭证")
    @NotBlank(message = "线路管理费支付凭证不能为空")
    @Length(min = 0, max = 256, message = "线路管理费支付凭证长度必须介于 0 和 256 之间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String lineManagementFeePaymentVoucher;

    public void setLineManagementFeePaymentVoucher(String lineManagementFeePaymentVoucher) {

        if (lineManagementFeePaymentVoucher.contains(",")) {
            String[] split = lineManagementFeePaymentVoucher.split(",");
            if (split.length > 2) {
                throw new IllegalArgumentException("线路管理费支付凭证最多上传2张图片");
            }
        }

        this.lineManagementFeePaymentVoucher = lineManagementFeePaymentVoucher;
    }

    /**
     * 违章押金支付凭证
     * v1.4 新增
     */
    @ApiModelProperty(value = "违章押金支付凭证")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String violationDepositPaymentVoucher;

    public void setViolationDepositPaymentVoucher(String violationDepositPaymentVoucher) {

        if (StringUtils.isNotBlank(violationDepositPaymentVoucher) && violationDepositPaymentVoucher.contains(",")) {
            String[] split = violationDepositPaymentVoucher.split(",");
            if (split.length > 2) {
                throw new IllegalArgumentException("违章押金支付凭证最多上传2张图片");
            }
        }
        this.violationDepositPaymentVoucher = violationDepositPaymentVoucher;
    }

}

