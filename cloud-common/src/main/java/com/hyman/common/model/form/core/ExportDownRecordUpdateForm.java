package com.hyman.common.model.form.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@ApiModel("更新导出下载记录对象")
public class ExportDownRecordUpdateForm {

    @Length(max = 32, message = "记录编号过长")
    @NotBlank(message = "记录编号不能为空")
    @ApiModelProperty(value = "记录编号")
    private String recordId;

    @Length(max = 64, message = "文件名称过长")
    @NotBlank(message = "文件名称不能为空")
    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @NotNull(message = "导出状态不能为空")
    @ApiModelProperty(value = "导出状态(1待处理2处理中3成功4失败)")
    private Integer status;

    @NotNull(message = "数据数量不能为空")
    @ApiModelProperty(value = "数据数量")
    private Integer dataNum;

    @Length(max = 150, message = "文件url过长")
    @NotBlank(message = "文件url不能为空")
    @ApiModelProperty(value = "文件url")
    private String fileUrl;

}