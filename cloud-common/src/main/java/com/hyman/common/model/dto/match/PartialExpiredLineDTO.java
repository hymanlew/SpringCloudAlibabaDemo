package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2019/10/10 16:22
 * @Description: 部分失效线路id和在跑标书数实体
 */
@ApiModel("部分失效线路信息实体，line与match工程使用")
@Data
public class PartialExpiredLineDTO implements Serializable {
    private static final long serialVersionUID = -3920422186954726349L;

    @ApiModelProperty("线路id")
    private String lineId;

    @ApiModelProperty("在跑标书数量")
    private int runningCount;

}
