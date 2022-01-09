package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * @date 2020-04-12
 **/
@ApiModel(description = "状态变更 dto 入参")
@Data
public class UpdateCorpEsStateDTO implements Serializable {
    private static final long serialVersionUID = -6772547449078308596L;


    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "最近记录状态")
    private Integer lastHistoryState;

    @ApiModelProperty(value = "最近记录状态")
    private String lastHistoryStateName;

    @ApiModelProperty(value = "最近记录备注")
    private String lastHistoryRemark;

    @ApiModelProperty(value = "最近记录时间")
    private Date lastHistoryDate;

}
