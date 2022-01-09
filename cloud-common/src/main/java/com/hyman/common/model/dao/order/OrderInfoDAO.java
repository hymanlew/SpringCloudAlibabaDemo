package com.hyman.common.model.dao.order;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "order_info")
public class OrderInfoDAO implements Serializable {
    private static final long serialVersionUID = 036637402671300177101L;
    /**
     * 自增ID
     */
    @Id
    private Long id;

    /**
     * 订单编号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 业务类型
     */
    @Column(name = "busi_type")
    private Integer busiType;

    /**
     * 订单状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 备注，这里存放审核拒绝原因
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 司机编号
     */
    @Column(name = "driver_id")
    private String driverId;

    /**
     * 城市
     */
    @Column(name = "city")
    private Integer city;

    /**
     * 合作模式(1购车 2租车 3带车)
     */
    @Column(name = "cooperation_model")
    private Integer cooperationModel;

    /**
     * 创建来源,0-喜鹊，10云雀，20web
     */
    @Column(name = "create_source")
    private Integer createSource;

    /**
     * 是否交付，0为否，1为是
     */
    @Column(name = "is_deliver")
    private Integer isDeliver;

    /**
     * 交付完成时间
     */
    @Column(name = "deliver_date")
    private Date deliverDate;

    /**
     * 是否完成支付
     */
    @Column(name = "is_pay")
    private Integer isPay;

    /**
     * 支付方式
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 支付完成时间
     */
    @Column(name = "pay_complete_time")
    private Date payCompleteTime;

    /**
     * 是否退款
     */
    @Column(name = "is_refund")
    private Integer isRefund;

    /**
     * 退款时间
     */
    @Column(name = "refund_time")
    private Date refundTime;

    /**
     * 合作期限（月）
     */
    @Column(name = "cooperation_time")
    private Integer cooperationTime;

    /**
     * 收入保障
     */
    @Column(name = "income_guarantee")
    private BigDecimal incomeGuarantee;

    /**
     * 抽佣比例(%)
     */
    private Double rake;

    /**
     * 商品金额
     */
    @Column(name = "goods_amount")
    private BigDecimal goodsAmount;

    /**
     * 已支付金额
     */
    @Column(name = "have_pay_amount")
    private BigDecimal havePayAmount;

    /**
     * 年检有效期
     */
    @Column(name = "inspection_time")
    private Date inspectionTime;

    /**
     * 保险有效期
     */
    @Column(name = "insurance_time")
    private Date insuranceTime;

    /**
     * 供应商
     */
    @Column(name = "supplier")
    private String supplier;

    /**
     * 车辆型号
     */
    @Column(name = "car_model")
    private String carModel;


    /**
     * 商品编号
     */
    @Column(name = "product_id")
    private String productId;


    /**
     * 合作车型
     */
    @Column(name = "cooperation_car")
    private Integer cooperationCar;

    /**
     * 无税车价
     */
    @Column(name = "car_price")
    private BigDecimal carPrice;

    /**
     * 车牌号
     */
    @Column(name = "plate_no")
    private String plateNo;

    /**
     * 运力配额
     */
    @Column(name = "capacity_quota")
    private Integer capacityQuota;

    /**
     * 订单确认人
     */
    @Column(name = "confirm_id")
    private Integer confirmId;

    /**
     * 订单确认时间
     */
    @Column(name = "confirm_time")
    private Date confirmTime;

    /**
     * 审核不通过人
     */
    @Column(name = "not_pass_id")
    private Integer notPassId;

    /**
     * 审核不通过时间
     */
    @Column(name = "not_pass_time")
    private Date notPassTime;

    /**
     * 审核通过人
     */
    @Column(name = "pass_id")
    private Integer passId;

    /**
     * 审核通过时间
     */
    @Column(name = "pass_time")
    private Date passTime;

    /**
     * 创建者ID
     */
    @Column(name = "create_id")
    private Integer createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 最后一次修改人员
     */
    @Column(name = "update_id")
    private Integer updateId;

    /**
     * 最后一次修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

}