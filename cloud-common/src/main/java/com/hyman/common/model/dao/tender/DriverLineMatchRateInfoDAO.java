package com.hyman.common.model.dao.tender;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com-hyman-common-model-dao-tender-DriverLineMatchRateInfoDAO")
@Data
@Table(name = "qzn_match.driver_line_match_rate_info")
public class DriverLineMatchRateInfoDAO implements Serializable {
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 司机编号
     */
    @Column(name = "driver_id")
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 线路编号
     */
    @Column(name = "line_id")
    @ApiModelProperty(value = "线路编号")
    private String lineId;

    /**
     * 匹配率
     */
    @Column(name = "rate")
    @ApiModelProperty(value = "匹配率")
    private Double rate;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private static final long serialVersionUID = -3804747790237596180L;
}