package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("司机详情-司机标签信息")

public class DriverLabelInfoVO implements Serializable {

    @ApiModelProperty(value = "自增id")
    private Long id;

    @ApiModelProperty(value = "司机id")
    private String driverId;

    @ApiModelProperty(value = "能否闯禁行")
    private Boolean canBreakingNodriving;

    @ApiModelProperty(value = "可闯禁行区域-省")
    private Integer breakingNodrivingProvince;
    private String breakingNodrivingProvinceName;

    @ApiModelProperty(value = "可闯禁行区域-市")
    private Integer breakingNodrivingCity;
    private String breakingNodrivingCityName;

    @ApiModelProperty(value = "可闯禁行区域-县")
    private List<Integer> breakingNodrivingCounty;
    private List<String> breakingNodrivingCountyName;

    @ApiModelProperty(value = "能否闯限行")
    private Boolean canBreakingTrafficRestriction;

    @ApiModelProperty(value = "可闯限行区域-省")
    private Integer breakingTrafficRestrictionProvince;
    private String breakingTrafficRestrictionProvinceName;

    @ApiModelProperty(value = "可闯限行区域-市")
    private Integer breakingTrafficRestrictionCity;
    private String breakingTrafficRestrictionCityName;

    @ApiModelProperty(value = "可闯限行区域-县")
    private List<Integer> breakingTrafficRestrictionCounty;
    private List<String> breakingTrafficRestrictionCountyName;

    @ApiModelProperty(value = "否为租赁全藏")
    private Boolean isRentalHide;

    @ApiModelProperty(value = "装卸接受度")
    private Integer heavyLifting;
    private String heavyLiftingName;

    @ApiModelProperty(value = "配送复杂度")
    private List<Integer> deliveryDifficulty;
    private List<String> deliveryDifficultyName;

    @ApiModelProperty(value = "期望账期")
    private Integer expectAccountingPeriod;
    private String expectAccountingPeriodName;

    @ApiModelProperty(value = "期望运费（趟）")
    private Integer expectIncomeTrip;

    @ApiModelProperty(value = "期望稳定/临时")
    private List<Integer> expectStabilityTemporary;
    private List<String> expectStabilityTemporaryName;

    @ApiModelProperty(value = "外面是否有活")
    private Boolean hasIncomeOutside;

    @ApiModelProperty(value = "起始点-前端")
    private List<List<Integer>> startPointFront;

    @ApiModelProperty(value = "起始点-后台")
    private List<List<Integer>> startPointBack;

    @ApiModelProperty(value = "起始点开始时间")
    private String startPointStartTime;

    @ApiModelProperty(value = "配送点-前端")
    private List<List<Integer>> deliveryPointFront;

    @ApiModelProperty(value = "配送点-后台")
    private List<List<Integer>> deliveryPointBack;

    @ApiModelProperty(value = "配送点结束时间")
    private String  deliveryPointEndTime;

    @ApiModelProperty(value = "司机情况")
    private Integer driverSituation;
    private String driverSituationName;

    @ApiModelProperty(value = "备注")
    private Integer remarks;
    private String remarksName;

    @ApiModelProperty(value = "手动备注")
    private String manuallyRemarks;

}
