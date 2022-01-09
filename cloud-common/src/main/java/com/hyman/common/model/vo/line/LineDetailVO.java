package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Changyuan Su
 * @date 2019/3/5 15:03
 * @Description:
 */
@Data
public class LineDetailVO {

    /**
     * 线路id
     */
    @ApiModelProperty(value = "线路id")
    private String lineId;

    /**
     * 线路名称标识
     */
    @ApiModelProperty(value = "线路名称标识")
    private String lineLogo;

    /**
     * 线路名称
     */
    @ApiModelProperty(value = "线路名称")
    private String lineName;

    /**
     * 项目编号
     */
    @ApiModelProperty(value = "项目编号")
    private String projectId;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /**
     * 项目仓城市
     */
    @ApiModelProperty(value = "项目仓城市")
    private Integer warehouseCity;

    /**
     * 仓名称
     */
    @ApiModelProperty(value = "仓名称")
    private String warehouseName;

    /**
     * 城市（已开通业务的）
     */
    @ApiModelProperty(value = "城市（已开通业务的）")
    private Integer city;

    /**
     * 线路分类1:稳定线路  2：临时线路
     */
    @ApiModelProperty(value = "线路分类1:稳定线路  2：临时线路")
    private Integer lineCategory;

    /**
     * 线路分类名称
     */
    @ApiModelProperty(value = "线路分类名称")
    private String lineCategoryName;

    /**
     * 线路类型（0:专车 1：共享 9：专车/共享）
     */
    @ApiModelProperty(value = "线路类型（0:专车 1：共享 9：专车/共享）")
    private Integer busiType;

    @ApiModelProperty(value = "线路角色名称")
    private String busiTypeName;

    /**
     * 线路标签类型(1:超肥 2:单肥 3:次肥 4:中瘦 5:极瘦)
     */
    @ApiModelProperty(value = "线路标签类型")
    private Integer labelType;

    /**
     * 线路标签类型名称
     */
    @ApiModelProperty(value = "线路标签类型名称")
    private String labelTypeName;

    /**
     * 是否为城配线（1：城市线  2：跨城支线）
     */
    @ApiModelProperty(value = "是否为城配线（1：城市线  2：跨城支线）")
    private Integer lineType;

    /**
     * 是否为城配线（1：城市线  2：跨城支线）
     */
    @ApiModelProperty(value = "是否为城配线（1：城市线  2：跨城支线）")
    private String lineTypeName;

    /**
     * 是否有线路余额（1：有余额 2：无余额）
     */
    @ApiModelProperty(value = "是否有线路余额（1：有余额 2：无余额）")
    private Integer lineBalance;

    /**
     * 是否有线路余额名称（1：有余额 2：无余额）
     */
    @ApiModelProperty(value = "是否有线路余额名称（1：有余额 2：无余额）")
    private String lineBalanceName;

    /**
     * 线路状态
     */
    @ApiModelProperty(value = "线路状态")
    private Integer lineState;

    /**
     * 线路状态名称
     */
    @ApiModelProperty(value = "线路状态名称")
    private String lineStateName;

    /**
     * 试跑状态
     */
    @ApiModelProperty(value = "试跑状态")
    private Integer runTestState;

    /**
     * 试跑状态名称
     */
    @ApiModelProperty(value = "试跑状态名称")
    private String runTestStateName;

    /**
     * 上架截止日期
     */
    @ApiModelProperty(value = "上架截止日期")
    private Date waitDirveValidity;

    /**
     * 线路稳定性
     */
    @ApiModelProperty(value = "线路稳定性")
    private Integer stabilityRate;

    @ApiModelProperty(value = "稳定性")
    private String stabilityRateName;

    /**
     * 是否走高速（1：是 2：否）
     */
    @ApiModelProperty(value = "是否走高速（1：是 2：否）")
    private Integer runSpeed;

    /**
     * 是否回单(1:是 2:否)
     */
    @ApiModelProperty(value = "是否回单(1:是 2:否)")
    private Integer returnBill;

    /**
     * 配送车型
     */
    @ApiModelProperty(value = "配送车型")
    private Integer carType;

    /**
     * 选择车型
     */
    @ApiModelProperty(value = "选择车型名")
    private String carTypeName;

