package com.hyman.common.model.form.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author:
 * @create: 2019-06-10
 * @description: 生成新订单，产品信息 v1.5
 **/
@Data
@ApiModel("生成新订单，产品信息 v1.5")
public class ProductInfoForGeneraNewOrder implements Serializable {
    private static final long serialVersionUID = 4749573248751871558L;

    // =============================产品信息============================

    @ApiModelProperty(value = "产品Id")
    @NotBlank(message = "产品Id不能为空")
    @Length(min = 0, max = 200, message = "产品Id长度必须介于 0 和 200 之间")
    private String productId;

    @ApiModelProperty(value = "产品方案名字")
    @NotBlank(message = "产品方案名字不能为空")
    @Length(min = 0, max = 200, message = "产品方案名字长度必须介于 0 和 200 之间")
    private String productName;

    @ApiModelProperty(value = "城市")
    @NotNull(message = "城市不能为空")
    @Range(min = 0, max = 999999, message = "城市值在[0,999999]之间")
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

    @ApiModelProperty(value = "无税车价")
    @NotNull(message = "无税车价不能为空")
    @Range(min = 0, max = 999999, message = "无税车价值在[0,999999]之间")
    private Double noTax;

    @ApiModelProperty(value = "购置税")
    @NotNull(message = "购置税不能为空")
    @Range(min = 0, max = 999999, message = "购置税值在[0,999999]之间")
    private Double purchaseTax;

    @ApiModelProperty(value = "购置税税率")
    private Double taxRate;

    @ApiModelProperty(value = "佣金比例")
    private Double commission;

    // =============================保险============================

    @ApiModelProperty(value = "保险是否需要【1，需要，2不需要】")
    @NotNull(message = "保险是否需要不能为空")
    @Range(min = 1, max = 2, message = "保险是否需要值在[1,2]之间")
    private Integer insuranceNeed;

    @ApiModelProperty(value = "承保公司名称")
//    @NotBlank(message = "承保公司名称不能为空")
//    @Length(min = 0, max = 32, message = "承保公司名称长度必须介于 0 和 32 之间")
    private String insuranceName;

    @ApiModelProperty(value = "商业险")
//    @NotNull(message = "商业险不能为空")
//    @Range(min = 0, max = 999999, message = "商业险值在[0,999999]之间")
    private Double commercialInsurance;

    @ApiModelProperty(value = "交强险")
//    @NotNull(message = "交强险不能为空")
//    @Range(min = 0, max = 999999, message = "交强险值在[0,999999]之间")
    private Double toPayHighInsurance;

    @ApiModelProperty(value = "车船税")
//    @NotNull(message = "车船税不能为空")
//    @Range(min = 0, max = 999999, message = "车船税值在[0,999999]之间")
    private Double travelTax;

    @ApiModelProperty(value = "保险总额")
    private Double totalInsurance;

    @ApiModelProperty(value = "保险填写方式【1 明细填写  2总额填写】")
    private Integer insuranceType;

    // =============================gps============================

    @ApiModelProperty(value = "GPS是否需要【1，需要，2不需要】")
    @NotNull(message = "GPS是否需要不能为空")
    @Range(min = 1, max = 2, message = "GPS是否需要值在[1,2]之间")
    private Integer gpsneed;

    @ApiModelProperty(value = "GPS厂商名称")
//    @NotBlank(message = "GPS厂商名称不能为空")
//    @Length(min = 0, max = 32, message = "GPS厂商名称长度必须介于 0 和 32 之间")
    private String gpsname;

    @ApiModelProperty(value = "GPS金额")
//    @NotNull(message = "GPS金额不能为空")
//    @Range(min = 0, max = 999999, message = "GPS金额值在[0,999999]之间")
    private Double gpsprice;


    // =============================其它购车服务============================

    @ApiModelProperty(value = "其他购车服务是否需要【1，需要，2不需要】")
    @NotNull(message = "其他购车服务是否需要不能为空")
    @Range(min = 1, max = 2, message = "其他购车服务是否需要值在[1,2]之间")
    private Integer otherNeed;

    @ApiModelProperty(value = "上牌费")
//    @NotNull(message = "上牌费不能为空")
//    @Range(min = 0, max = 999999, message = "上牌费值在[0,999999]之间")
    private Double boardFee;

    @ApiModelProperty(value = "临牌费")
//    @NotNull(message = "临牌费不能为空")
//    @Range(min = 0, max = 999999, message = "临牌费值在[0,999999]之间")
    private Double tempBoardFee;


    // =============================金融============================


    @ApiModelProperty(value = "金融是否需要【1，是，2否】")
    @NotNull(message = "金融是否需要【1，是，2否】")
    @Range(min = 1, max = 2, message = "金融是否需要值在[1,2]之间")
    private Integer financianlNeed;

    @ApiModelProperty(value = "金融服务商名称")
//    @NotBlank(message = "金融服务商名称不能为空")
//    @Length(min = 0, max = 32, message = "金融服务商名称长度必须介于 0 和 32 之间")
    private String financialName;

    @ApiModelProperty(value = "金融服务商名称中文")
    private String financialNameChn;

