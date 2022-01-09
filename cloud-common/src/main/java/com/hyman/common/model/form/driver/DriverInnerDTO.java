package com.hyman.common.model.form.driver;

import com.hyman.common.annotation.IdentityCard;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yantao
 * @Date 2020/8/31 11:18
 * @Describe
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverInnerDTO implements Serializable {

    private static final long serialVersionUID = 3883318206504036789L;

    @NotBlank(message = "司机编号不能为空")
    @ApiModelProperty(value = "司机id")
    private String driverId;

    /*DriverBusiStatesEnum {
                INTERVIEWED(1, "已面试"),
                TODEAL(2, "待成交"),
                COMPLETED(3, "已成交"),
                ONDUTY(4,"已上岗"),
                EXITED(5,"已终止服务"),
                             }*/
    @Nullable
    @ApiModelProperty(value = "状态")
    private Integer status;

    /*DriverBusiSubStatusEnum {
        INTERVIEWED(10, "已面试"),
                TOBEREVIEWED(20, "待审核"),
                REJECTED(30, "已驳回"),
                WAITINGRUN(40, "待试跑"),
                COMPLETEDRUN(50, "已试跑"),
                REFUNDPROGRESS(60, "退费中"),
                REFUNDED(70, "已退费"),
                ORDERERROR(80, "订单录错"),*/
    @Nullable
    @ApiModelProperty(value = "子状态")
    private Integer subStatus;

    @Email(message = "请输入正确邮箱")
    @Nullable
    @ApiModelProperty(value = "邮箱")
    private String email;

    @Nullable
    @ApiModelProperty(value = "车型")
    private Integer carType;

    @IdentityCard
    @Nullable
    @ApiModelProperty(value = "身份证号")
    private String idNo;

    @Nullable
    @ApiModelProperty(value = "银行卡号")
    private String bankCardNo;

    @Nullable
    @ApiModelProperty(value = "加盟经理id")
    private Long gmId;

    @ApiModelProperty(value = "司撮经理id")
    private Long dmId;

    private Boolean hasCar;

    @Nullable
    @ApiModelProperty(value = "订单支付时间")
    private Date orderLatestPayMent;

    @Nullable
    @ApiModelProperty(value = "最近出车时间")
    private Date latestDrivingDate;

    @Nullable
    @ApiModelProperty(value = "车牌号")
    private String plateNo;



}
