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

/**
 * @Author zhanglichao
 * @Date 2020-07-08 16:25
 * @description 线路配送时间对应DAO
 */
@ApiModel(value = "com.hyman.domain.line.domain.line.repository.dao.LineDeliveryInfoDAO")
@Data
@Table(name = "line_delivery_info")
public class LineDeliveryInfoDAO implements Serializable {

    /**
     * 自增ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "自增ID")
    private Long id;

    /**
     * 线路编号
     */
    @Column(name = "line_id")
    @ApiModelProperty(value = "线路编号")
    private String lineId;

    /**
     * 配送开始时间
     */
    @Column(name = "working_time_start")
    @ApiModelProperty(value = "配送开始时间")
    private Date workingTimeStart;

    /**
     * 配送结束时间
     */
    @Column(name = "working_time_end")
    @ApiModelProperty(value = "配送结束时间")
    private Date workingTimeEnd;

    /**
     * 是否跨夜？0：否；1：是
     */
    @Column(name = "cross_night")
    @ApiModelProperty(value = "是否跨夜？0：否；1：是")
    private Boolean crossNight;

    /**
     * 配送货物耗费时长
     */
    @Column(name = "delivery_spent_time")
    @ApiModelProperty(value = "配送货物耗费时长")
    private String deliverySpentTime;

    /**
     * 创建者ID
     */
    @Column(name = "create_id")
    @ApiModelProperty(value = "创建者ID")
    private Integer createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1909849483133989685L;
}