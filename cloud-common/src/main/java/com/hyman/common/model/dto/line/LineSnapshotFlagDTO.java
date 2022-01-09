package com.hyman.common.model.dto.line;

import com.hyman.common.model.vo.line.LineDeliveryDetailInfoVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName LineSnapshotFlagDTO
 * @Description 此类用于生成线路快照标识，对比待办标识(临时线路)
 * @Author shiyunlong
 * @Date 2021/3/24 10:44
 */
@Data
public class LineSnapshotFlagDTO {

    /**
     * 是否有线路余额（1：有余额 2：无余额）
     */
    @ApiModelProperty(value = "是否有线路余额（1：有余额 2：无余额）")
    private Integer lineBalance;

    /**
     * 招车窗口期
     */
    @ApiModelProperty(value = "招车窗口期")
    private Integer recruitWindowPeriod;


    /**
     * 是否走禁行
     */
    @ApiModelProperty(value = "是否走禁行")
    private Integer isBehavior;

    /**
     * 是否走限行
     */
    @ApiModelProperty(value = "是否走限行")
    private Integer isRestriction;

    /**
     * 油电要求
     */
    @ApiModelProperty(value = "油电要求")
    private Integer oilElectricityRequirement;

    /**
     * 配送方式
     */
    @ApiModelProperty(value = "配送方式")
    private Integer distributionWay;

    /**
     * 是否需要返仓（1是 2否）
     */
    @ApiModelProperty(value = "是否需要返仓（1是 2否）")
    private Integer returnWarehouse;

    /**
     * 装卸要求
     */
    @ApiModelProperty(value = "装卸要求")
    private Integer handlingDifficulty;


    /**
     * 配送车型
     */
    @ApiModelProperty(value = "配送车型")
    private Integer carType;


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
     * 配送区域-详细地址
     */
    @ApiModelProperty(value = "配送区域-详细地址")
    private String districtArea;

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
     * 服务要求
     */
    @ApiModelProperty(value = "服务要求")
    private String serviceRequirement;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;


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

    /**
     * 结算周期（1：现结 2：周结 3：半月结 4：月结 5：季度结）
     */
    @ApiModelProperty(value = "结算周期（1：现结 2：周结 3：半月结 4：月结 5：季度结）")
    private Integer settlementCycle;

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
     * 是否需要搬运（1是 2否）
     */
    @ApiModelProperty(value = "是否需要搬运（1是 2否）")
    private Integer carry;


    /**
     * 线路标签类型(1:超肥 2:单肥 3:次肥 4:中瘦 5:极瘦)
     */
    @ApiModelProperty(value = "线路标签类型(1:超肥 2:单肥 3:次肥 4:中瘦 5:极瘦)")
    private Integer labelType;


    /**
     * 是否是爆款
     */
    @ApiModelProperty(value = "是否是爆款")
    private Integer isHot;

    @ApiModelProperty("配送时间")
    List<LineDeliveryDetailInfoVO> lineDeliveryInfoFORMS;
}
