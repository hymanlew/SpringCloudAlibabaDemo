package com.hyman.common.model.dao.line;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "line_shelf_new_todo")
public class LineShelfNewDAO implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 待办ID
     */
    @Column(name = "agent_id")
    private String agentId;

    /**
     * 线路ID
     */
    @Column(name = "line_id")
    private String lineId;

    /**
     * 项目ID
     */
    @Column(name = "project_id")
    private String projectId;

    /**
     * 检查状态(1、待检查,2、检查通过，3、检查不通过)
     */
    @Column(name = "inspection_status")
    private Integer inspectionStatus;

    /**
     * 外线BD处理状态(1、待处理2、已完成)
     */
    @Column(name = "bd_processing_status")
    private Integer bdProcessingStatus;
    /**
     * 处理优先级(1、暂不处理，2待处理)
     */
    @Column(name = "processing_priority")
    private Integer processingPriority;

    /**
     * 拒绝原因类型（1、项目策展信息2、线路基本信息）
     */
    @Column(name = "rejection_reasons_type")
    private Integer rejectionReasonsType;

    /**
     * 拒绝原因
     */
    @Column(name = "rejection_reasons")
    private String rejectionReasons;

    /**
     * 项目策展信息快照标识
     */
    @Column(name = "project_curation_snapshot_flag")
    private String projectCurationSnapshotFlag;

    /**
     * 线路信息快照标识
     */
    @Column(name = "line_snapshot_flag")
    private String lineSnapshotFlag;

    /**
     * 线路信息快照ID
     */
    @Column(name = "line_snapshot_id")
    private String lineSnapshotId;

    /**
     * 移除标识
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 外线销售ID
     */
    @Column(name = "line_sale_id")
    private Integer lineSaleId;

    /**
     * 城市（已开通业务的）
     */
    @Column(name = "city")
    private Integer city;


    /**
     * 创建人ID
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 代办创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改人ID
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 代办更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

}