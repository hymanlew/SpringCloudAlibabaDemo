package com.hyman.common.model.dto.proxy;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author:
 * @create: 2018-11-21
 * @description: PHP扣费
 **/
@Data
@Builder
public class DeductionDTO {

    @ApiModelProperty(value = "返回成功标志,true成功，false失败")
    private Boolean flag;

    @ApiModelProperty(value = "返回信息")
    private String msg;
}
