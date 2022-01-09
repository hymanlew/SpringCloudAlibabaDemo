package com.hyman.common.model.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "tem_match_task_info")
public class TemMatchTaskInfoDAO implements Serializable {
    /**
     * 逻辑主键，自增长，无符号
     */
    @Id
    private Integer id;

    /**
     * 临时任务id，业务主键
     */
    @Column(name = "tem_match_task_id")
    private String temMatchTaskId;

    /**
     * 临时任务名称
     */
    private String name;

    /**
     * 临时任务明细
     */
    private String detail;

    /**
     * 临时任务状态
     */
    private Integer state;

    /**
     * 已经发送数量
     */
    @Column(name = "have_send")
    private Integer haveSend;

    /**
     * 已经送达的数量
     */
    private Integer arrived;

    /**
     * 已经上手的数量
     */
    private Integer started;

    /**
     * 已经抢单的数量
     */
    private Integer grabed;

    /**
     * 逻辑删除
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

    /**
     * 创建者id
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者id
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 即时撮合任务类型,1为临时线路，2为正式线路
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 正式线路id
     */
    @Column(name = "line_id")
    private String lineId;

}