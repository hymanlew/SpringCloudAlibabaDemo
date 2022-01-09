package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yantao
 * @Param
 * @Return
 * @Date 2020/7/9 10:43
 * @Describe © 内部调用实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("内部调用更新司机信息")
public class DriverInfoBusiDTO implements Serializable {

    private static final long serialVersionUID = -9018171389306118286L;

    @ApiModelProperty(value="司机id")
    private String driverId;

    @ApiModelProperty(value="线索id")
    private String clueId;

    @ApiModelProperty(value="司机类型（0专车 1共享）")
    private Integer busiType;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="手机号")
    private Long phone;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="工作城市")
    private Integer workCity;

    @ApiModelProperty(value="车型")
    private Integer carType;

    @ApiModelProperty(value="来源渠道")
    private Integer sourceChannel;

    @ApiModelProperty(value="身份证号")
    private String idNo;

    @ApiModelProperty(value="银行卡号")
    private String bankCardNo;

    @ApiModelProperty(value="加盟经理id")
    private Long gmId;

    @ApiModelProperty(value="状态")
    private Integer status;

    @ApiModelProperty(value="企业微信-外部联系人id")
    private String exterUserId;

    @ApiModelProperty(value="企业微信-企业成员id")
    private String corpUserId;

    @ApiModelProperty(value="删除标记")
    private Boolean delFlag;

    @ApiModelProperty(value="创建人")
    private Long createId;

    @ApiModelProperty(value="创建时间")
    private Date createDate;

    @ApiModelProperty(value="更新人")
    private Long updateId;

    @ApiModelProperty(value="更新时间")
    private Date updateDate;
}
