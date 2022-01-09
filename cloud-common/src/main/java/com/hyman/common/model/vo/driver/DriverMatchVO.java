package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yantao
 * @Date 2021/5/8 10:39
 * @Describe
 */
@Data
@ApiModel("司机撮合支持vo")
public class DriverMatchVO implements Serializable {

    private static final long serialVersionUID = -4636660400839305071L;

    @ApiModelProperty(value="车型")
    private Integer currentCarType;
    private String currentCarTypeName;

    @ApiModelProperty(value="车牌号")
    private String plateNo;

    @ApiModelProperty(value="驾照类型")
    private Integer drivingLicenceType;
    private String drivingLicenceTypeName;

    @ApiModelProperty(value="货物运输经验")
    private Integer experience;
    private String experienceName;

    @ApiModelProperty(value="来源渠道")
    private Integer sourceChannel;
    private String sourceChannelName;

    @ApiModelProperty(value="业务线")
    private Integer busiType;
    private String busiTypeName;

    @ApiModelProperty(value="居住地址-省")
    private Integer liveProvince;
    private String liveProvinceName;

    @ApiModelProperty(value="居住地址-市")
    private Integer liveCity;
    private String liveCityName;

    @ApiModelProperty(value="居住地址-区县")
    private Integer liveCounty;
    private String liveCountyName;

    @ApiModelProperty(value="居住地址-具体区域")
    private String liveDistrict;

    @ApiModelProperty(value="年龄")
    private Integer age;

    @ApiModelProperty(value="状态")
    private Integer status;
    private String statusName;

    @ApiModelProperty(value="订单编号")
    private String orderId;

    @ApiModelProperty(value="合同状态")
    private Integer contractStatus;
    private String contractStatusName;

    @ApiModelProperty(value="司撮id")
    private Integer dmId;

    @ApiModelProperty(value="司撮姓名")
    private String dmName;

    @ApiModelProperty(value="司撮手机号")
    private String dmPhone;

    @ApiModelProperty(value="司撮所在城市")
    private String dmCityName;

    //2021-6-10新增字段 司机姓名、司机手机号、司机编号、订单成交时间、加盟经理姓名/手机号、身份证号
    @ApiModelProperty(value="司机姓名")
    private String name;

    @ApiModelProperty(value="司机手机号")
    private String phone;

    @ApiModelProperty(value="司机编号")
    private String driverId;

    @ApiModelProperty(value="订单成交时间")
    private Date passTime;

    @ApiModelProperty(value="加盟经理姓名")
    private String gmName;

    @ApiModelProperty(value="加盟经理手机号")
    private String gmPhone;

    @ApiModelProperty(value="身份证号")
    private String idNo;

}
