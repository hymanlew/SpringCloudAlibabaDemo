package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author  jinyongyang
 * @date  2021/6/10 13:56
 */
@Data
public class FollowRunTestDetailByDriverIdVO {

    @ApiModelProperty(value = "driverId")
    protected String driverId;

    @ApiModelProperty(value = "创建跟车时间")
    protected Date createDate;

    @ApiModelProperty(value = "转试跑时间")
    protected Date toTryDate;

    @ApiModelProperty(value = "跟车开始时间")
    protected Date startDate;

    @ApiModelProperty(value = "跟车结束时间")
    protected Date endDate;

    @ApiModelProperty(value = "线路名称")
    private String lineName;

    @ApiModelProperty("仓位置")
    private String warehouseAreaName;

    @ApiModelProperty(value = "配送区域名称")
    private String deliveryAreaName;

    @ApiModelProperty(value = "配送开始时间")
    private Date deliveryStartDate;

    @ApiModelProperty(value = "配送结束时间")
    private Date deliveryEndDate;

    @ApiModelProperty(value = "配送时间段")
    private String deliveryDateStr;

//    @ApiModelProperty(value = "配送次数")
//    private Integer deliveryCount;

    @ApiModelProperty(value = "掉线原因")
    private String droppedReason;

    @ApiModelProperty(value = "司机撮合经理")
    private String driverMatchManager;

    @ApiModelProperty(value = "试跑状态")
    private Integer status;

}
