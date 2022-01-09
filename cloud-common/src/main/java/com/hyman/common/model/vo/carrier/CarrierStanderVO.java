package com.hyman.common.model.vo.carrier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Date 2020/7/10 11:22
 * @Created by lishuai
 */
@Builder
@Data
@AllArgsConstructor
@ApiModel("运力标准返回VO")
public class CarrierStanderVO implements Serializable {

    private static final long serialVersionUID = 1812453047464206531L;

    @ApiModelProperty(value = "返回标记")
    private Boolean flag;

    @ApiModelProperty(value = "返回内容")
    private String msg;
}