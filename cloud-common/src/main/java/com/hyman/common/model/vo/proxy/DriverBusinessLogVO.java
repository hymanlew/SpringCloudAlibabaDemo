package com.hyman.common.model.vo.proxy;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-06-25
 * @description: 云鸟司机扣减项
 **/
@Data
@Builder
public class DriverBusinessLogVO implements Serializable {

    private static final long serialVersionUID = 9086957330172836916L;

    @ApiModelProperty(value = "司机编号【云鸟侧】")
    private String thirdDriverId;

    @ApiModelProperty(value = "流水编号")
    private String businessId;

    @ApiModelProperty(value = "变动金额-减少")
    private double moneyDisplay;

    @ApiModelProperty(value = "变动类型")
    private String sourceTypeDisplay;

    @ApiModelProperty(value = "业务发生相关时间")
    private String createdAtDisplay;

}
