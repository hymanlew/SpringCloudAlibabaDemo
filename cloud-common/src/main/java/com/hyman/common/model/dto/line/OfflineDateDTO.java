package com.hyman.common.model.dto.line;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Changyuan Su
 * @date 2019/8/6 20:40
 * @Description:
 */
@ApiModel("线路停用时间和审核时间实体")
@Data
public class OfflineDateDTO {

    @ApiModelProperty("操作人ID")
    private Long createId;

    @ApiModelProperty("操作人姓名")
    private String creatorName;

    @ApiModelProperty("操作日期")
    private Date createDate;
}
