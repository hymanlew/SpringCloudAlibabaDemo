package com.hyman.common.model.vo.wechat.corp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiahao
 * @date 2020-3-25
 */
@ApiModel("上传图片结果实体")
@Data
public class WxCpUploadImagVO implements Serializable {

    private static final long serialVersionUID = -2016786534450596142L;

    @ApiModelProperty(value = "返回图片地址")
    private String url;

}
