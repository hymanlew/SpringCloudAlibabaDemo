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
public class CheckBalancesDTO implements Serializable {

    @ApiModelProperty(value = "返回成功标志,true成功，false失败")
    private Boolean flag;

    @ApiModelProperty(value = "如果失败，返回错误消息")
    private String msg;

    @ApiModelProperty(value = "司机id")
    private String driverId;

    @ApiModelProperty(value = "司机可用余额")
    private Integer money;
}
