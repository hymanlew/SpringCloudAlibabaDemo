package com.hyman.common.model.vo.line;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 线路任务详情配送时间VO
 */
@Data
public class LineDeliveryDetailInfoVO implements Serializable {
    private static final long serialVersionUID = -5175153515505738768L;
    /**
     * 配送开始时间
     */
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "配送开始时间不能为空")
    @ApiModelProperty(value = "配送开始时间")
    private String workingTimeStart;

    /**
     * 配送结束时间
     */
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "配送结束时间不能为空")
    @ApiModelProperty(value = "配送结束时间")
    private String workingTimeEnd;
}