package com.hyman.common.model.dto.match;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2019/7/22 17:10
 * @Description: 根据线路查询标书
 */
@Data
public class RunningTenderInfoForLineDTO implements Serializable {
    private static final long serialVersionUID = 4759939821457469614L;

    @JsonIgnore
    @ApiModelProperty("标书状态")
    private Integer status;

    @ApiModelProperty("在跑标书id")
    private String tenderId;

    @ApiModelProperty("在跑标书状态")
    private String tenderStatusName;

}
