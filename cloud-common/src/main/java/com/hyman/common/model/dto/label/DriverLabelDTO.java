package com.hyman.common.model.dto.label;

import com.hyman.common.model.dto.BasicMQDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author oujunting
 * @date 2021-05-11
 * @description 司机标签消息体
 */
@Data
public class DriverLabelDTO extends BasicMQDTO implements Serializable {

    private static final long serialVersionUID = 8787192081408694759L;

    /**
     * 司机ID
     */
    private String driverId;

    /**
     * 车型
     */
    private String carType;

    /**
     * 电油分类 0油车，1电车
     */
    private Integer oilElectricityRequirement;

    /**
     * 能否闯禁行 0否，1是
     */
    private Integer canBreakingNodriving;

    /**
     * 能否闯限行 0否 1是
     */
    private Integer canBreakingTrafficRestriction;

    /**
     * 可跑禁行区域-省
     */
    private Integer breakingNodrivingProvince;

    /**
     * 可跑禁行区域-市
     */
    private Integer breakingNodrivingCity;

    /**
     * 可跑禁行区域-区县 可多选，逗号分隔
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
     * 可跑限行区域-区县 可多选，逗号分隔
     */
    private String breakingTrafficRestrictionCounty;

    /**
     * 现居住地址-省
     */
    private Integer liveProvince;

    /**
     * 现居住地址-市
     */
    private Integer liveCity;

    /**
     * 现居住地址-区县
     */
    private Integer liveCounty;

    /**
     * 现居住地址-具体地址
     */
    private String liveDistrict;

    /**
     * 业务类型 0专车 1共享
     */
    private Integer busiType;

    /**
     * 期望运费-月
     */
    private BigDecimal expectIncomeMonth;

    /**
     * 期望运费-趟
     */
    private BigDecimal expectIncomeTrip;

    /**
     * 期望稳定/临时（多选，逗号分割）
     */
    private String expectStabilityTemporary;

    /**
     * 意向货物类型 可多选，逗号分割
     */
    private String intentCargoType;

    /**
     * 期望配送复杂度
     */
    private String expectDeliveryDifficulty;

    /**
     * 装卸接受度：不需要装卸/轻装卸/重装卸
     */
    private Integer heavyLiftingType;

    /**
     * 期望账期
     */
    private Integer expectAccountingPeriod;

    /**
     * 是否小白 0否 1是
     */
    private Integer isNovice;

    /**
     * 成交日期
     */
    private Date dealDate;

    /**
     * 当月新成交：0当月成交新司机、1往期成交司机、2没有成交
     */
    private Integer currentMonthNewDeal;

    /**
     * 司机情况
     */
    private Integer driverSituation;

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
    private Long arriveWarehouseStartTime;

    /**
     * 配送结束时间
     */
    private Long deliveryEndTime;

    /**
     * 可工作时间段（空闲时间）例如：9-10,14-15
     * 前端传值
     */
    private String canWorkTime;

    /**
     * 冗余的可工作时间段，一个是前端传的，一个是计算出来的。这个是计算出来的
     */
    private String workTime;

    /**
     * 最后一次出车日期
     */
    private Date lastRunDate;

    /**
     * 否为租赁全藏
     */
    private Boolean isRentalHide;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新人
     */
    private Integer updateId;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 删除标识 0未删除 1已删除
     */
    private Integer delFlag;
}
