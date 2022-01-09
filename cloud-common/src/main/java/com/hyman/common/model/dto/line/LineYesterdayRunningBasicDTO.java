package com.hyman.common.model.dto.line;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @author Changyuan Su
 * @date 2020/3/3 下午4:54
 * @Description:
 */
@ApiModel("司机运单---昨日在跑的线路的情况DTO")
@Data
public class LineYesterdayRunningBasicDTO implements Serializable {
    private static final long serialVersionUID = 4038312055376437048L;

    @ApiModelProperty("昨日上岗的标书中，需要跨夜的线路id")
    private Set<String> neededCrossNightLineId;

    @ApiModelProperty("昨日在跑线路信息")
    private List<YesterdayRunningLineInfoDTO> yesterdayRunningLineInfoDTO;


    @Data
    public static class YesterdayRunningLineInfoDTO implements Serializable {
        private static final long serialVersionUID = 1708549061299314377L;

        @ApiModelProperty("线路id")
        private String lineId;


        @ApiModelProperty("线路日价格")
        private BigDecimal cost;

    }

}
