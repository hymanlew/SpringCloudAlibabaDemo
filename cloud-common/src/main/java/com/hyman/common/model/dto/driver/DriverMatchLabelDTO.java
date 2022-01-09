package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yantao
 * @Date 2021/4/29 17:13
 * @Describe
 */
@ApiModel("司撮-司机标签")
@Data
public class DriverMatchLabelDTO implements Serializable {

    private static final long serialVersionUID = -957097879027888899L;

    @ApiModelProperty("司机id")
    private String driverId;

    @ApiModelProperty("物理标签")
    private PhysicalLabelDTO physicalLabelDTO;

    @ApiModelProperty("动态标签")
    private DynamicLabelDTO dynamicLabelDTO;

    @ApiModelProperty("司机行数据改变的类型: 新增 删除 或更改")
    private Integer driverRowChangedType;

    @Data
    public static class PhysicalLabelDTO implements Serializable {

        private static final long serialVersionUID = 6982137708521924097L;

        @ApiModelProperty("静态标签")
        private PscLabel pscLabel;

    }

    @Data
    public static class DynamicLabelDTO implements Serializable {

        private static final long serialVersionUID = -2776957365033276221L;

        @ApiModelProperty("成交日期标签")
        private DealDateLabel dealDateLabel;

        @ApiModelProperty("当月新成交标签")
        private DealOfCurrentMonthLabel dealOfCurrentMonthLabel;
    }

    @Data
    public static class DealDateLabel implements Serializable {

        private static final long serialVersionUID = -1190464730590538877L;

        @ApiModelProperty("成交状态")
        private Integer dealDateStatus;

        @ApiModelProperty("成交时间")
        private Long dealTime;
    }

    @Data
    public static class DealOfCurrentMonthLabel implements Serializable {


        private static final long serialVersionUID = 766437405993558720L;

        @ApiModelProperty("成交状态")
        private Integer dealDateStatus;

        @ApiModelProperty("成交时间")
        private Long dealTime;
    }

    @Data
    public static class PscLabel implements Serializable {

        private static final long serialVersionUID = -1190464730590538877L;

        @ApiModelProperty(value = "业务线")
        private Integer busiType;

        @ApiModelProperty(value = "当前车型")
        private Integer currentCarType;

        @ApiModelProperty(value = "是否新能源(p)")
        private Boolean isNewEnergy;

        /*@ApiModelProperty(value = "能否闯禁行")
        private Boolean canBreakingNodriving;

        @ApiModelProperty(value = "能否闯限行")
        private Boolean canBreakingTrafficRestriction;*/

        @ApiModelProperty(value = "居住地址-省(s/p)")
        private Integer liveProvince;

        @ApiModelProperty(value = "居住地址-市(s/p)")
        private Integer liveCity;

        @ApiModelProperty(value = "居住地址-区县(s/p)")
        private Integer liveCounty;

        @ApiModelProperty(value = "居住地址-具体区域(s/p)")
        private String liveDistrict;

        @ApiModelProperty(value = "期望收入(含油)(元/月)")
        private Double expIncomeConOil;

        @ApiModelProperty(value = "期望收入(趟)")
        private Double expIncomeTrip;

        @ApiModelProperty(value = "意向货物类型(s/p)")
        private String intentCargoType;

        @ApiModelProperty(value = "装卸接受度")
        private Integer heavyLiftingType;

        @ApiModelProperty(value = "是否为小白司机")
        private Boolean isNovice;

        @ApiModelProperty(value = "司撮id")
        private Long dmId;

        @ApiModelProperty(value = "加盟id")
        private Long gmId;

        @ApiModelProperty(value = "状态")
        private Integer status;

        @ApiModelProperty(value = "姓名")
        private String name;

        @ApiModelProperty(value = "手机号")
        private String phone;

        @ApiModelProperty(value = "年龄")
        private Integer age;

        @ApiModelProperty(value = "驾照类型(s/p)")
        private Integer drivingLicenceType;

        @ApiModelProperty(value = "货物运输经验（月）(s/p)")
        private Integer experience;

        @ApiModelProperty(value = "邀约渠道(s/p)")
        private Integer sourceChannel;

        @ApiModelProperty(value = "城市(s/p)")
        private Integer workCity;

        //dict_type : is_urgent
        @ApiModelProperty(value = "司机情况")
        private Integer isUrgent;

    }
}
