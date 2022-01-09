package com.hyman.common.model.dto.line;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Changyuan Su
 * @date 2019/7/30 16:37
 * @Description: 线路任务审核人信息
 */
@ApiModel("线路任务审核人信息")
@Data
public class LineTaskAuditorInfoDTO implements Serializable {
    private static final long serialVersionUID = 6119458974341136185L;

    @JsonIgnore
    @ApiModelProperty("审核人")
    private Long auditor;


    @JsonProperty("auditor")
    @ApiModelProperty("审核人ZH-CN")
    private String auditorName;


    @ApiModelProperty("审核日期")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date auditDate;

}
