package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yantao
 * @Param
 * @Return
 * @Date 2020/7/9 10:59
 * @Describe © 详情实体
 */
@Data
@ApiModel("司机详情查询")
public class DriverInfoBusiVO implements Serializable {

    private static final long serialVersionUID = -279252429632381115L;

    /**
     * 司机id
     */
    @ApiModelProperty(value="司机id")
    private String driverId;

    /**
     * 线索id
     */
    @ApiModelProperty(value="线索id")
    private String clueId;

    /**
     * 司机类型（0专车 1共享）
     */
    @ApiModelProperty(value="司机类型（0专车 1共享）")
    private Integer busiType;

    private String busiTypeName;

    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private Long phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
     * 工作城市
     */
    @ApiModelProperty(value="工作城市")
    private Integer workCity;

    private String workCityName;

    /**
     * 车型
     */
    @ApiModelProperty(value="车型")
    private Integer carType;

    private String carTypeName;

    /**
     * 来源渠道
     */
    @ApiModelProperty(value="来源渠道")
    private Integer sourceChannel;

    private String sourceChannelName;

    /**
     * 身份证号
     */
    @ApiModelProperty(value="身份证号")
    private String idNo;

    /**
     * 银行卡号
     */
    @ApiModelProperty(value="银行卡号")
    private String bankCardNo;

    /**
     * 加盟经理id
     */
    @ApiModelProperty(value="加盟经理id")
    private Long gmId;

    private String gmName;

    private String gmPhone;

    /**
     * 状态
     */
    @ApiModelProperty(value="状态")
    private Integer status;

    private String statusName;

    /**
     * 企业微信-外部联系人id
     */
    @ApiModelProperty(value="企业微信-外部联系人id")
    private String exterUserId;

    /**
     * 企业微信-企业成员id
     */
    @ApiModelProperty(value="企业微信-企业成员id")
    private String corpUserId;

    /**
     * 删除标记
     */
    @ApiModelProperty(value="删除标记")
    private Boolean delFlag;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private Long createId;

    private String createName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createDate;

    /**
     * 更新人
     */
    @ApiModelProperty(value="更新人")
    private Long updateId;

    private String updateName;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Date updateDate;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 居住地址-省
     */
    @ApiModelProperty(value = "居住地址-省")
    private Integer liveProvince;

    /**
     * 居住地址-市
     */
    @ApiModelProperty(value = "居住地址-市")
    private Integer liveCity;

    /**
     * 居住地址-区县
     */
    @ApiModelProperty(value = "居住地址-区县")
    private Integer liveCounty;

    /**
     * 居住地址-具体区域
     */
    @ApiModelProperty(value = "居住地址-具体区域")
    private String liveDistrict;

    /**
     *  地址(省+市+区+县+具体区域)
     */
    @ApiModelProperty(value="地址")
    private String address;

    @ApiModelProperty(value="加盟小组code")
    private Integer gmTeamId;

    @ApiModelProperty(value="加盟小组")
    private String gmTeam;

}
