package com.hyman.common.model.vo.line;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author:zhanglichao
 * @Date:2021/1/20 13:34
 * @Description:
 */
@Data
public class BatchLineDeliveryDetailInfoVO {

    /**
     * 线路编号
     */
    @ApiModelProperty(value = "线路编号")
    private String lineId;

    /**
     * 配送开始时间
     */
    @JsonFormat(pattern = "HH:mm")
    @ApiModelProperty(value = "配送开始时间")
    private String workingTimeStart;

    /**
     * 配送结束时间
     */
    @JsonFormat(pattern = "HH:mm")
    @ApiModelProperty(value = "配送结束时间")
    private String workingTimeEnd;

}
