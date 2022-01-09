package com.hyman.common.model.dto.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2019/11/18 下午2:39
 * @Description:
 */

@ApiModel("发送订阅消息返回值")
@Data
public class WechatSendSubscribeMessageResultDTO implements Serializable {
    private static final long serialVersionUID = 662818813966660635L;

    @ApiModelProperty("错误码")
    private Integer errcode;

    @ApiModelProperty("错误信息")
    private String errmsg;

}
