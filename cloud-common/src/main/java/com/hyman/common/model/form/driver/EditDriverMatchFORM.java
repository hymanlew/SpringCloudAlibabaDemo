package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author yantao
 * @Date 2021/6/10 14:20
 * @Describe
 */
@ApiModel("编辑司机面试FORM")
@Data
public class EditDriverMatchFORM implements Serializable {

    private static final long serialVersionUID = 7869909734864282369L;

    /**
     * 司机id
     * driverId不为空=> 修改面试
     */
    //@Pattern(regexp = "^SJ\\d{12,18}$", message = "司机编号格式有误")
    ///@Length(min = 14, max = 20, message = "司机编号有误")
    @NotBlank(message = "司机编号不能为空")
    @ApiModelProperty("司机编号")
    private String driverId;

    @ApiModelProperty(value = "原行业")
    private Integer beforeProfession;

    /**
     * 手机号
     */
    @NotNull(message = "手机号有误")
    @Pattern(regexp = "1[3456789]\\d{9}", message = "手机号格式有误")
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 年龄
     */
    @Range(min = 1, max = 100, message = "年龄有误")
    @NotNull(message = "年龄不能为空")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 意向驾驶车型
     */
    @Nullable
    @ApiModelProperty(value = "意向驾驶车型")
    private Integer intentDrivingCarType;

    //    @Min(value = 1, message = "当前车型有误")
//    @NotNull(message = "当前车型不能为空")
    @Nullable
    @ApiModelProperty(value = "当前车型")
    private Integer currentCarType;

    /**
     * 车牌号
     */
    @Nullable
    @ApiModelProperty(value = "车牌号")
    private String plateNo;

    /**
     * 是否新能源
     */
    //@NotNull(message = "是否新能源不能为空")
    @Nullable
    @ApiModelProperty(value = "是否新能源")
    private Boolean isNewEnergy;

    /**
     * 居住地址-省
     */

    @NotNull(message = "居住地址-省不能为空")
    @ApiModelProperty(value = "居住地址-省")
    private Integer liveProvince;

    /**
     * 居住地址-市
     */

    @NotNull(message = "居住地址-市不能为空")
    @ApiModelProperty(value = "居住地址-市")
    private Integer liveCity;

    /**
     * 居住地址-区县
     */

    @NotNull(message = "居住地址-区县不能为空")
    @ApiModelProperty(value = "居住地址-区县")
    private Integer liveCounty;

    @NotBlank(message = "期望货品类不能为空")
    @ApiModelProperty(value = "期望货品类")
    private String intentCargoType;

    /**
     * 意向工作区域-省
     */

    @NotNull(message = "意向工作区域-省不能为空")
    @ApiModelProperty(value = "意向工作区域-省")
    private Integer intentWorkProvince;

    /**
     * 意向工作区域-市
     */

    @NotNull(message = "意向工作区域-市不能为空")
    @ApiModelProperty(value = "意向工作区域-市")
    private Integer intentWorkCity;

    /**
     * 意向工作区域-区县
     */

    @NotNull(message = "意向工作区域-区县不能为空")
    @ApiModelProperty(value = "意向工作区域-区县")
    private Integer intentWorkCounty;

    /**
     * 期望收入(含油)(元/月)
     */
    @NotNull(message = "期望收入(含油)(元/月)不能为空")
    @ApiModelProperty(value = "期望收入(含油)(元/月)")
    private Double expIncomeConOil;

    /**
     * 期望收入(趟)
     */
    @NotNull(message = "期望收入(趟)不能为空")
    @ApiModelProperty(value = "期望收入(趟)")
    private Double expIncomeTrip;

    /**
     * 意向工作时间段
     */
    //@Range(min = 1, message = "意向工作时间段不正确")
    @NotNull(message = "意向工作时间段不能为空")
    @ApiModelProperty(value = "意向工作时间段")
    private String intentWorkDuration;

    /**
     * 装卸接受度
     */
    @NotNull(message = "装卸接受度不能为空")
    @ApiModelProperty(value = "装卸接受度")
    private Integer heavyLiftingType;

    /**
     * 驾照类型
     */

    //@NotNull(message = "驾照类型不能为空")
    @Nullable
    @ApiModelProperty(value = "驾照类型")
    private Integer drivingLicenceType;

    /**
     * 归属城市
     */
    @Min(value = 1L, message = "工作城市有误")
    @ApiModelProperty(value = "工作城市")
    private Integer workCity;

    @ApiModelProperty(value = "母渠道")
    private Long channelId;

    @ApiModelProperty(value = "子渠道")
    private Long subChannelId;

    @ApiModelProperty(value = "母人群")
    private Integer crowd;
}
