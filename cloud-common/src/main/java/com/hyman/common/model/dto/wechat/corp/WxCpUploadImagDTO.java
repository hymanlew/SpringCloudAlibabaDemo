package com.hyman.common.model.dto.wechat.corp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianchong
 * @date 2020-4-27
 */
@ApiModel("企业微信上传图片结果dto")
@Data
public class WxCpUploadImagDTO implements Serializable {

    private static final long serialVersionUID = -6256961342245074421L;

    @ApiModelProperty(value = "媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)")
    private String type;
    @ApiModelProperty(value = "媒体文件上传后获取的唯一标识，3天内有效")
    private String mediaId;
    @ApiModelProperty(value = "媒体文件上传时间戳")
    private long createdAt;

    @ApiModelProperty(value = "返回图片地址")
    private String imageUrl;

}
