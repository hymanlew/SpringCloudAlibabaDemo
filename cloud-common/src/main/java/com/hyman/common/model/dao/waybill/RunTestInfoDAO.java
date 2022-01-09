package com.hyman.common.model.dao.waybill;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "run_test_info")
public class RunTestInfoDAO implements Serializable {

    private static final long serialVersionUID = -3260319118918121046L;
    /**
     * 自增ID
     */
    @Id
    private Long id;

    /**
     * 试跑在跑编号
     */
    @Column(name = "run_test_id")
    private String runTestId;


    /**
     * 试跑在跑状态
     */
    private Integer status;

    /**
     * 线路编号
     */
    @Column(name = "line_id")
    private String lineId;

    /**
     * 司机编号
     */
    @Column(name = "driver_id")
    private String driverId;

    /**
     * 创建者ID
     */
    @Column(name = "create_id")
    private Integer createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 最后一次修改人员
     */
    @Column(name = "update_id")
    private Integer updateId;

    /**
     * 最后一次修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 删除标识（0：不存在，1：存在）
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 掉线时间
     */
    @Column(name = "dropped_time")
    private Date droppedTime;

    /**
     * 线路快照 id
     */
    @Column(name = "line_snapshot_id")
    private String lineSnapshotId;

    /**
     * 司机信息快照 id
     */
    @Column(name = "driver_snapshot_id")
    private String driverSnapshotId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 业务类型
     */
    @Column(name = "busi_type")
    private Integer busiType;


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
     * 补录标志
     */
    @Column(name = "make_up_flag")
    private Integer makeUpFlag;

    /**
     * 是否发送过岗前叮嘱短信 0 未发送 1 已发送
     */
    @Column(name = "have_send_message")
    private Integer haveSendMessage;

    /**
     * 线路类型
     */
    @Column(name = "line_category")
    private Integer lineCategory;

    /**
     * 是否发送跟车短信
     */
    @Column(name = "have_send_follow_car_message")
    private Integer haveSendFollowCarMessage;

    /**
     * 撮合单编号
     */
    @Column(name = "match_id")
    private String matchId;

    /**
     * 撮合类型
     */
    @Column(name = "match_type")
    private Integer matchType;

    /**
     * 司机是否当月成交
     */
    @Column(name = "is_driver_deal")
    private Boolean isDriverDeal;
}
