package com.hyman.common.model.dao.order;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "qzn订单信息")
@Data
@Table(name = "order_info")
public class QznOrderInfoDAO extends BaseDAO implements Serializable {

    /**
     * 订单编号
     */
    @Column(name = "order_id")
    @ApiModelProperty(value = "订单编号")
    private String orderId;

    /**
     * 业务类型
     */
    @Column(name = "busi_type")
    @ApiModelProperty(value = "业务类型")
    private Integer busiType;

    /**
     * 标书编号
     */
    @Column(name = "bid_id")
    @ApiModelProperty(value = "标书编号")
    private String bidId;

    /**
     * 司机编号
     */
    @Column(name = "driver_id")
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 司机名称
     */
    @Column(name = "driver_name")
    @ApiModelProperty(value = "司机名称")
    private String driverName;

    /**
     * 司机电话
     */
    @Column(name = "driver_phone")
    @ApiModelProperty(value = "司机电话")
    private String driverPhone;

    /**
     * 城市
     */
    @Column(name = "city")
    @ApiModelProperty(value = "城市")
    private Integer city;

    /**
     * 意向车型
     */
    @Column(name = "car_type")
    @ApiModelProperty(value = "意向车型")
    private Integer carType;

    /**
     * 首次支付总计
     */
    @Column(name = "total_payment")
    private BigDecimal totalPayment;

    /**
     * 订单金额总计
     */
    @Column(name = "total_order")
    private BigDecimal totalOrder;

    /**
     * 订单状态
     */
    @Column(name = "`state`")
    @ApiModelProperty(value = "订单状态[1待成交，2成交，3下线]")
    private Integer state;

    /**
     * 备注，这里存放审核拒绝原因
     */
    @Column(name = "`remarks`")
    @ApiModelProperty(value = "备注，这里存放审核拒绝原因")
    private String remarks;

    /**
     * 购车状态
     */
    @Column(name = "`buy_car_state`")
    @ApiModelProperty(value = "购车状态【1未交付，2已交付】")
    private Integer buyCarState;

    /**
     * 成交操作者ID
     */
    @Column(name = "`deal_id`")
    @ApiModelProperty(value = "成交操作者ID")
    protected Long dealId;

    /**
     * 成交时间
     */
    @Column(name = "`deal_date`")
    @ApiModelProperty(value = "成交时间")
    protected Date dealDate;


    @Column(name = "`pay_status`")
    @ApiModelProperty(value = "支付状态(1待支付;2支付中;3已支付;4部分支付;5支付失败)")
    private Integer payStatus;

    @Column(name = "`refund_status`")
    @ApiModelProperty(value = "退款状态(1待审核;2审核通过(待退款);3退款审核不通过;4退款中;5退款成功;6退款失败)")
    private Integer refundStatus;

    @Column(name = "`pay_money`")
    @ApiModelProperty(value = "累计支付金额")
    private BigDecimal payMoney;

    @Column(name = "`refund_money`")
    @ApiModelProperty(value = "累计退款金额")
    private BigDecimal refundMoney;

    @Column(name = "`pay_complete_time`")
    @ApiModelProperty(value = "支付完成时间")
    private Date payCompleteTime;

    @ApiModelProperty(value = "支付方式(1账户 2微信支付 3云鸟钱包 4支付宝 5银联支付)")
    private Integer payType;

    @ApiModelProperty(value = "合作模式(1购车 2租车 3带车)")
    private Integer cooperationModel;

    @ApiModelProperty(value = "服务费抽佣")
    private String serviceFee;

    private static final long serialVersionUID = -3518877740472676103L;
}