package com.hyman.common.model.dto.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 运费抽佣DTO
 *
 * @author hucl
 * @date 2020/10/12 9:14
 */
@Getter
@Setter
@ApiModel
public class WayBillCommissionDTO implements Serializable {

    private static final long serialVersionUID = -8386709163547356497L;

    /**
     * 运费流水id
     */
    @ApiModelProperty(value = "运费流水id")
    @NotBlank(message = "运费流水id不能为空")
    private String wayBillRecordId;

    /**
     * 运费金额
     */
    @ApiModelProperty(value = "运费金额")
    @NotNull(message = "运费金额不能为空")
    private BigDecimal wayBillMoney;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    @NotBlank(message = "司机编号不能为空")
    private String driverId;

    /**
     * 运费产生时间
     */
    @ApiModelProperty(value = "运费产生时间")
    @NotNull(message = "运费产生时间不能为空")
    private Date happenedDate;

    /**
     * 费用科目
     */
    @NotNull(message = "费用科目不能为空")
    @ApiModelProperty(value = "费用科目")
    private Integer subject;

    /**
     * 订单编号
     */
    @NotBlank(message = "订单编号不能为空")
    @ApiModelProperty(value = "订单编号")
    private String orderId;


}
