package com.hyman.common.model.vo.driver;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Changyuan Su
 * @date 2019/7/3 14:54
 * @Description:
 */
@Data
public class BssDriverClueLogVO implements Serializable {
    private static final long serialVersionUID = -6883410940764068621L;

    @ApiModelProperty(value = "司机线索日志操作类型")
    private String operType;

    @JsonIgnore
    @ApiModelProperty(value = "司机线索日志创建人id")
    private Long createId;

    @ApiModelProperty(value = "司机线索日志创建人name[cn]")
    private String creatorName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "司机线索日志日期")
    private Date createDate;

    @ApiModelProperty(value = "司机线索日志跟进备注")
    private String followRemark;

    @ApiModelProperty(value = "司机线索日志跟进次数")
    private Integer count;

}
