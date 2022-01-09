package com.hyman.common.model.dto.proxy;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:
 * @create: 2018-11-20
 * @description: 调用php返回result
 **/
@Data
@Builder
public class LoginResultDTO implements Serializable {

    @ApiModelProperty(value = "返回成功标志,true成功，false失败")
    private Boolean flag;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    @ApiModelProperty(value = "司机id")
    private String driverId;

    @ApiModelProperty(value = "司机手机号，PHP mobile字段")
    private String mobile;

    @ApiModelProperty(value = "司机身份证号，PHP citizenid 字段")
    private String citizenid;
}
