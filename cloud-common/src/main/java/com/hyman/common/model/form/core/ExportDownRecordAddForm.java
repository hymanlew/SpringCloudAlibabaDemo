package com.hyman.common.model.form.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("创建导出下载记录对象")
public class ExportDownRecordAddForm implements Serializable {

    @Length(max = 64, message = "文件名称过长")
    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @Length(max = 16, message = "文件类型过长")
    @NotBlank(message = "文件类型不能为空")
    @ApiModelProperty(value = "文件类型(司机画像、线路列表、订单列表、司机列表。。。)")
    private String fileType;

    @Length(max = 5, message = "文件格式过长")
    @NotBlank(message = "文件格式不能为空")
    @ApiModelProperty(value = "文件格式(CSV,EXCEL,PDF,TXT,WORD)")
    private String fileFormat;

    @ApiModelProperty(value = "系统类别(1梧桐系统 3雷鸟系统 6权限管理系统 7线索管理系统 8数据平台系统)")
    private Integer sysType;

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat.toUpperCase();
    }
}