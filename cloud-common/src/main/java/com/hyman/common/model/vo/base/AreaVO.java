package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: AreaVO <br>
 * date: 2020/7/13 10:10 <br>
 * author: hyman <br>
 */
@Data
@ApiModel("区域信息返回VO")
public class AreaVO {

    @ApiModelProperty("主键Id")
    private int id;

    @ApiModelProperty("区域Code")
    private String code;

    @ApiModelProperty("区域名")
    private String name;

}
