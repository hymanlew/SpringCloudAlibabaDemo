package com.hyman.common.model.dto.label;
import com.hyman.common.model.dto.BasicMQDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author oujunting
 * @date 2021-05-10
 * @description 撮合中心消息体
 */
@Getter
@Setter
public class MatchLabelDTO extends BasicMQDTO implements Serializable {

    private static final long serialVersionUID = -578305666146685473L;

    /**
     * 司机编号
     */
    private String driverId;

    /**
     *能否闯禁行 0否，1是
     */
    private Boolean canBreakingNodriving;

    /**
     * 能否闯限行 0否 1是
     */
    private Boolean canBreakingTrafficRestriction;

    /**
     * 可跑禁行区域-省
     */
    private Integer breakingNodrivingProvince;

    /**
     * 可跑禁行区域-市
     */
    private Integer breakingNodrivingCity;

    /**
     * 可跑禁行区域-区县（多选，逗号分隔）
     */
    private String breakingNodrivingCounty;

    /**
     * 可跑限行区域-省
     */
    private Integer breakingTrafficRestrictionProvince;

    /**
     * 可跑限行区域-市
     */
    private Integer breakingTrafficRestrictionCity;

    /**
     * 可跑限行区域-区县（多选，逗号分隔）
     */
    private String breakingTrafficRestrictionCounty;

    /***
     * 期望配送复杂度
     */
    private String expectDeliveryDifficulty;

    /**
     * 否为租赁全藏
     */
    private Boolean isRentalHide;
    /**
     * 期望账期
     */
    private Integer expectAccountingPeriod;

    /**
     * 配送点-前端
     */
    private String deliveryPointFront;

    /**
     * 配送点-后台
     */
    private String deliveryPointBack;


    /**
     * 仓位置-前端
     */
    private String startPointFront;

    /**
     * 仓位置-后台
     */
    private String startPointBack;

    /**
     * 到仓开始时间
     */
    private Integer arriveWarehouseStartTime;

    /**
     * 到仓结束时间
     */
    private Integer arriveWarehouseEndTime;


    /**
     * 外边是否有活
     */
    private Boolean hasIncomeOutside;

    /**
     * 起始点开始时间
     */
    private Integer startingPointStartTime;

    /**
     * 配送结束时间
     */
    private Integer deliveryEndTime;


    /**
     * 可工作时间段（空闲时间）例如：9-10,14-15 计算值
     */
    private String canWorkTime;

    /**
     * 装卸接受度：不需要装卸/轻装卸/重装卸
     */
    private Integer heavyLiftingType;

    /**
     * 期望稳定/临时（多选，逗号分割）
     */
    private String expectStabilityTemporary;
    /**
     * 期望运费/趟
     */
    private BigDecimal expectIncomeTrip;
    /**
     * 司机情况
     */
    private Integer driverSituation;
}
