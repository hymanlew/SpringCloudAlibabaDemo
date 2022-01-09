package com.hyman.common.model.dao.line;

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
 * Created by Su changyuan 2019/03/05
 */
@ApiModel(value = "com.hyman.domain.line.model.dao.LineTaskDAO")
@Data
@Table(name = "`line_info`")
public class LineTaskDAO extends BaseDAO implements Serializable {
    private static final long serialVersionUID = -7588733298252819338L;
    /**
     * 线路编号
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

    @Column(name = "`third_line_id`")
    @ApiModelProperty(value = "第三方线路编号")
    private String thirdLineId;

    /**
     * 客户编号
     */
    @Column(name = "`customer_id`")
    @ApiModelProperty(value = "客户编号")
    private String customerId;

    /**
     * 线路名称
     */
    @Column(name = "`line_name`")
    @ApiModelProperty(value = "线路名称")
    private String lineName;

    /**
     * 城市（已开通业务的）
     */
    @Column(name = "`city`")
    @ApiModelProperty(value = "城市（已开通业务的）")
    private Integer city;

    /**
     * 车型
     */
    @Column(name = "`car_type`")
    @ApiModelProperty(value = "车型")
    private Integer carType;

    /**
     * 货物类型
     */
    @Column(name = "`cargo_type`")
    @ApiModelProperty(value = "货物类型")
    private String cargoType;

    /**
     * 收货人类型
     */
    @Column(name = "`receiver_type`")
    @ApiModelProperty(value = "收货人类型")
    private Integer receiverType;

//    /**
//     * 仓库位置
//     */
//    @Column(name = "`warehouse`")
//    @ApiModelProperty(value = "仓库位置")
//    private String warehouse;

    /**
     * 仓库位置
     */
    @Column(name = "`warehouse_province`")
    @ApiModelProperty(value = "仓库位置-省")
    private Integer warehouseProvince;

    @Column(name = "`warehouse_city`")
    @ApiModelProperty(value = "仓库位置-市")
    private Integer warehouseCity;

    @Column(name = "`warehouse_county`")
    @ApiModelProperty(value = "仓库位置-区、县")
    private Integer warehouseCounty;

    @Column(name = "`warehouse_district`")
    @ApiModelProperty(value = "仓库位置-具体位置")
    private String warehouseDistrict;

    /**
     * 是否搬运（1是 2否）
     */
    @Column(name = "`carry`")
    @ApiModelProperty(value = "是否搬运（1是 2否）")
    private Integer carry;

    /**
     * 配送点是否固定（1是 2否）
     */
    @Column(name = "`distribution_sites`")
    @ApiModelProperty(value = "配送点是否固定（1是 2否）")
    private Integer distributionSites;

    /**
     * 是否需要返仓（1是 2否）
     */
    @Column(name = "`return_warehouse`")
    @ApiModelProperty(value = "是否需要返仓（1是 2否）")
    private Integer returnWarehouse;

    /**
     * 是否需要回单（1是 2否）
     */
    @Column(name = "`return_bill`")
    @ApiModelProperty(value = "是否需要回单（1是 2否）")
    private Integer returnBill;

    /**
     * 客户报价(单位：元)
     */
    @Column(name = "`lowest_quotations`")
    @ApiModelProperty(value = "客户报价(单位：元)")
    private BigDecimal lowestQuotations;

    /**
     * 预计每日配送点位数
     */
    @Column(name = "`delivery_num`")
    @ApiModelProperty(value = "预计每日配送点位数")
    private Integer deliveryNum;

    /**
     * 预计每日平均总里程（公里）
     */
    @Column(name = "`distance`")
    @ApiModelProperty(value = "预计每日平均总里程（公里）")
    private Double distance;

    /**
     * 预计货物总体积（立方米）
     */
    @Column(name = "`volume`")
    @ApiModelProperty(value = "预计货物总体积（立方米）")
    private Double volume;

    /**
     * 预计单件货物重量（kg）
     */
    @Column(name = "`single_cargo_weight`")
    @ApiModelProperty(value = "预计单件货物重量(kg)")
    private Integer singleCargoWeight;

    /**
     * 预计月频次
     */
    @Column(name = "`month`")
    @ApiModelProperty(value = "预计月频次")
    private Integer month;

    /**
     * 每日配送趟数
     */
    @Column(name = "`day_num`")
    @ApiModelProperty(value = "每日配送趟数")
    private Integer dayNum;

    /**
     * 预计成本(单位：元)
     */
    @Column(name = "`cost`")
    @ApiModelProperty(value = "预计成本(单位：元)")
    private BigDecimal cost;

    /**
     * 预计毛利(单位：元)
     */
    @Column(name = "`gross_profit`")
    @ApiModelProperty(value = "预计毛利(单位：元)")
    private BigDecimal grossProfit;

    /**
     * 线路状态
     */
    @Column(name = "`state`")
    @ApiModelProperty(value = "线路状态")
    private Integer state;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 油耗占总结算百分比
     */
    @Column(name = "`fuel_ratio`")
    @ApiModelProperty(value = "油耗占总结算百分比")
    private Double fuelRatio;

    /**
     * 线路省区域
     */
    @Column(name = "`province_area`")
    @ApiModelProperty(value = "线路省区域")
    private Integer provinceArea;

    /**
     * 线路市区域
     */
    @Column(name = "`city_area`")
    @ApiModelProperty(value = "线路市区域")
    private Integer cityArea;

