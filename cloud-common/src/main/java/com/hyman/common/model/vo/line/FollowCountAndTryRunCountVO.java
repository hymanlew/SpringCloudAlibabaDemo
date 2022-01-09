package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author jinyongyang
 * @date 2021/6/10 17:10
 */
@Getter
@Setter
public class FollowCountAndTryRunCountVO {

    @ApiModelProperty(value = "司机Id")
    private String driverId;
    @ApiModelProperty(value = "跟车数量")
    private Integer followCount;
    @ApiModelProperty(value = "试跑数量")
    private Integer tryRunCount;
    @ApiModelProperty(value = "司机试跑在跑状态")
    List<Integer> runTestStatus;
}
