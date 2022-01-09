package com.hyman.common.model.dao.dispatch;

import com.hyman.common.service.GlobalBaseService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "com-hyman-domain-dispatch-model-dao-DispatchDeliveryRecordDAO")
@Data
@Table(name = "qzn_dispatch.dispatch_delivery_record")
public class DispatchDeliveryRecordDAO extends GlobalBaseService implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "自增ID")
    private Long id;

    /**
     * 出车编号
     */
    @Column(name = "delivery_id")
    @ApiModelProperty(value = "出车编号")
    private String deliveryId;

    /**
     * 运单编号
     */
    @Column(name = "dispatch_id")
    @ApiModelProperty(value = "运单编号")
    private String dispatchId;

    /**
     * 预估运费(单位：元)
     */
    @Column(name = "predict_cost")
    @ApiModelProperty(value = "预估运费(单位：元)")
    private BigDecimal predictCost;

    /**
     * 司机确认的运费(单位：元)
     */
    @Column(name = "confirmed_cost")
    @ApiModelProperty(value = "司机确认的运费(单位：元)")
    private BigDecimal confirmedCost;

    /**
     * 运维确认的运费(单位：元)
     */
    @Column(name = "exact_cost")
    @ApiModelProperty(value = "运维确认的运费(单位：元)")
    private BigDecimal exactCost;


    /**
     * 状态
     */
    @Column(name = "`state`")
    @ApiModelProperty(value = "状态")
    private Integer state;

    /**
     * 司机编号
     */
    @Column(name = "driver_id")
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 业务类型
     */
    @Column(name = "busi_type")
    @ApiModelProperty(value = "业务类型")
    private Integer busiType;

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

    private static final long serialVersionUID = 7292587157063543456L;
}