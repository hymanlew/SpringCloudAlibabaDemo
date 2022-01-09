package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiahao
 * @date 2020-04-14
 **/
@Data
@ApiModel("查看撮合打分信息 出参")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchingRateDTO implements Serializable {

    private static final long serialVersionUID = 2403663962161365931L;

    @ApiModelProperty(value = "促撮ID")
    private Long id;

    @ApiModelProperty(value = "线路ID")
    private String lineId;

    @ApiModelProperty(value = "司机ID")
    private String driverId;

    @ApiModelProperty(value = "得分")
    private Double rate;

    @ApiModelProperty(value = "时间")
    private Date createDate;
}
