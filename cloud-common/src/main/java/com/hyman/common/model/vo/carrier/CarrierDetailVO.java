package com.hyman.common.model.vo.carrier;

import com.hyman.common.model.vo.order.OrderInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lishuai
 */
@Data
@ApiModel("运力详情VO")
public class CarrierDetailVO implements Serializable {


    private static final long serialVersionUID = -5255382157333550441L;
    /**
     * 订单信息
     */
    private OrderInfoVO orderInfoVO;

    // 标书信息
    // TODO

    /**
     * 运力基本信息
     */
    @ApiModelProperty(value = "运力编号")
    private String carrierId;

    @ApiModelProperty(value = "所属司机id")
    private String driverId;

    @ApiModelProperty(value = "所属司机名")
    private String driverName;

    @ApiModelProperty(value = "所属司机手机号")
    private Long driverPhone;

    @ApiModelProperty(value = "创建运力时选择的订单的业务类型")
    private Integer busiType;


    @ApiModelProperty(value = "创建运力时选择的订单的业务类型（中文）")
    private String busiTypeName;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private Long phone;

    @ApiModelProperty(value = "工作城市")
    private Integer workCity;

    @ApiModelProperty(value = "工作城市（中文）")
    private String workCityName;

    @ApiModelProperty(value = "车型")
    private Integer carType;

    @ApiModelProperty(value = "车型（中文）")
    private String carTypeName;

    @ApiModelProperty(value = "车牌号")
    private String plateNo;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "家庭住址-省")
    private Integer homeProvince;


    @ApiModelProperty(value = "家庭住址-市")
    private Integer homeCity;


    @ApiModelProperty(value = "家庭住址-区县")
    private Integer homeCounty;

    @ApiModelProperty(value = "家庭住址")
    private String addr;

    @ApiModelProperty(value = "家庭住址-具体区域")
    private String homeDistrict;

    @ApiModelProperty(value = "货物运输经验（月）")
    private Integer transportExp;

    @ApiModelProperty(value = "货物运输经验（中文）（月）")
    private String transportExpName;

    @ApiModelProperty(value = "期望运输货物类型")
    private Integer cargoType;

    @ApiModelProperty(value = "期望运输货物类型（中文）")
    private String cargoTypeName;

    @ApiModelProperty(value = "工作经验")
    private Integer workExperience;

    @ApiModelProperty(value = "工作经验(中文)")
    private String workExperienceName;

    @ApiModelProperty(value = "期望月收入")
    private Integer expMonthlyIncome;

    @ApiModelProperty(value = "期望月收入(中文)")
    private String expMonthlyIncomeName;

    @ApiModelProperty(value = "平均月收入")
    private Integer avgMonthlyIncome;

    @ApiModelProperty(value = "平均月收入(中文)")
    private String avgMonthlyIncomeName;

    @ApiModelProperty(value = "户口性质（ 1农村 2城镇）")
    private Integer householdType;

    @ApiModelProperty(value = "户口性质（中文）（ 1农村 2城镇）")
    private String householdTypeName;

    @ApiModelProperty(value = "是否存在贷款 1：是 2：否")
    private Integer isIndebted;

    @ApiModelProperty(value = "是否存在贷款（中文） 1：是 2：否")
    private String isIndebtedName;

    @ApiModelProperty(value = "可接受一天工作时长")
    private Integer maxWorkTime;

    @ApiModelProperty(value = "可接受一天工作时长（中文）")
    private String maxWorkTimeName;

    @ApiModelProperty(value = "运营经理id")
    private Long gmId;

    @ApiModelProperty(value = "运营经理姓名")
    private String gmName;
    @ApiModelProperty(value = "运营经理手机号")
    private String gmPhone;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "状态（中文）")
    private String statusName;

    @ApiModelProperty(value = "删除标记")
    private Boolean delFlag;

    @ApiModelProperty(value = "创建人id")
    private Long createId;

    @ApiModelProperty(value = "创建人")
    private String createName;

    @ApiModelProperty(value = "创建人手机号")
    private String createPhone;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "更新人id")
    private Long updateId;

    @ApiModelProperty(value = "更新人")
    private String updateName;

    @ApiModelProperty(value = "修改日期")
    private Date updateDate;

}
