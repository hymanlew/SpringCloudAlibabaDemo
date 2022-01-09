package com.hyman.common.model.dao.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @Author zhanglichao
 * @Date 2021-03-07 13:35
 * @description 线路实体对应公共DAO
 */
@Data
public class LineInfoCommonDAO {

    /**
     * 自增ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "自增ID")
    protected Long id;

    /**
     * 线路编号
     */
    @Column(name = "line_id")
    @ApiModelProperty(value = "线路编号")
    private String lineId;

    /**
     * 线路名称标识
     */
    @Column(name = "line_logo")
    @ApiModelProperty(value = "线路名称标识")
    private String lineLogo;

    /**
     * 线路名称
     */
    @Column(name = "line_name")
    @ApiModelProperty(value = "线路名称")
    private String lineName;

    /**
     * 项目编号
     */
    @Column(name = "project_id")
    @ApiModelProperty(value = "项目编号")
    private String projectId;

    /**
     * 城市（已开通业务的）
     */
    @Column(name = "city")
    @ApiModelProperty(value = "城市（已开通业务的）")
    private Integer city;

    /**
     * 线路分类1:稳定线路  2：临时线路
     */
    @Column(name = "line_category")
    @ApiModelProperty(value = "线路分类1:稳定线路  2：临时线路")
    private Integer lineCategory;

    /**
     * 线路评分
     */
    @Column(name = "line_rank")
    @ApiModelProperty(value = "线路评分")
    private Integer lineRank;

    /**
     * 线路类型（0:专车 1：共享 9：专车/共享）
     */
    @Column(name = "busi_type")
    @ApiModelProperty(value = "线路类型（0:专车 1：共享 9：专车/共享）")
    private Integer busiType;

    /**
     * 线路标签类型(1:超肥 2:单肥 3:次肥 4:中瘦 5:极瘦)
     */
    @Column(name = "label_type")
    @ApiModelProperty(value = "线路标签类型(1:超肥 2:单肥 3:次肥 4:中瘦 5:极瘦)")
    private Integer labelType;

    /**
     * 是否为城配线（1：城市线  2：跨城支线）
     */
    @Column(name = "line_type")
    @ApiModelProperty(value = "是否为城配线（1：城市线  2：跨城支线）")
    private Integer lineType;

    /**
     * 是否有线路余额（1：有余额 2：无余额）
     */
    @Column(name = "line_balance")
    @ApiModelProperty(value = "是否有线路余额（1：有余额 2：无余额）")
    private Integer lineBalance;

    /**
     * 线路状态
     */
    @Column(name = "line_state")
    @ApiModelProperty(value = "线路状态")
    private Integer lineState;

    /**
     * 试跑状态
     */
    @Column(name = "run_test_state")
    @ApiModelProperty(value = "试跑状态")
    private Integer runTestState;

    /**
     * 上架截止日期
     */
    @Column(name = "wait_dirve_validity")
    @ApiModelProperty(value = "上架截止日期")
    private Date waitDirveValidity;

    /**
     * 线路稳定性
     */
    @Column(name = "stability_rate")
    @ApiModelProperty(value = "线路稳定性")
    private Integer stabilityRate;

    /**
     * 是否走高速（1：是 2：否）
     */
    @Column(name = "run_speed")
    @ApiModelProperty(value = "是否走高速（1：是 2：否）")
    private Integer runSpeed;

    /**
     * 是否回单(1:是 2:否)
     */
    @Column(name = "return_bill")
    @ApiModelProperty(value = "是否回单(1:是 2:否)")
    private Integer returnBill;

    /**
     * 配送车型
     */
    @Column(name = "car_type")
    @ApiModelProperty(value = "配送车型")
    private Integer carType;

    /**
     * 配送区域-省
     */
    @Column(name = "province_area")
    @ApiModelProperty(value = "配送区域-省")
    private Integer provinceArea;

