package com.hyman.common.model.vo.waybill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("试跑在跑状态变更记录FROM")
public class RunTestStatusRecordVO implements Serializable {

    private static final long serialVersionUID = -4342279606739403423L;
    /**
     * 逻辑主键
     */
    @ApiModelProperty(value = "逻辑主键")
    private Long id;

    /**
     * 试跑在跑状态
     */
    @ApiModelProperty(value = "试跑在跑状态")
    private Integer status;

    /**
     * 操作人id
     */
    @ApiModelProperty(value = "操作人id")
    private Integer dealId;

    /**
     * 操作人信息
     */
    @ApiModelProperty(value = "操作人信息")
    private String dealIdMessage;

    /**
     * 掉线时间
     */
    @ApiModelProperty(value = "掉线时间")
    private Date droppedTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 操作前的状态
     */
    @ApiModelProperty(value = "操作前的状态")
    private Integer beforeState;

    /**
     * 试跑在跑编号
     */
    @ApiModelProperty(value = "试跑在跑编号")
    private String runTestId;


    /**
     * 到仓接待人
     */
    @ApiModelProperty(value = "到仓接待人")
    private String receptionist;

    /**
     * 到仓接待人手机号
     */
    @ApiModelProperty(value = "到仓接待人手机号")
    private String receptionistPhone;

    /**
     * 到仓时间
     */
    @ApiModelProperty(value = "到仓时间")
    private Date arrivalTime;

    /**
     * 岗前叮嘱
     */
    @ApiModelProperty(value = "岗前叮嘱")
    private String preJobAdvice;

    /**
     * 掉线原因
     */
    @ApiModelProperty(value = "掉线原因")
    private Integer droppedReason;

    /**
     * 掉线原因
     */
    @ApiModelProperty(value = "掉线原因")
    private String droppedReasonName;

    /**
     *  其他掉线原因
     */
    @ApiModelProperty(value = "其他掉线原因")
    private String otherReason;

    /**
     * 试跑在跑记录标识
     */
    @ApiModelProperty(value = "试跑在跑记录标识")
    private String recordFlag;

    /**
     * 配送开始时间
     */
    @ApiModelProperty(value = "配送开始时间")
    private Date deliveryStartDate;

    /**
     * 配送结束时间
     */
    @ApiModelProperty(value = "配送结束时间")
    private Date deliveryEndDate;

    /**
     * 意向失败原因 1.取消 2.爽约 3.扭头都走 4.多个试跑一个转换后其他失败 5.线路到期后失败
     */
    private Integer intentionFailureType;
    /**
     * 意向失败原因 1.取消 2.爽约 3.扭头都走 4.多个试跑一个转换后其他失败 5.线路到期后失败
     */
    private String intentionFailureTypeName;


    /**
     * 不同失败类型下意向失败原因，没有为空
     */
    private Integer intentionFailureCode;
    /**
     * 不同失败类型下意向失败原因，没有为空
     */
    private String intentionFailureCodeName;

    /**
     * 发送短信标识 0 未发送  1 已发送
     */
    private Integer sendMessageCode;

    /**
     * 试跑意向类型
     */
    @ApiModelProperty(value = "试跑意向类型name")
    private String intentionTypeName;

    /**
     * 试跑意向类型
     */
    @ApiModelProperty(value = "试跑意向类型")
    private Integer intentionType;

    /**
     * 是否发送跟车短信（0：未发送，1：发送）
     */
    @ApiModelProperty(value = "have_send_follow_car_message")
    private Integer haveSendFollowCarMessage;

    @ApiModelProperty(value = "撮合取消试跑意向原因")
    private Integer matchIntentionFailureCode;

}
