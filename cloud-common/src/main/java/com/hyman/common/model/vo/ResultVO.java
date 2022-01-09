package com.hyman.common.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tc on 2019/5/7.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("接口返回标准vo")
public class ResultVO {

    @ApiModelProperty(value = "返回码，默认200：正常")
    private Integer code = 200;

    @ApiModelProperty(value = "返回消息")
    private String msg;
}
