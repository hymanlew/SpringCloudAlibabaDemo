package com.hyman.common.model.dto.proxy;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-07-26
 * @description: 调用云鸟侧接口，梧桐司机标识
 **/
@Data
@ToString
public class IdentificationDriverDTO implements Serializable {
    private static final long serialVersionUID = -7810233263944838936L;

    @ApiModelProperty(value = "之前的云鸟司机编号【旧的司机编号】")
    private String beforeDriverId;

    @ApiModelProperty(value = "之后的云鸟司机编号【新的司机编号】")
    private String afterDriverId;

    @ApiModelProperty(value = "司机类型：专车 or 共享")
    private Integer driverType;
}
