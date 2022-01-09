package com.hyman.common.model.dto.proxy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: tianchong
 * @create: 2019-12-25
 * @description: 同步用户押金信息到云鸟，目的：在小程序端交押金后，不需要再从S端再交一次押金
 **/
@Data
@ApiModel("同步用户押金信息到云鸟 入参")
public class SyncDepositToYunniaoDTO implements Serializable {

    private static final long serialVersionUID = -5569191595277465586L;
    @ApiModelProperty(value = "缴费记录id")
    private String source_id;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = " 单位（分）")
    private Integer deposit;

    @ApiModelProperty(value = "缴费状态(100已缴费 200退款中 300已退款)")
    private Integer deposit_status;

    @ApiModelProperty(value = "小程序编码(100云鸟城配 200云鸟司机俱乐部)")
    private Integer program_code;

    @ApiModelProperty(value = "押金缴纳时间（字符串格式：yyyy-MM-dd HH:mm:ss）")
    private String paid_at;
}
