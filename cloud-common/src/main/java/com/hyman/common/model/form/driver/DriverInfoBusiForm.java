package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yantao
 * @Param
 * @Return
 * @Date 2020/7/9 13:54
 * @Describe ©
 */
@Data
@ApiModel("司机信息form")
public class DriverInfoBusiForm implements Serializable {

    private static final long serialVersionUID = -3032807131162135821L;

    @NotBlank(message = "司机编号不能为空")
    @ApiModelProperty(value="司机id")
    private String driverId;

    @ApiModelProperty(value="线索id")
    private String clueId;

    @ApiModelProperty(value="司机类型（0专车 1共享）")
    private Integer busiType;

    @ApiModelProperty(value="姓名")
    @NotBlank(message = "司机姓名不能为空")
    @Length(min = 0, max = 32, message = "司机名称长度必须介于 0 和 32 之间")
    private String name;

    @ApiModelProperty(value="手机号")
    @NotNull(message = "司机电话不能为空")
    @Length(min = 0, max = 11, message = "司机电话长度必须介于 0 和 11 之间")
    private Long phone;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="工作城市")
    @NotNull(message = "工作城市不能为空")
    @Range(min = 0, max = 999999, message = "工作城市在[0,999999]之间")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @ApiModelProperty(value="更新人")
    private Long updateId;

    @ApiModelProperty(value="更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

}
