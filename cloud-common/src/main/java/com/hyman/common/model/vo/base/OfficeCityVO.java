package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: OfficeCityVO <br>
 * date: 2020/7/20 16:53 <br>
 * author: hyman <br>
 */
@Data
@ApiModel("组织城市VO")
public class OfficeCityVO {


    @ApiModelProperty("区域Code")
    private String code;

    @ApiModelProperty("区域名")
    private String name;
}