    /**
     * 配送区域-省
     */
    @ApiModelProperty(value = "配送区域-省")
    private Integer provinceArea;

    /**
     * 配送区域-市
     */
    @ApiModelProperty(value = "配送区域-市")
    private Integer cityArea;

    /**
     * 配送区域-区、县
     */
    @ApiModelProperty(value = "配送区域-区、县")
    private Integer countyArea;

    /**
     * 配送省区域名称
     */
    @ApiModelProperty(value = "配送省区域名称")
    private String provinceAreaName;

    /**
     * 配送市区域名称
     */
    @ApiModelProperty(value = "配送市区域名称")
    private String cityAreaName;

    /**
     * 配送区、县区域名称
     */
    @ApiModelProperty(value = "配送区、县区域名称")
    private String countyAreaName;

    @ApiModelProperty(value = "具体配送区域范围")
    private String districtArea;

    @ApiModelProperty(value = "线路主要配送区域")
    private String lineArea;

    /**
     * 配送点数量
     */
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
    @ApiModelProperty(value = "限行区域说明")
    private String limitRemark;

    /**
     * 稳定线路时的配送时间(周一至周日对应数字拼接)
     */
    @ApiModelProperty(value = "稳定线路时的配送时间(周一至周日对应数字拼接)")
    private String deliveryWeekCycle;

    /**
     * 配送开始日期
     */
    @ApiModelProperty(value = "配送开始日期")
    private Date deliveryStartDate;

    /**
     * 配送结束日期
     */
    @ApiModelProperty(value = "配送结束日期")
    private Date deliveryEndDate;

    /**
     * 总配送时长
     */
    @ApiModelProperty(value = "总配送时长")
    private String timeDiff;

    /**
     * 预计月出车天数
     */
    @ApiModelProperty(value = "预计月出车天数")
    private Integer monthNum;

    /**
     * 每日配送趟数
     */
    @ApiModelProperty(value = "每日配送趟数")
    private Integer dayNum;

    /**
     * 计价方式：1:按趟计费 2:保底+提成
     */
    @ApiModelProperty(value = "计价方式：1:按趟计费 2:保底+提成")
    private Integer incomeSettlementMethod;

    @ApiModelProperty(value = "计价方式：1:按趟计费 2:保底+提成")
    private String incomeSettlementMethodName;

    /**
     * 结算周期（1：现结 2：周结 3：半月结 4：月结 5：季度结）
     */
    @ApiModelProperty(value = "结算周期（1：现结 2：周结 3：半月结 4：月结 5：季度结）")
    private Integer settlementCycle;

    @ApiModelProperty(value = "结算周期（1：现结 2：周结 3：半月结 4：月结 5：季度结）")
    private String settlementCycleName;

    /**
     * 结算天数（1-120整数）
     */
    @ApiModelProperty(value = "结算天数（1-120整数）")
    private Integer settlementDays;

    /**
     * 每趟保底、货主单趟报价(元)
     */
    @ApiModelProperty(value = "每趟保底、货主单趟报价(元)")
    private BigDecimal everyTripGuaranteed;

    /**
     * 每趟提成(元)
     */
    @ApiModelProperty(value = "每趟提成(元)")
    private BigDecimal everyUnitPrice;

    /**
     * 预计货主月报价(元)
     */
    @ApiModelProperty(value = "预计货主月报价(元)")
    private BigDecimal shipperOffer;

    /**
     * 货物类型
     */
    @ApiModelProperty(value = "货物类型")
    private Integer cargoType;

    /**
     * 货物类型名称
     */
    @ApiModelProperty(value = "货物类型名称")
    private String cargoTypeName;

    /**
     * 货物件数
     */
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
    @ApiModelProperty(value = "其他上岗要求")
    private String dutyRemark;

    /**
     * 线路紧急程度
     */
    @ApiModelProperty(value = "线路紧急程度")
    private Integer lineUrgent;

    /**
     * 线路紧急程度名称
     */
    @ApiModelProperty(value = "线路紧急程度名称")
    private String lineUrgentName;

    /**
     * 线路适配性
     */
    @ApiModelProperty(value = "线路适配性")
    private Integer lineAdapter;

    /**
     * 线路适配性名称
     */
    @ApiModelProperty(value = "线路适配性名称")
    private String lineAdapterName;


