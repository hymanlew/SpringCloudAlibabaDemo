package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yantao
 * @Date 2021/4/21 11:24
 * @Describe
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverInnerBatchDTO implements Serializable {

    private static final long serialVersionUID = 7539085568560197108L;

    @NotNull(message = "司机id不能为空")
    @ApiModelProperty(value = "司机ids")
    private List<String> driverIds;

    @Nullable
    @ApiModelProperty(value = "最近出车时间")
    private Date latestDrivingDate;

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

}