    /**
     * 具体线路区域范围
     */
    @Column(name = "`district_area`")
    @ApiModelProperty(value = "具体线路区域范围")
    private String districtArea;

    /**
     * 线路产生原因
     */
    @Column(name = "`occur_reason`")
    @ApiModelProperty(value = "线路产生原因")
    private String occurReason;

    @Column(name = "`deploy_num`")
    @ApiModelProperty("可以发布的线路数量")
    private Integer deployNum;


    @Column(name = "`group_deploy_num`")
    @ApiModelProperty("集团可上车数")
    private Integer groupDeployNum;

    @Column(name = "`deploy_num_change_reason`")
    @ApiModelProperty("可上车数变化原因")
    private Integer deployNumChangeReason;

    /**
     * 已发布标书数量
     */
    @Column(name = "`published_bids_num`")
    @ApiModelProperty(value = "已发布标书数量")
    private Byte publishedBidsNum;

    /**
     * 闲置线路数量
     */
    @Column(name = "`idle_num`")
    @ApiModelProperty(value = "闲置线路数量")
    private Byte idleNum;


    @Column(name = "`deadline_reason`")
    @ApiModelProperty("标书下线原因")
    private Integer deadlineReason;

    @Column(name = "`self_state`")
    @ApiModelProperty("线路生命周期状态：0:停用 1：启用；2：闲置")
    private Integer selfState;


    /**
     * 总配送时长
     */
    @Column(name = "`time_diff`")
    @ApiModelProperty(value = "总配送时长")
    private String timeDiff;

    /**
     * 收入结算方式：1:按趟结算 2:按提薪提成制结算
     */
    @Column(name = "income_settlement_method")
    @ApiModelProperty(value = "收入结算方式：1:按趟结算 2:按提薪提成制结算")
    private Integer incomeSettlementMethod;

    /**
     * 预估月油耗(元)
     */
    @Column(name = "monthly_fuel_consumption")
    @ApiModelProperty(value = "预估月油耗(元)")
    private BigDecimal monthlyFuelConsumption;

    /**
     * 线路区、县区域
     */
    @Column(name = "county_area")
    @ApiModelProperty(value = "线路区、县区域")
    private Integer countyArea;

    /**
     * 等待上车有效期(天)
     */
    @Column(name = "wait_dirve_validity")
    @ApiModelProperty(value = "等待上车有效期")
    private Date waitDirveValidity;

    /**
     * 装卸难度
     */
    @Column(name = "handling_difficulty_degree")
    @ApiModelProperty(value = "装卸难度")
    private Integer handlingDifficultyDegree;

    /**
     * 线路评级
     */
    @Column(name = "line_rank")
    @ApiModelProperty(value = "线路评级")
    private String lineRank;

    /**
     * 留存率
     */
    @Column(name = "retention_rate")
    @ApiModelProperty(value = "留存率")
    private Integer retentionRate;

    /**
     * 稳定性
     */
    @Column(name = "stability_rate")
    @ApiModelProperty(value = "稳定性")
    private Integer stabilityRate;

    /**
     * 线路类型
     */
    @Column(name = "distinguished_type")
    @ApiModelProperty("具备区分度的线路类型")
    private Integer distinguishedType;

    /**
     * 首岗是否有人跟车 1 是 2 否
     */
    @Column(name = "first_needed_follow")
    @ApiModelProperty("首岗是否有人跟车 1 是 2 否")
    private Integer firstNeededFollow;

    @Column(name = "`line_sale_id`")
    @ApiModelProperty(value = "线路销售id")
    private Long lineSaleId;

    /**
     * 新增线路类型(1:供给性线路  2：替换型线路)
     */
    @Column(name = "line_type")
    @ApiModelProperty("线路类型(供给型、替换型)")
    private Integer lineType;

    /**
     * 预计货主月报价(单位：元)
     */
    @Column(name = "shipper_offer")
    @ApiModelProperty(value = "预计货主月报价(单位：元)")
    private BigDecimal shipperOffer;

    /**
     * 每趟保底(单位：元)
     */
    @Column(name = "every_trip_guaranteed")
    @ApiModelProperty(value = "每趟保底(单位：元)")
    private BigDecimal everyTripGuaranteed;

    /**
     * 每趟提成(单位：元)
     */
    @Column(name = "every_unit_price")
    @ApiModelProperty(value = "每趟提成(单位：元)")
    private BigDecimal everyUnitPrice;

    /**
     * 配送时间(星期一至星期日)
     */
    @Column(name = "delivery_week_cycle")
    @ApiModelProperty(value = "配送时间(每周)")
    private String deliveryWeekCycle;

    /**
     * 总货物重量(1: 1T以下  2: 1-3T  3: 3-5T  4: 5T以上)
     */
    @Column(name = "goods_weight")
    @ApiModelProperty("总货物重量")
    private Integer goodsWeight;

    @Column(name = "`warehouse_town`")
    @ApiModelProperty(value = "仓库位置-乡镇")
    private String warehouseTown;

    @Column(name = "`disable_state`")
    @ApiModelProperty("线路停用状态：0:未停用 1：已停用")
    private Integer disableState;

    @Column(name = "`sold_state`")
    @ApiModelProperty("线路售罄状态：0:未售罄 1：已售罄")
    private Integer soldState;

    @Column(name = "`init_deploy_num`")
    @ApiModelProperty("初始发布的可上车数量")
    private Integer initDeployNum;
}