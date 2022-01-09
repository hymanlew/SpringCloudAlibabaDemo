package com.hyman.common.model.form.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author:
 * @create: 2019-08-28
 * @description: 租车需要的产品信息
 **/
@Data
@ApiModel("租车需要的产品信息 v1.11")
public class ProductInformationRequiredForCarRental implements Serializable {
    private static final long serialVersionUID = -6691794372304174226L;

    @ApiModelProperty(value = "租车车型")
    @NotNull(message = "租车类型不能为空")
    @Range(min = 0, max = 50, message = "租车类型 值在[0,50]之间")
    private Integer carRentalType;

    @ApiModelProperty(value = "租车车型【中文】")
    private String carRentalTypeName;

    @ApiModelProperty(value = "租赁方式【1总部租赁，2雷鸟租赁，3自拓租赁】")
    @NotNull(message = "租赁方式不能为空")
    @Range(min = 0, max = 50, message = "租赁方式值在[0,50]之间")
    private Integer rentalMethod;

    @ApiModelProperty(value = "租赁方式【1总部租赁，2雷鸟租赁，3自拓租赁】【中文】")
    private String rentalMethodName;

    @ApiModelProperty(value = "租赁公司")
    @NotNull(message = "租赁公司不能为空")
    @Range(min = 0, max = 50, message = "租赁公司值在[0,50]之间")
    private String leasingCompany;

    @ApiModelProperty(value = "租赁公司【中文】")
    private String leasingCompanyName;
}
