package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yantao
 * @Date 2020/8/28 15:18
 * @Describe 司机信息
 */
@Data
@ApiModel("司机信息vo")
public class DriverBusiInfoVO implements Serializable {


    private static final long serialVersionUID = -6653446799945995411L;
    @ApiModelProperty(value="司机编码")
    private String driverId;

    @ApiModelProperty(value="业务类型code")
    private Integer busiType;

    @ApiModelProperty(value="业务类型value")
    private String busiTypeName;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="手机号")
    private String phone;

    @ApiModelProperty(value="城市code")
    private Integer workCity;

    @ApiModelProperty(value="城市value")
    private String workCityName;

    @ApiModelProperty(value="车型code")
    private Integer carType;

    @ApiModelProperty(value="车型value")
    private String carTypeName;

    @ApiModelProperty(value="车牌号")
    private String carNo;

    @ApiModelProperty(value="状态code")
    private Integer status;

    @ApiModelProperty(value="状态value")
    private String statusName;

    @ApiModelProperty(value="加盟经理id")
    private Long gmId;

    @ApiModelProperty(value="加盟经理姓名")
    private String gmName;

    @ApiModelProperty(value="加盟经理手机号")
    private String gmPhone;

    @ApiModelProperty(value="来源code")
    private Integer sourceChannel;

    @ApiModelProperty(value="来源value")
    private String sourceChannelName;

    @ApiModelProperty(value="身份证号")
    private String idNo;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="银行卡号")
    private String bankCardNo;

    @ApiModelProperty(value="外部联系人id")
    private String exterUserId;

    @ApiModelProperty(value="企业成员id")
    private String corpUserId;

    @ApiModelProperty(value="创建人id")
    private Long createId;

    @ApiModelProperty(value="创建人姓名")
    private String createName;

    @ApiModelProperty(value="创建人手机号")
    private String createPhone;

    @ApiModelProperty(value="创建时间")
    private Date createDate;

    @ApiModelProperty(value="修改人")
    private Long updateId;

    @ApiModelProperty(value="修改人姓名")
    private String updateName;

    @ApiModelProperty(value="修改时间")
    private Date updateDate;

    @ApiModelProperty(value="居住地址")
    private String address;

    @ApiModelProperty(value="司撮经理ID")
    private Long dmId;

    @ApiModelProperty(value="司撮经理名称")
    private String dmName;

    @ApiModelProperty(value="司机是否租赁全藏")
    private Boolean isDriverRentalHide;
}
