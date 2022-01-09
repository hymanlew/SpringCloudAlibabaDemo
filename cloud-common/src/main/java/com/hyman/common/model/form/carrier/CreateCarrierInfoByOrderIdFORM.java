package com.hyman.common.model.form.carrier;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author mzll
 * @Date 2020/7/10 11:05
 * @Created by lishuai
 */
@Data
public class CreateCarrierInfoByOrderIdFORM implements Serializable {

    private static final long serialVersionUID = -6817608957599966115L;
    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "司机id")

    private String driverId;

    @ApiModelProperty(value = "车牌号")

    @Pattern(regexp = "^[\\u4e00-\\u9fa5][a-zA-Z][a-zA-Z0-9\\u4e00-\\u9fa5]{3,7}$", message = "车牌号不符合规范，请重新输入！")
    private String plateNo;

    @ApiModelProperty(value = "运营经理")
    private Integer operationId;
}
