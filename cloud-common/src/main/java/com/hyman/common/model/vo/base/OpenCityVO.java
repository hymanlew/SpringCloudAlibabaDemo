package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: OpenCityVO <br>
 * date: 2020/7/16 16:09 <br>
 * author: hyman <br>
 */
@Data
@ApiModel("开通地市返回VO")
@AllArgsConstructor
@NoArgsConstructor
public class OpenCityVO {

    @ApiModelProperty("区域Code")
    private String code;

    @ApiModelProperty("区域名")
    private String name;
}
