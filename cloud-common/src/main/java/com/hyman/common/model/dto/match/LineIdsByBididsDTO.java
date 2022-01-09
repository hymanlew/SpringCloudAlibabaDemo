package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2019/7/22 16:58
 * @Description: 根据标书id获取线路id集合
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineIdsByBididsDTO implements Serializable {
    private static final long serialVersionUID = 3551352595043722943L;

    @ApiModelProperty("线路id")
    private String lineId;

    @ApiModelProperty("标书id")
    private String bidId;

}
