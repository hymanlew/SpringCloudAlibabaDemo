package com.hyman.common.model.dao.tender;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mybatis Generator 2019/03/20
 */
@ApiModel(value = "com.hyman.domain.match.model.dao.BidDocumentInfoDAO")
@Data
@Table(name = "`bid_document_info`")
public class BidDocumentInfoDAO extends BaseDAO implements Serializable {
    private static final long serialVersionUID = 4955126175770360866L;
    /**
     * 标书编号
     */
    @Column(name = "`bid_id`")
    @ApiModelProperty(value = "标书编号")
    private String bidId;

    /**
     * 标书类型(1普通 2竞价)
     */
    @Column(name = "`bid_type`")
    @ApiModelProperty(value = "标书类型(1普通 2竞价)")
    private Integer bidType;

    /**
     * 线路编号
     *
     * 0o k,
     */
    @Column(name = "`line_id`")
    @ApiModelProperty(value = "线路编号")
    private String lineId;

    /**
     * 业务类型
     */
    @Column(name = "busi_type")
    @ApiModelProperty(value = "业务类型")
    private Integer busiType;

    /**
     * 城市
     */
    @Column(name = "`city`")
    @ApiModelProperty(value = "城市")
    private Integer city;

    /**
     * 司机编号
     */
    @Column(name = "`driver_id`")
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 司机名称
     */
    @Column(name = "`driver_name`")
    @ApiModelProperty(value = "司机名称")
    private String driverName;

    /**
     * 司机电话
     */
    @Column(name = "`driver_phone`")
    @ApiModelProperty(value = "司机电话")
    private String driverPhone;

    /**
     * 标书状态
     */
    @Column(name = "`state`")
    @ApiModelProperty(value = "标书状态")
    private Integer state;

    /**
     * 订单编号
     */
    @Column(name = "`order_id`")
    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @Column(name = "`appointment_date`")
    @ApiModelProperty(value = "预计上岗时间")
    private Date appointmentDate;

    @Column(name = "`deadline_reason`")
    @ApiModelProperty("标书下线原因")
    private Integer deadlineReason;

    @Column(name = "`numbers`")
    @ApiModelProperty("报价司机个数")
    private Integer numbers;

    @Column(name = "`quotation_deadline`")
    @ApiModelProperty(value = "报价截止时间")
    private Date quotationDeadline;

    @Column(name = "`work_start_date`")
    @ApiModelProperty(value = "上车日期")
    private Date workStartDate;

    @Column(name = "`auction_scene_id`")
    @ApiModelProperty(value = "拍场编号")
    private String auctionSceneId;

    @Column(name = "`guidance_price`")
    @ApiModelProperty(value = "指导价")
    private BigDecimal guidancePrice;

    @Column(name = "`delivery_type`")
    @ApiModelProperty(value = "配送类型(1随时上岗 2固定日期)")
    private Integer deliveryType;


    /**
     * 中标价
     */
    @Column(name = "win_bid_price")
    @ApiModelProperty(value = "中标价")
    private BigDecimal winBidPrice;

    /**
     * 次高价
     */
    @Column(name = "second_high_price")
    @ApiModelProperty(value = "次高价")
    private BigDecimal secondHighPrice;

    /**
     * 成交价
     */
    @Column(name = "deal_price")
    @ApiModelProperty(value = "成交价")
    private BigDecimal dealPrice;


}