    @ApiModelProperty(value = "分期参数")
//    @NotNull(message = "分期参数不能为空")
    private Integer stagingParam;

    @ApiModelProperty(value = "分期参数名称")
    private String stagingParamName;

    @ApiModelProperty(value = "有多少个月")
    private Double monthCount;

    @ApiModelProperty(value = "有多少个月[1年 是 12 ，算月平均使用]")
    private Double monthCountAll;

    @ApiModelProperty(value = "首付比")
//    @NotNull(message = "首付比不能为空")
//    @Range(min = 0, max = 1, message = "首付比值在[0,1]之间")
    private Double paymentRatio;

    @ApiModelProperty(value = "年费率")
//    @NotNull(message = "年费率不能为空")
//    @Range(min = 0, max = 1, message = "年费率值在[0,1]之间")
    private Double annualizedRate;

    @ApiModelProperty(value = "金融手续费")
//    @NotNull(message = "金融手续费不能为空")
//    @Range(min = 0, max = 999999, message = "金融手续费值在[0,999999]之间")
    private Double financialFees;

    @ApiModelProperty(value = "贷款保证金")
//    @NotNull(message = "贷款保证金不能为空")
//    @Range(min = 0, max = 999999, message = "贷款保证金值在[0,999999]之间")
    private Double loanDeposit;

    @ApiModelProperty(value = "是否支持购置税分期【1，是，2否】")
//    @NotNull(message = "是否支持购置税分期不能为空")
//    @Range(min = 1, max = 2, message = "是否支持购置税分期值在[1,2]之间")
    private Integer purchaseTaxStaging;

    @ApiModelProperty(value = "是否支持车险分期【1，是，2否】")
//    @NotNull(message = "是否支持车险分期不能为空")
//    @Range(min = 1, max = 2, message = "是否支持车险分期值在[1,2]之间")
    private Integer autoInsuranceStaging;

    @ApiModelProperty(value = "是否支持GPS分期【1，是，2否】")
//    @NotNull(message = "是否支持GPS分期不能为空")
//    @Range(min = 1, max = 2, message = "是否支持GPS分期值在[1,2]之间")
    private Integer gpsstaging;

    @ApiModelProperty(value = "是否支持金融手续费分期【1，是，2否】")
//    @NotNull(message = "是否支持金融手续费分期不能为空")
//    @Range(min = 1, max = 2, message = "是否支持金融手续费分期值在[1,2]之间")
    private Integer financialFeeStaging;

    @ApiModelProperty(value = "贷款金额【前台输入而来】")
    private Double loanAmountCalc;

    @ApiModelProperty(value = "客户总利息【计算而来】")
    private Double totalInterestCalc;

    @ApiModelProperty(value = "月供【计算而来】")
    private Double monthPaymentCalc;

    @ApiModelProperty(value = "首付【计算而来】")
    private Double downPaymentCalc;

    // =============================司机收入支出============================

    @ApiModelProperty(value = "司机月收入")
    private Double driverMonthIncome;

    @ApiModelProperty(value = "首次支付总计")
    @NotNull(message = "首次支付总计不能为空")
    @Range(min = 0, max = 999999, message = "首次支付总计值在[0,999999]之间")
    private Double totalPayment;

    @ApiModelProperty(value = "订单金额总计")
    @NotNull(message = "订单金额总计不能为空")
    @Range(min = 0, max = 999999, message = "订单金额总计值在[0,999999]之间")
    private Double totalOrder;

    @ApiModelProperty(value = "合作年限")
    @NotNull(message = "合作年限不能为空")
    @Range(min = 0, max = 50, message = "合作年限值在[0,50]之间")
    private Integer yearOfCooperation;

    @ApiModelProperty(value = "保障收入【计算而来】")
    @NotNull(message = "保障收入不能为空")
    @Range(min = 0, max = 999999, message = "保障收入值在[0,999999]之间")
    private Double protectAmountCalc;

    @ApiModelProperty(value = "线路管理费")
    @NotNull(message = "线路管理费不能为空")
    @Range(min = 0, max = 999999, message = "线路管理费值在[0,999999]之间")
    private Double lineManagementFee;

    @ApiModelProperty(value = "违章押金")
    @NotNull(message = "违章押金不能为空")
    @Range(min = 0, max = 999999, message = "违章押金范围值在[0,999999]之间")
    private Double depositViolation;

    @ApiModelProperty(value = "支付渠道")
    //@NotNull(message = "支付渠道不能为空")
    @Range(min = 0, max = 999, message = "支付渠道值在[0,999]之间")
    private Integer purchaseWay;

    /**
     * 页面回显使用
     */
    @ApiModelProperty(value = "支付渠道【中文】")
    private String purchaseWayName;

    @ApiModelProperty(value = "裸车首付")
    private Double bareCarDownPayment;

    @ApiModelProperty(value = "其它购车服务")
    private Double otherCarPurchaseServices;

    @ApiModelProperty(value = "贷款总额")
    private Double loanAmount;

    @ApiModelProperty(value = "管理费首款")
    private Double managementFeeFirst;

    @ApiModelProperty(value = "管理费尾款")
    private Double managementFee;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "交款单号尾数后四位")
    private String last4Nums;

}
