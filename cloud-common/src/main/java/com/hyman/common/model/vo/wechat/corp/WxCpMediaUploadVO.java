package com.hyman.common.model.vo.wechat.corp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class WxCpMediaUploadVO implements Serializable {

  private static final long serialVersionUID = 6400352841405179955L;

  @ApiModelProperty(value = "媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)")
  private String type;
  @ApiModelProperty(value = "媒体文件上传后获取的唯一标识，3天内有效")
  private String mediaId;
  @ApiModelProperty(value = "媒体文件上传时间戳")
  private long createdAt;

}
