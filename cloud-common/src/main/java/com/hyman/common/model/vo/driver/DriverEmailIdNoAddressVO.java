package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lvrongyu

 * @Describe 司机部分信息
 */
@Data
@ApiModel("司机部分信息vo")
public class DriverEmailIdNoAddressVO implements Serializable {

    private static final long serialVersionUID = -665346799945995411L;

    @ApiModelProperty(value="司机id")
    private String driverId;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="身份证号")
    private String idNo;

    @ApiModelProperty(value="居住地址")
    private String address;
}
