package com.hyman.common.model.dao.order;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author shimingming
 */
@ApiModel(value="com.hyman.common.model.dao.order.QznOrderCarDeliveryDAO")
@Data
@Table(name = "order_car_delivery")
public class QznOrderCarDeliveryDAO extends BaseDAO implements Serializable {

    /**
     * 订单编号
     */
    @Column(name = "order_id")
    @ApiModelProperty(value="订单编号")
    private String orderId;

    /**
     * 司机编号
     */
    @Column(name = "driver_id")
    @ApiModelProperty(value="司机编号")
    private String driverId;

    /**
     * 车牌号
     */
    @Column(name = "number_plate")
    @ApiModelProperty(value="车牌号")
    private String numberPlate;

    /**
     * 车架号
     */
    @Column(name = "frame_number")
    @ApiModelProperty(value="车架号")
    private String frameNumber;

    /**
     * 发动机品牌型号
     */
    @Column(name = "model")
    @ApiModelProperty(value="发动机品牌型号")
    private String model;

    /**
     * 颜色
     */
    @Column(name = "color")
    @ApiModelProperty(value="颜色")
    private String color;

    /**
     * 载重量
     */
    @Column(name = "load_capacity")
    @ApiModelProperty(value="载重量")
    private String loadCapacity;

    /**
     * 总重量
     */
    @Column(name = "total_weight")
    @ApiModelProperty(value="总重量")
    private String totalWeight;

    /**
     * 装备质量
     */
    @Column(name = "equipment_quality")
    @ApiModelProperty(value="装备质量")
    private String equipmentQuality;

    /**
     * 轮胎大小
     */
    @Column(name = "tire_size")
    @ApiModelProperty(value="轮胎大小")
    private String tireSize;

    /**
     * 配备补充备注
     */
    @Column(name = "remark")
    @ApiModelProperty(value="配备补充备注")
    private String remark;

    /**
     * 刹车系统[1,气刹，2断气刹]
     */
    @Column(name = "brake_system")
    @ApiModelProperty(value="刹车系统[1,气刹，2断气刹]")
    private Integer brakeSystem;

    /**
     * 其他参数
     */
    @Column(name = "other")
    @ApiModelProperty(value="其他参数")
    private String other;

    /**
     * 交付时间
     */
    @Column(name = "due_time")
    @ApiModelProperty(value="交付时间")
    private Date dueTime;

    private static final long serialVersionUID = -4616741899604807117L;
}