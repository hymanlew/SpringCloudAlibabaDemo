package com.hyman.common.model.vo.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author hucl
 * @date 2020/11/25 9:21
 */
@Getter
@Setter
@ApiModel("梧桐账户详情VO")
public class AcctInfoVO {

    @ApiModelProperty(value = "司机编号")
    private String driverId;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "可提现余额")
    private BigDecimal canExtract;

    @ApiModelProperty(value = "提现中金额")
    private BigDecimal extracting;

    @ApiModelProperty(value = "账本状态")
    private Integer bookStatus;

    @ApiModelProperty(value = "账本状态名")
    private String bookStatusName;
}