    /**
     * 配送区域-市
     */
    @Column(name = "city_area")
    @ApiModelProperty(value = "配送区域-市")
    private Integer cityArea;

    /**
     * 配送区域-区、县
     */
    @Column(name = "county_area")
    @ApiModelProperty(value = "配送区域-区、县")
    private Integer countyArea;

    /**
     * 配送区域-详细地址
     */
    @Column(name = "district_area")
    @ApiModelProperty(value = "配送区域-详细地址")
    private String districtArea;

    /**
     * 配送点数量
     */
    @Column(name = "delivery_num")
    @ApiModelProperty(value = "配送点数量")
    private Integer deliveryNum;

    /**
     * 配送总里程
     */
    @ApiModelProperty(value = "配送总里程")
    private Integer distance;

    /**
     * 限行区域说明
     */
    @Column(name = "limit_remark")
    @ApiModelProperty(value = "限行区域说明")
    private String limitRemark;

    /**
     * 司机上岗时间
     */
    @Column(name = "driver_work_time")
    @ApiModelProperty(value = "司机上岗时间")
    private Date driverWorkTime;

    /**
     * 稳定线路时的配送时间(周一至周日对应数字拼接)
     */
    @Column(name = "delivery_week_cycle")
    @ApiModelProperty(value = "稳定线路时的配送时间(周一至周日对应数字拼接)")
    private String deliveryWeekCycle;

    /**
     * 配送开始日期
     */
    @Column(name = "delivery_start_date")
    @ApiModelProperty(value = "配送开始日期")
    private Date deliveryStartDate;

    /**
     * 配送结束日期
     */
    @Column(name = "delivery_end_date")
    @ApiModelProperty(value = "配送结束日期")
    private Date deliveryEndDate;

    /**
     * 总配送时长
     */
    @Column(name = "time_diff")
    @ApiModelProperty(value = "总配送时长")
    private String timeDiff;

    /**
     * 预计月出车天数
     */
    @Column(name = "month_num")
    @ApiModelProperty(value = "预计月出车天数")
    private Integer monthNum;

    /**
     * 每日配送趟数
     */
    @Column(name = "day_num")
    @ApiModelProperty(value = "每日配送趟数")
    private Integer dayNum;

    /**
     * 计价方式：1:按趟计费 2:保底+提成
     */
    @Column(name = "income_settlement_method")
    @ApiModelProperty(value = "计价方式：1:按趟计费 2:保底+提成")
    private Integer incomeSettlementMethod;

    /**
     * 结算周期（1：现结 2：周结 3：半月结 4：月结 5：季度结）
     */
    @Column(name = "settlement_cycle")
    @ApiModelProperty(value = "结算周期（1：现结 2：周结 3：半月结 4：月结 5：季度结）")
    private Integer settlementCycle;

    /**
     * 结算天数（1-120整数）
     */
    @Column(name = "settlement_days")
    @ApiModelProperty(value = "结算天数（1-120整数）")
    private Integer settlementDays;

    /**
     * 每趟保底、货主单趟报价(元)
     */
    @Column(name = "every_trip_guaranteed")
    @ApiModelProperty(value = "每趟保底、货主单趟报价(元)")
    private BigDecimal everyTripGuaranteed;

    /**
     * 每趟提成(元)
     */
    @Column(name = "every_unit_price")
    @ApiModelProperty(value = "每趟提成(元)")
    private BigDecimal everyUnitPrice;

    /**
     * 预计货主月报价(元)
     */
    @Column(name = "shipper_offer")
    @ApiModelProperty(value = "预计货主月报价(元)")
    private BigDecimal shipperOffer;

    /**
     * 货物类型
     */
    @Column(name = "cargo_type")
    @ApiModelProperty(value = "货物类型")
    private Integer cargoType;

    /**
     * 货物件数
     */
    @Column(name = "cargo_num")
    @ApiModelProperty(value = "货物件数")
    private Integer cargoNum;

