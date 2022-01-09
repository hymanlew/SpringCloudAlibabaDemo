package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-03-20
 * @description: 司机确认签约提交信息
 **/
@Data
@Builder
@AllArgsConstructor
@ApiModel("司机确认签约提交信息")
public class DriverConfirmContractDTO implements Serializable {

    private static final long serialVersionUID = 5993861362159786775L;
    @ApiModelProperty(value = "返回标记")
    private boolean flag;

    @ApiModelProperty(value = "返回内容")
    private String msg;
}
