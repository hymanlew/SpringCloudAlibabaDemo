package com.hyman.common.model.dao.line;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "line_shelf_redundant_todo")
public class LineShelfRedundantDAO {
    /**
     * 自增ID
     */
    @Id
    private Long id;

    /**
     * 待办ID
     */
    @Column(name = "agent_id")
    private String agentId;

    /**
     * 外线BD处理状态(1、待处理2、已完成)
     */
    @Column(name = "processing_status")
    private Integer processingStatus;

    /**
     * 线路ID
     */
    @Column(name = "line_id")
    private String lineId;



    /**
     * 冗余代办归属(1、线路运营2、外线BD)
     */
    @Column(name = "redundant_agent_ownership")
    private Integer redundantAgentOwnership;

    /**
     * 下架原因（运营专属）
     */
    @Column(name = "shelves_reasons")
    private String shelvesReasons;

    /**
     * 代办状态(1、已下架、2忽略)
     */
    @Column(name = "agent_status")
    private Integer agentStatus;

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
     * 删除标志
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 线路创建时间/激活时间
     */
    @Column(name = "line_create_date")
    private Date lineCreateDate;

    /**
     * 创建人ID
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 代办生成时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新人ID
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 代办更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;


}