package com.hyman.common.model.dao.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com.hyman.common.model.dao.driver.DriverFeedbackIssueInfoDAO")
@Data
@Table(name = "qzn_driver.driver_feedback_issue_info")
public class DriverFeedbackIssueInfoDAO implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "自增ID")
    private Long id;

    /**
     * 司机反馈的问题id
     */
    @Column(name = "issue_id")
    @ApiModelProperty(value = "司机反馈的问题id")
    private String issueId;

    /**
     * 问题类型id
     */
    @Column(name = "issue_type")
    @ApiModelProperty(value = "问题类型id")
    private Integer issueType;

    /**
     * 问题内容
     */
    @Column(name = "issue_content")
    @ApiModelProperty(value = "问题内容")
    private String issueContent;

    /**
     * 城市
     */
    @Column(name = "city")
    @ApiModelProperty(value = "城市")
    private Integer city;

    /**
     * 司机id
     */
    @Column(name = "driver_user_id")
    @ApiModelProperty(value = "司机id")
    private String driverUserId;

    /**
     * 处理次数
     */
    @Column(name = "handle_count")
    @ApiModelProperty(value = "处理次数")
    private Integer handleCount;

    /**
     * 处理状态
     */
    @Column(name = "`state`")
    @ApiModelProperty(value = "处理状态")
    private Integer state;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 最后一次修改人员
     */
    @Column(name = "update_id")
    @ApiModelProperty(value = "最后一次修改人员")
    private Long updateId;

    /**
     * 最后一次修改时间
     */
    @Column(name = "update_date")
    @ApiModelProperty(value = "最后一次修改时间")
    private Date updateDate;

    private static final long serialVersionUID = 493326372540746767L;
}