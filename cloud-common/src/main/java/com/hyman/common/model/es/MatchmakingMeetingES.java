package com.hyman.common.model.es;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @author
 * @date 2020-04-10
 **/
@ApiModel("促撮推荐")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchmakingMeetingES implements Serializable {

    private static final long serialVersionUID = 6400724670366831410L;

    @ApiModelProperty(value = "自增ID")
    protected Long id;

    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    protected long createId;

    @ApiModelProperty("城市")
    private Integer city;

    @ApiModelProperty("城市")
    private String cityName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    protected Date createDate;

    @ApiModelProperty(value = "司机id")
    private String driverId;

    @ApiModelProperty(value = "线路id")
    private String lineId;

    @ApiModelProperty("业务类型")
    private Integer busiType;

    @ApiModelProperty(value = "货主名称")
    private String customerName;

    @ApiModelProperty("线路名")
    private String lineName;

    @ApiModelProperty("线路销售")
    private String lineSaleName;

    @ApiModelProperty(value = "线路省区域")
    private Integer provinceArea;

    @ApiModelProperty(value = "线路省区域名称")
    private String provinceAreaName;

    @ApiModelProperty(value = "线路市区域")
    private Integer cityArea;

    @ApiModelProperty(value = "线路市区域名称")
    private String cityAreaName;

    @ApiModelProperty(value = "线路区、县区域")
    private Integer countyArea;

    @ApiModelProperty(value = "线路区、县区域名称")
    private String countyAreaName;

    @ApiModelProperty(value = "具体线路区域范围")
    private String districtArea;

    @ApiModelProperty(value = "车型")
    private Integer carType;

    @ApiModelProperty(value = "车型名称")
    private String carTypeName;

    @ApiModelProperty(value = "货物类型")
    private String cargoType;

    @ApiModelProperty(value = "装卸难度")
    private Integer handlingDifficultyDegree;

//    @JsonIgnore
//    @Deprecated
//    @ApiModelProperty("仓位置")
//    private String warehouse;

    @ApiModelProperty(value = "仓库位置-省")
    private Integer warehouseProvince;

    @ApiModelProperty(value = "仓库位置-市")
    private Integer warehouseCity;

    @ApiModelProperty(value = "仓库位置-区、县")
    private Integer warehouseCounty;

    @ApiModelProperty(value = "仓库位置-省")
    private String warehouseProvinceName;

    @ApiModelProperty(value = "仓库位置-市")
    private String warehouseCityName;

    @ApiModelProperty(value = "仓库位置-区、县")
    private String warehouseCountyName;

    @ApiModelProperty(value = "仓库位置-具体位置")
    private String warehouseDistrict;

    @ApiModelProperty("线路备注")
    private String remark;

    @ApiModelProperty(value = "匹配度")
    private double suitability;

    @ApiModelProperty("撮合状态")
    private int state = 0;

    @ApiModelProperty("司机车型")
    private DriverWorkIntentionItem driverCarType;

    @ApiModelProperty("货物类型")
    private Set<DriverWorkIntentionItem> cargoTypes;

    @ApiModelProperty("到仓区域")
    private Set<DriverWorkIntentionItem> warehouses;

    @ApiModelProperty("配送区域")
    private Set<DriverWorkIntentionItem> deliveryAreas;

    @ApiModelProperty("装卸难度")
    private Set<DriverWorkIntentionItem> handlingDifficultyDegrees;

    @ApiModelProperty("出车时段")
    private Set<DriverWorkIntentionItem> runningDurations;

    @ApiModelProperty("司机接活意向匹配情况实体")
    private DriverWorkIntentionMatchedInfo driverWorkIntentionMatchedInfo;

    @ApiModel("司机接活意向匹配情况实体")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DriverWorkIntentionMatchedInfo implements Serializable {
        private static final long serialVersionUID = -2462969157593785751L;

        @ApiModelProperty("意向-司机车型")
        private Set<DriverWorkIntentionItem> intentCarType;

        @ApiModelProperty("意向-货物类型")
        private Set<DriverWorkIntentionItem> intentCargoTypes;

        @ApiModelProperty("意向-到仓区域")
        private Set<DriverWorkIntentionItem> intentWarehouses;

        @ApiModelProperty("意向-配送区域")
        private Set<DriverWorkIntentionItem> intentDeliveryAreas;

        @ApiModelProperty("意向-装卸难度")
        private Set<DriverWorkIntentionItem> intentHandlingDifficultyDegrees;

        @ApiModelProperty("意向-出车时段")
        private Set<DriverWorkIntentionItem> intentRunningDurations;
    }

    @ApiModel("司机接活意向")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class DriverWorkIntentionItem {

        @ApiModelProperty("意向中文值")
        private String name;

        @Builder.Default
        @ApiModelProperty("是否匹配成功？true:成功 false: 不成功")
        private boolean matched = Boolean.FALSE;

        @Override
        public int hashCode() {
            if (StringUtils.isBlank(name)) return super.hashCode();
            return matched ? name.hashCode() : name.hashCode() << 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (this == obj)
                return true;
            if (obj instanceof DriverWorkIntentionItem) {
                DriverWorkIntentionItem vo = (DriverWorkIntentionItem) obj;

                // 比较每个属性的值 一致时才返回true
                if (vo.name.equals(this.name) && vo.matched == this.matched)
                    return true;
            }
            return false;
        }
    }

    @ApiModelProperty("跟进记录")
    private RecentlyFollowInfo followInfo;

    @ApiModelProperty("撮合发起人")
    private Long sponsor;

    @ApiModel("跟进记录")
    @Data
    public static class RecentlyFollowInfo {

        @JsonIgnore
        @ApiModelProperty("状态")
        private Integer state;

        @ApiModelProperty(value = "状态说明")
        private String stateName;

        @ApiModelProperty(value = "备注")
        private String remark;

        @ApiModelProperty(value = "时间")
        private Date createDate;

        @JsonIgnore
        private Long createId;

    }

    @ApiModelProperty("线路详情")
    private LineDetailInfo lineDetailInfo;

    @ApiModel("线路详情")
    @Data
    public static class LineDetailInfo {

        @ApiModelProperty(value = "收入结算方式：1:按趟结算 2:按提薪提成制结算")
        private Integer incomeSettlementMethod;

        @ApiModelProperty(value = "收入结算方式名称")
        private String incomeSettlementMethodName;

        @ApiModelProperty(value = "预计去油净收入")
        private BigDecimal preNetIncome;

        @ApiModelProperty("账期")
        private Integer billingCycle;

        @ApiModelProperty(value = "可发布线路数量")
        private Integer deployNum;

        @ApiModelProperty(value = "已发布标书数量")
        private Integer publishedBidsNum;

        @ApiModelProperty("线路销售id")
        private Long lineSaleId;

        @ApiModelProperty("线路销售")
        private String lineSaleName;

        @ApiModelProperty("每月出车天数")
        private Integer monthNum;

        /**
         * 一级分类
         */
        @ApiModelProperty(value = "一级分类")
        private Integer primaryClassification;

        /**
         * 一级分类
         */
        @ApiModelProperty(value = "一级分类")
        private String primaryClassificationName;

        public String getIncomeSettlementMethodName() {
            return 1 == incomeSettlementMethod ? "按趟结算" : (2 == incomeSettlementMethod ? "按提薪提成制结算" : StringUtils.EMPTY);
        }

        @ApiModelProperty("是否搬运（1是 2否）")
        private Integer carry;
    }

    @ApiModelProperty("司机详情")
    private DriverDetailInfo driverDetailInfo;

    @ApiModel("司机详情")
    @Data
    public static class DriverDetailInfo {

        @ApiModelProperty(value = "司机姓名")
        private String driverName;

        @ApiModelProperty(value = "司机电话")
        private String driverPhone;

        @ApiModelProperty(value = "司机类型")
        private Integer driverType;

        @ApiModelProperty(value = "司机状态")
        private Integer state;

        @ApiModelProperty(value = "司机类型")
        private String driverTypeName;

        @ApiModelProperty(value = "司机工作城市ID")
        private Integer city;

        @ApiModelProperty(value = "司机地址")
        private String driverAddress;

        @ApiModelProperty(value = "创建者ID")
        protected Long createId;

        @ApiModelProperty(value = "加盟经理ID")
        protected Long joinManagerId;

        @ApiModelProperty(value = "加盟经理")
        protected String joinManager;

        @ApiModelProperty(value = "意向车型")
        private Integer carType;

        @ApiModelProperty(value = "意向车型")
        private String carTypeName;
    }

}
