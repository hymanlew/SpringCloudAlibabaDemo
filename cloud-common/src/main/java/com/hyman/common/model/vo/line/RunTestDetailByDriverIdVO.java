package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName RunTestDetailByDriverIdVO
 * @Description 线路试跑详情视图
 * @Author LiuJu
 * @Date 2020/9/3 9:27
 */
@Data
public class RunTestDetailByDriverIdVO {

    @ApiModelProperty(value = "driverId")
    protected String driverId;

    @ApiModelProperty(value = "创建试跑意向时间")
    protected Date createDate;

    @ApiModelProperty(value = "试跑开始时间")
    protected Date startDate;

    @ApiModelProperty(value = "试跑结束时间")
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

    @ApiModelProperty(value = "配送次数")
    private Integer deliveryCount;

    @ApiModelProperty(value = "掉线原因")
    private String droppedReason;

    @ApiModelProperty(value = "司机撮合经理")
    private String driverMatchManager;

    @ApiModelProperty(value = "试跑状态")
    private Integer status;

}
