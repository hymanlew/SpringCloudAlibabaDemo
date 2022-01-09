package com.hyman.common.model.dto.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description: ManagerDTO <br>
 * date: 2020/7/16 16:45 <br>
 * author: hyman <br>
 */
@Data
@ApiModel("销售经理")
@AllArgsConstructor
public class SaleManagerDTO {

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String name;
}
