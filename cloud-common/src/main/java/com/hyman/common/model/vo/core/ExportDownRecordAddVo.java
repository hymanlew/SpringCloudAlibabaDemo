package com.hyman.common.model.vo.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("创建导出下载记录返回对象")
public class ExportDownRecordAddVo {

    @ApiModelProperty(value = "记录编号")
    private String recordId;

}