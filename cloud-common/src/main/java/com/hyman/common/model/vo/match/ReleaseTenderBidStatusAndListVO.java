package com.hyman.common.model.vo.match;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Changyuan Su
 * @date
 */
@ApiModel("标书状态和与之对应的标书ids")
@Data
public class ReleaseTenderBidStatusAndListVO implements Serializable {
    private static final long serialVersionUID = 5596300346343584904L;

    @ApiModelProperty("状态")
    private Integer status;

    @JsonIgnore
    private String bids;

    @ApiModelProperty("标书集合")
    private List<String> bidSet;

}