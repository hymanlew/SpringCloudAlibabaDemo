package com.hyman.common.model.dto.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description: OperManagerDTO <br>
 * date: 2020/7/17 10:32 <br>
 * author: hyman <br>
 */
@Data
@ApiModel("运营经理DTO")
@AllArgsConstructor
public class OperManagerDTO {

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "企业微信Id")
    private String corpUserId;
}
