package com.hyman.common.model.dao.line;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com.hyman.common.model.dao.line.ClueFollowInfoDAO")
@Data
@Table(name = "clue_follow_info")
public class ClueFollowInfoDAO implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "自增ID")
    private Long id;

    /**
     * 线索跟进id
     */
    @Column(name = "clue_follow_id")
    private String clueFollowId;

    /**
     * 线索id
     */
    @Column(name = "cust_clue_id")
    @ApiModelProperty(value = "线索id")
    private String custClueId;

    /**
     * 跟进方式,字典获取
     */
    @Column(name = "way")
    @ApiModelProperty(value = "跟进方式,字典获取")
    private Integer way;

    /**
     * 跟进日期
     */
    @Column(name = "follow_date")
    @ApiModelProperty(value = "跟进日期")
    private Date followDate;

    /**
     * 是否成功进行交易(1:是 2:否)
     */
    @Column(name = "successfully_traded")
    @ApiModelProperty(value = "是否成功进行交易(1:是 2:否)")
    private Integer successfullyTraded;

    /**
     * 跟进备注
     */
    @Column(name = "remarks")
    @ApiModelProperty(value = "跟进备注")
    private String remarks;

    /**
     * 创建者ID
     */
    @Column(name = "create_id")
    @ApiModelProperty(value = "创建者ID")
    private Long createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private static final long serialVersionUID = -4883214973667436160L;
}