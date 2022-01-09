package com.hyman.common.model.dao.tender;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "com-hyman-common-model-dao-tender-DriverLineMatchRateDetailInfoDAO")
@Data
@Table(name = "qzn_match.driver_line_match_rate_detail_info")
public class DriverLineMatchRateDetailInfoDAO implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * driver_line_match_info表的主键id
     */
    @Column(name = "match_rate_id")
    @ApiModelProperty(value = "driver_line_match_info表的主键id")
    private Integer matchRateId;

    /**
     * driver_receive_intention_info表的主键id
     */
    @Column(name = "driver_receive_intention_id")
    @ApiModelProperty(value = "driver_receive_intention_info表的主键id")
    private Integer driverReceiveIntentionId;

    /**
     * 是否与司机某条接活意向匹配
     */
    @Column(name = "is_matched")
    @ApiModelProperty(value = "是否与司机某条接活意向匹配")
    private Boolean isMatched;

    private static final long serialVersionUID = -3072515233452283162L;
}