    /**
     * 线路是否采线（1：是 2：否）
     */
    @ApiModelProperty(value = "线路是否采线（1：是 2：否）")
    private Integer inLine;

    /**
     * 外线销售id
     */
    @ApiModelProperty(value = "外线销售id")
    private Integer lineSaleId;

    /**
     * 线路销售姓名
     */
    @ApiModelProperty("线路销售姓名")
    private String lineSaleName;

    /**
     * 线路销售手机号
     */
    @ApiModelProperty("线路销售手机号")
    private String lineSalePhone;

    /**
     * 上岗经理id
     */
    @ApiModelProperty(value = "上岗经理id")
    private Integer dutyManagerId;

    /**
     * 上岗经理姓名
     */
    @ApiModelProperty("上岗经理姓名")
    private String dutyManagerIdName;

    /**
     * 上岗经理手机号
     */
    @ApiModelProperty("上岗经理手机号")
    private String dutyManagerPhone;

    @ApiModelProperty("配送时间")
    List<LineDeliveryDetailInfoVO> lineDeliveryInfoFORMS;

    @ApiModelProperty("线路采线详情")
    LinePictureRelatedVO LinePictureRelatedVO;

    @ApiModelProperty("项目策展信息")
    ProjectStrategyInfoVO projectStrategyInfoVO;

    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    protected Long createId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    protected Date createDate;

    /**
     * 最后一次修改人员
     */
    @ApiModelProperty(value = "最后一次修改人员")
    protected Long updateId;

    /**
     * 最后一次修改时间
     */
    @ApiModelProperty(value = "最后一次修改时间")
    protected Date updateDate;

    /**
     * 是否爆款
     */
    @ApiModelProperty(value = "是否爆款：0：否，1：是")
    private Integer isHot;

    /**
     * 是否爆款名称
     */
    @ApiModelProperty(value = "是否爆款名称")
    private String isHotName;

    /**
     * 卖点
     */
    @ApiModelProperty(value = "卖点")
    private String sellPoint;

    @ApiModelProperty(value = "仓的详细地址")
    private String warehouseDistrict;

    /**
     * 仓库位置-省--项目带
     */
    @ApiModelProperty(value = "仓库位置-省")
    private Integer warehouseProvince;


    /**
     * 仓库位置-区--项目带
     */
    @ApiModelProperty(value = "仓库位置-区、县")
    private Integer warehouseCounty;


    /**
     * 仓库省区域名称
     */
    @ApiModelProperty(value = "仓库省区域名称")
    private String warehouseProvinceName;

    /**
     * 仓库市区域名称
     */
    @ApiModelProperty(value = "仓库市区域名称")
    private String warehouseCityName;

    /**
     * 仓库区、县区域名称
     */
    @ApiModelProperty(value = "仓库区、县区域名称")
    private String warehouseCountyName;

    @ApiModelProperty(value = "招车窗口期")
    private Integer recruitWindowPeriod;

    @ApiModelProperty(value = "是否走禁行")
    private Integer isBehavior;

    @ApiModelProperty(value = "是否走限行")
    private Integer isRestriction;

    @ApiModelProperty(value = "油电要求")
    private Integer oilElectricityRequirement;

    @ApiModelProperty(value = "油电要求中文")
    private String oilElectricityRequirementName;

    @ApiModelProperty(value = "配送方式")
    private Integer distributionWay;

    @ApiModelProperty(value = "是否需要返仓（1是 2否）")
    private Integer returnWarehouse;

    @ApiModelProperty(value = "是否需要返仓中文")
    private String returnWarehouseName;

    @ApiModelProperty(value = "装卸要求")
    private Integer handlingDifficulty;

    @ApiModelProperty(value = "装卸要求中文")
    private String handlingDifficultyName;

    @ApiModelProperty(value = "服务要求")
    private String serviceRequirement;

    @ApiModelProperty(value = "服务要求中文")
    private String serviceRequirementName;

    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 是否检查通过
     */
    @ApiModelProperty(value = "是否检查通过")
    private Integer checkState;
    /**
     * 是否万金油
     */
    @ApiModelProperty(value = "是否万金油")
    private Integer isPanacea;

    @ApiModelProperty(value = "线路掉线原因")
    private Integer droppedReason;

}
