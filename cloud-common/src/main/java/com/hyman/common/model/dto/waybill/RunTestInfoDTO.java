package com.hyman.common.model.dto.waybill;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiefujiang
 * @Classname RunTestInfoDTO
 * @Description
 * @Date 2020/10/21
 */
@Data
public class RunTestInfoDTO implements Serializable {

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 试跑在跑编号
     */
    private String runTestId;


    /**
     * 试跑在跑状态
     */
    private Integer status;

    /**
     * 线路编号
     */
    private String lineId;

    /**
     * 司机编号
     */
    private String driverId;

    /**
     * 创建者ID
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后一次修改人员
     */
    private Integer updateId;

    /**
     * 最后一次修改时间
     */
    private Date updateDate;

    /**
     * 删除标识（0：不存在，1：存在）
     */
    private Integer delFlag;

    /**
     * 掉线时间
     */
    private Date droppedTime;

    /**
     * 线路快照 id
     */
    private String lineSnapshotId;

    /**
     * 司机信息快照 id
     */
    private String driverSnapshotId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 业务类型
     */
    private Integer busiType;

    /**
     * 线路类型
     */
    private Integer lineCategory;

    /**
     * 是否发送跟车短信
     */
    private Integer haveSendFollowCarMessage;

    /**
     * 掉线原因
     */
    private Integer dropReason;

    /**
     * 撮合ID
     */
    private String matchId;
}
