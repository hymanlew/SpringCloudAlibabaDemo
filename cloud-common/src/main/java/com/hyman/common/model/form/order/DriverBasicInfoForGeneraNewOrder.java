package com.hyman.common.model.form.order;

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
import java.util.Date;

/**
 * @author:
 * @create: 2019-06-10
 * @description: 生成订单中，司机基础信息
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("生成订单中，司机基础信息 v1.5")
public class DriverBasicInfoForGeneraNewOrder implements Serializable {

    private static final long serialVersionUID = -3356214607616540954L;
    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    @NotBlank(message = "司机编号不能为空")
    @Length(min = 0, max = 32, message = "司机编号长度必须介于 0 和 32 之间")
    private String driverId;

    /**
     * 标书编号
     */
    @ApiModelProperty(value = "标书编号")
    private String bidId;

    /**
     * 司机姓名
     */
    @ApiModelProperty(value = "司机姓名")
    @NotBlank(message = "司机姓名不能为空")
    @Length(min = 0, max = 32, message = "司机名称长度必须介于 0 和 32 之间")
    private String driverName;

    /**
     * 司机电话
     */
    @ApiModelProperty(value = "司机电话")
    @NotBlank(message = "司机电话不能为空")
    @Length(min = 0, max = 11, message = "司机电话长度必须介于 0 和 11 之间")
    private String driverPhone;

    /**
     * 意向车型
     */
    @ApiModelProperty(value = "意向车型")
    @NotNull(message = "意向车型不能为空")
    @Range(min = 0, max = 999999, message = "意向车型在[0,999999]之间")
    private Integer carType;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
//    @NotBlank(message = "身份证号不能为空")
//    @Length(min = 0, max = 18, message = "身份证号长度必须介于 0 和 18 之间")
    private String idNumber;

    /**
     * 工作城市
     */
    @ApiModelProperty(value = "工作城市")
    @NotNull(message = "工作城市不能为空")
    @Range(min = 1, max = 999999, message = "工作城市在[1,999999]之间")
    private Integer workCity;

    /**
     * 工作城市，显示详情的时候使用该字段，直接展示中文
     */
    @ApiModelProperty(value = "工作城市[中文]")
    private String workCityName;

    /**
     * 现居住地址
     */
    @ApiModelProperty(value = "现居住地址")
    @NotBlank(message = "现居住地址不能为空")
    @Length(min = 0, max = 32, message = "现居住地址长度必须介于 0 和 32 之间")
    private String address;

    /**
     * 开户银行
     */
    @ApiModelProperty(value = "开户银行")
//    @NotBlank(message = "开户银行不能为空")
//    @Length(min = 0, max = 32, message = "开户银行长度必须介于 0 和 32 之间")
    private String bankName;

    /**
     * 开户支行
     */
    @ApiModelProperty(value = "开户支行")
//    @NotBlank(message = "开户支行不能为空")
//    @Length(min = 0, max = 32, message = "开户支行长度必须介于 0 和 32 之间")
    private String accountOpeningBranch;

    /**
     * 银行开户名
     */
    @ApiModelProperty(value = "银行开户名")
//    @NotBlank(message = "银行开户名不能为空")
//    @Length(min = 0, max = 32, message = "银行开户名长度必须介于 0 和 32 之间")
    private String accountName;

    /**
     * 银行卡号
     */
    @ApiModelProperty(value = "银行卡号")
//    @NotBlank(message = "银行卡号不能为空")
//    @Length(min = 0, max = 32, message = "银行卡号长度必须介于 0 和 32 之间")
    private String cardNumber;

    /**
     * 合同起始时间
     */
    @ApiModelProperty(value = "合同起始时间")
    private Date contractStart;

    /**
     * 合同截止时间
     */
    @ApiModelProperty(value = "合同截止时间")
    private Date contractEnd;

    public void setPhone(String driverPhone) {
        // 手机号验证
        driverPhone = driverPhone.trim();
        if (driverPhone.length() != 11) {
            throw new IllegalArgumentException(String.format("手机号：%s 不合法,请输入合法11位手机号", driverPhone));
        } else {
            this.driverPhone = driverPhone;
        }
    }

//    public void setIdNumber(String idNumber) {
//        // 身份证号验证
//        if (Objects.isNull(IDCardUtil.identitycardverification(idNumber))) {
//            this.idNumber = idNumber;
//        } else {
//            throw new IllegalArgumentException(String.format("身份证号：%s 不合法", idNumber));
//        }
//    }

    public void setBankName(String bankName) {
        if (StringUtils.isBlank(bankName)) {
            this.bankName = "0";
        } else {
            this.bankName = bankName;
        }
    }

    public void setAccountOpeningBranch(String accountOpeningBranch) {
        if (StringUtils.isBlank(accountOpeningBranch)) {
            this.accountOpeningBranch = "0";
        } else {
            this.accountOpeningBranch = accountOpeningBranch;
        }

    }

    public void setAccountName(String accountName) {
        if (StringUtils.isBlank(accountName)) {
            this.accountName = "0";
        } else {
            this.accountName = accountName;
        }
    }

    public void setCardNumber(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            this.cardNumber = "0";
        } else {
            this.cardNumber = cardNumber;
        }
    }
}
