package com.hyman.common.model.dao.line;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "line_shelf_will_todo")
public class LineShelfWillDAO implements Serializable {
    /**
     * 自增id
     */
    @Id
    private Long id;

    /**
     * 即将到期待办id
     */
    @Column(name = "agent_id")
    private String agentId;

    /**
     * 线路编号
     */
    @Column(name = "line_id")
    private String lineId;

    /**
     * 线路状态
     */
    @Column(name = "line_state")
    private Integer lineState;

    /**
     * 窗口期
     */
    @Column(name = "wait_dirve_validity")
    private Date waitDirveValidity;

    /**
     * 外线BD处理状态
     */
    @Column(name = "deal_state")
    private Integer dealState;

    /**
     * 代办状态(1、编辑、2忽略)
     */
    @Column(name = "agent_status")
    private Integer agentStatus;

    /**
     * 外线销售id
     */
    @Column(name = "line_sale_id")
    private Integer lineSaleId;
    /**
     * 城市（已开通业务的）
     */
    @Column(name = "city")
    private Integer city;

    /**
     * 删除标志（0：正常  1：删除）
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 创建人id
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新人id
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

}