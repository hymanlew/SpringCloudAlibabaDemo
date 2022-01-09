package com.hyman.common.model.vo.line;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * @Author:yanwei
 * @Date: 2020/9/7 - 17:47
 */
@Data
public class LineProjectWorkerVO implements Serializable {

    /**
     * 工作开始时间
     */
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm")
    //@NotNull(message = "工作时间不能为空")
    @ApiModelProperty(value = "工作开始时间")
    private String workerTimeStart;

    /**
     * 工作结束时间
     */
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm")
    //@NotNull(message = "工作结束时间不能为空")
    @ApiModelProperty(value = "结束时间")
    private String workerTimeEnd;

    /**
     * 是否跨夜？0：否；1：是
     */
    @Nullable
    @ApiModelProperty(value = "是否跨夜？0：否；1：是")
    private Boolean crossNight;

    /**
     * 工作耗费时长
     */
    @Nullable
    @ApiModelProperty(value = "工作耗费时长")
    private String deliverySpentTime;
}
