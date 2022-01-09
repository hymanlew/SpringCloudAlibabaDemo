package com.hyman.common.model.vo.order;

import lombok.Data;

/**
 * @author xiefujiang
 * @Classname DriverSelectVO
 * @Description
 * @Date 2020/10/20
 */
@Data
public class DriverSelectVO {

    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 司机编号
     */
    private String driverId;
    /**
     * 司机姓名
     */
    private String driverName;
    /**
     * 电话
     */
    private String driverPhone;
}
