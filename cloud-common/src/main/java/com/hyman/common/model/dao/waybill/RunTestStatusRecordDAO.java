package com.hyman.common.model.dao.waybill;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "run_test_status_record")
public class RunTestStatusRecordDAO implements Serializable {

    private static final long serialVersionUID = -4342279606739403423L;
    /**
     * 逻辑主键
     */
    @Id
    private Long id;

    /**
     * 试跑在跑状态
     */
    private Integer status;

    /**
     * 操作人id
     */
    @Column(name = "deal_id")
    private Integer dealId;

    /**
     * 掉线时间
     */
    @Column(name = "dropped_time")
    private Date droppedTime;

    /**
     * 创建时间时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 操作前的状态
     */
    @Column(name = "before_state")
    private Integer beforeState;

    /**
     * 试跑在跑编号
     */
    @Column(name = "run_test_id")
    private String runTestId;

    /**
     * 到仓接待人
     */
    private String receptionist;

    /**
     * 到仓接待人手机号
     */
    @Column(name = "receptionist_phone")
    private String receptionistPhone;

    /**
     * 到仓时间
     */
    @Column(name = "arrival_time")
    private Date arrivalTime;

    /**
     * 岗前叮嘱
     */
    @Column(name = "pre_job_advice")
    private String preJobAdvice;

    /**
     * 掉线原因
     */
    @Column(name = "dropped_reason")
    private Integer droppedReason;

    /**
     * 其他掉线原因
     */
    @Column(name = "other_reason")
    private String otherReason;

    /**
     * 配送开始时间
     */
    @Column(name = "delivery_start_date")
    private Date deliveryStartDate;

    /**
     * 配送结束时间
     */
    @Column(name = "delivery_end_date")
    private Date deliveryEndDate;

    /**
     * 意向失败原因 1.取消 2.爽约 3.扭头都走 4.多个试跑一个转换后其他失败 5.线路到期后失败
     */
    @Column(name = "intention_failure_type")
    private Integer intentionFailureType;


    /**
     * 不同失败类型下意向失败原因，没有为空
     */
    @Column(name = "intention_failure_code")
    private Integer intentionFailureCode;

    /**
     * 发送短信标识 0 未发送  1 已发送
     */
    @Column(name = "send_message_code")
    private Integer sendMessageCode;

    /**
     * 试跑意向类型
     */
    @Column(name = "intention_type")
    private Integer intentionType;

    /**
     * 是否发送跟车短信（0：未发送，1：发送）
     */
    @Column(name = "have_send_follow_car_message")
    private Integer haveSendFollowCarMessage;

    /**
     * 撮合取消试跑意向原因(字典：match_intention_failure_reason)
     */
    @Column(name = "match_intention_failure_code")
    private Integer matchIntentionFailureCode;

    /**
     * 取消试跑意向来源(1: 司撮、2：H5)
     */
    @Column(name = "cancel_intention_origin")
    private Integer cancelIntentionOrigin;
}
