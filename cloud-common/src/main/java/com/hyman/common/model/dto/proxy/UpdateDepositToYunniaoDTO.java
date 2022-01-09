package com.hyman.common.model.dto.proxy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: tianchong
 * @create: 2019-12-25
 * @description: 同步用户押金信息到云鸟，目的：在小程序端交押金后，不需要再从S端再交一次押金
 **/
@Data
@Builder
@ApiModel("同步用户押金信息到云鸟 入参")
public class UpdateDepositToYunniaoDTO implements Serializable {

    @ApiModelProperty(value = "缴费记录id")
    private String source_id;

    @ApiModelProperty(value = "缴费状态(100已缴费 200退款中 300已退款)")
    private Integer deposit_status;
}
