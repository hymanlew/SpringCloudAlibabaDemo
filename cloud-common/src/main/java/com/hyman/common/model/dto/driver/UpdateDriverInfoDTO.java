package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-06-12
 * @description: 内部调用更新司机信息
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("内部调用更新司机信息")
public class UpdateDriverInfoDTO implements Serializable {

    private static final long serialVersionUID = -6330553143979427656L;

    @ApiModelProperty(value = "司机编号")
    private String driverId;

    @ApiModelProperty(value = "司机名称")
    private String name;

    @ApiModelProperty(value = "司机电话")
    private String phone;

    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @ApiModelProperty(value = "现居住地址")
    private String address;

    @ApiModelProperty(value = "开户银行")
    private String bankName;

    @ApiModelProperty(value = "银行开户名")
    private String accountName;

    @ApiModelProperty(value = "银行卡号")
    private String cardNumber;

    @ApiModelProperty(value = "开户支行")
    private String accountOpeningBranch;

    @ApiModelProperty(value = "订单编号")
    private String orderId;
}
