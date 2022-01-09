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

@ApiModel(value = "com.hyman.common.model.dao.tender.DriverMatchHistoryInfoDAO")
@Data
@Table(name = "driver_match_history_info")
public class DriverMatchHistoryInfoDAO implements Serializable {
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 司机id
     */
    @Column(name = "driver_id")
    @ApiModelProperty(value = "司机id")
    private String driverId;

    /**
     * 线路id
     */
    @Column(name = "line_id")
    @ApiModelProperty(value = "线路id")
    private String lineId;

    /**
     * 跟进状态
     */
    @Column(name = "`state`")
    @ApiModelProperty(value = "跟进状态")
    private Integer state;

    /**
     * 跟进状态备注
     */
    @Column(name = "remark")
    @ApiModelProperty(value = "跟进状态备注")
    private String remark;

    /**
     * 跟进人id
     */
    @Column(name = "create_id")
    @ApiModelProperty(value = "跟进人id")
    private Long createId;

    /**
     * 跟进时间
     */
    @Column(name = "create_date")
    @ApiModelProperty(value = "跟进时间")
    private Date createDate;

    private static final long serialVersionUID = 8497437217735252447L;
}