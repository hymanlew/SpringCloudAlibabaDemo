package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("获取更换工作城市列表")
public class WorkCityInfoVO implements Serializable {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "城市code")
    private Integer cityCode;

}
