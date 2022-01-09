package com.hyman.common.model.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tem_match_task_driver")
public class TemMatchTaskDriverDAO {
    /**
     * 逻辑主键，自增长，无符号
     */
    @Id
    private Integer id;

    /**
     * 临时任务id
     */
    @Column(name = "tem_match_task_id")
    private String temMatchTaskId;

    /**
     * 司机id
     */
    @Column(name = "driver_id")
    private String driverId;

    /**
     * 司机状态
     */
    private Integer state;

    /**
     * 推送时间，可以理解为创建时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 送达时间
     */
    @Column(name = "arrived_time")
    private Date arrivedTime;

    /**
     * 抢单时间
     */
    @Column(name = "grabed_time")
    private Date grabedTime;

    /**
     * 上岗时间
     */
    @Column(name = "work_time")
    private Date workTime;

}