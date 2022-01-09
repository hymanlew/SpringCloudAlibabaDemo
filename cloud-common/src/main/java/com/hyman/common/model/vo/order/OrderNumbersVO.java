package com.hyman.common.model.vo.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiefujiang
 * @Classname OrderNumberSVO
 * @Description
 * @Date 2020/10/15
 */
@Data
public class OrderNumbersVO implements Serializable {
    /**
     * 司机id
     */
    private String driverId;

    /**
     * 已成交订单数目
     */
    private Integer haveDealNumber;

    /**
     * 已终止订单数量
     */
    private Integer haveAbortNumber;

}
