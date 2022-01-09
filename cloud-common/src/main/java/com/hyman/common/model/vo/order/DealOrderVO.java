package com.hyman.common.model.vo.order;

import com.hyman.common.enums.order.CooperationModelEnum;
import com.hyman.common.enums.order.OrderStatusEnum;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单VO
 * <p>
 * 司机域会调用查询司机所有已成交订单接口，会使用该实体；
 * 订单域会调用查询司机所有订单接口，也会使用该实体；
 *
 * @author wanghaitong
 * @date 2020/11/19 下午5:10
 */
@Data
public class DealOrderVO implements Serializable {

    @Column(name = "driverId")
    private String driverId;

    @Column(name = "orderId")
    private String orderId;

    @Column(name = "goodsAmount")
    private BigDecimal goodsAmount;

    /**
     * 订单状态
     */
    @Column(name = "status")
    private Integer status;
    /**
     * 订单状态
     */
    private String statusName;

    /**
     * 抽佣比例
     */
    @Column(name = "rake")
    private Double rake;

    /**
     * 合作模式(1购车 2租车 3带车)
     */
    @Column(name = "cooperationModel")
    private Integer cooperationModel;
    private String cooperationModelName;

    /**
     * 车型 注意，PRD里写的车型，但是实际上是要取订单里的合作车型cooperation_car
     */
    @Column(name = "cooperationCar")
    private String carModel;

    /**
     * 签约时间
     */
    @Column(name = "signTime")
    private Date signTime;

    /**
     * 创建人
     */
    @Column(name = "createId")
    private Long createId;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    @Column(name = "createDate")
    private Date createDate;
    /**
     * 订单审核通过时间
     */
    @Column(name = "passTime")
    private Date passTime;

    public void setStatus(Integer status) {
        this.status = status;
        this.statusName = OrderStatusEnum.getNameByCode(status);
    }

    public void setCooperationModel(Integer cooperationModel) {
        this.cooperationModel = cooperationModel;
        this.cooperationModelName = CooperationModelEnum.getNameByCode(cooperationModel);
    }
}