    /**
     * 货物体积
     */
    @ApiModelProperty(value = "货物体积")
    private Double volume;

    /**
     * 货物重量
     */
    @Column(name = "goods_weight")
    @ApiModelProperty(value = "货物重量")
    private Double goodsWeight;

    /**
     * 是否需要搬运（1是 2否）
     */
    @ApiModelProperty(value = "是否需要搬运（1是 2否）")
    private Integer carry;

    /**
     * 其他上岗要求
     */
    @Column(name = "duty_remark")
    @ApiModelProperty(value = "其他上岗要求")
    private String dutyRemark;

    /**
     * 线路紧急程度
     */
    @Column(name = "line_urgent")
    @ApiModelProperty(value = "线路紧急程度")
    private Integer lineUrgent;

    /**
     * 线路适配性
     */
    @Column(name = "line_adapter")
    @ApiModelProperty(value = "线路适配性")
    private Integer lineAdapter;

    /**
     * 线路是否采线（1：是 2：否）
     */
    @Column(name = "in_line")
    @ApiModelProperty(value = "线路是否采线（1：是 2：否）")
    private Integer inLine;

    /**
     * 外线销售id
     */
    @Column(name = "line_sale_id")
    @ApiModelProperty(value = "外线销售id")
    private Integer lineSaleId;

    /**
     * 上岗经理id
     */
    @Column(name = "duty_manager_id")
    @ApiModelProperty(value = "上岗经理id")
    private Integer dutyManagerId;

    /**
     * 是否是爆款
     */
    @Column(name = "is_hot")
    @ApiModelProperty(value = "是否是爆款")
    private Integer isHot;

    /**
     * 卖点
     */
    @Column(name = "sell_point")
    @ApiModelProperty(value = "卖点")
    private String sellPoint;

    /**
     * 创建者id
     */
    @Column(name = "create_id")
    @ApiModelProperty(value = "创建者id")
    private Long createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 更新者id
     */
    @Column(name = "update_id")
    @ApiModelProperty(value = "更新人id")
    private Long updateId;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    @ApiModelProperty(value = "最后更新时间")
    private Date updateDate;

    /**
     * 招车窗口期
     */
    @Column(name = "recruit_window_period")
    @ApiModelProperty(value = "招车窗口期")
    private Integer recruitWindowPeriod;

    /**
     * 是否走禁行
     */
    @Column(name = "is_behavior")
    @ApiModelProperty(value = "是否走禁行")
    private Integer isBehavior;

    /**
     * 是否走限行
     */
    @Column(name = "is_restriction")
    @ApiModelProperty(value = "是否走限行")
    private Integer isRestriction;

    /**
     * 油电要求
     */
    @Column(name = "oil_electricity_requirement")
    @ApiModelProperty(value = "油电要求")
    private Integer oilElectricityRequirement;

    /**
     * 配送方式
     */
    @Column(name = "distribution_way")
    @ApiModelProperty(value = "配送方式")
    private Integer distributionWay;

    /**
     * 是否需要返仓（1是 2否）
     */
    @Column(name = "return_warehouse")
    @ApiModelProperty(value = "是否需要返仓（1是 2否）")
    private Integer returnWarehouse;

    /**
     * 装卸要求
     */
    @Column(name = "handling_difficulty")
    @ApiModelProperty(value = "装卸要求")
    private Integer handlingDifficulty;

    /**
     * 服务要求
     */
    @Column(name = "service_requirement")
    @ApiModelProperty(value = "服务要求")
    private String serviceRequirement;

    /**
     * 备注
     */
    @Column(name = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 是否检查通过
     */
    @Column(name = "check_state")
    @ApiModelProperty(value = "是否检查通过")
    private Integer checkState;
    /**
     * 是否万金油
     */
    @Column(name = "is_panacea")
    @ApiModelProperty(value = "是否万金油")
    private Integer isPanacea;
}