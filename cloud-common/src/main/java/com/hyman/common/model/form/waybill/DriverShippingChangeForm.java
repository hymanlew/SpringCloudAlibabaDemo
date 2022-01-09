package com.hyman.common.model.form.waybill;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 运费变更记录
 *
 * @author wanghaitong
 * @date 2020-09-29 09:58:37
 */
@Data
public class DriverShippingChangeForm implements Serializable {

    @NotEmpty(message = "司机id不能为空")
    @ApiModelProperty(value = "司机id")
    private String driverId;

    @NotEmpty(message = "调整原因不能为空")
    @ApiModelProperty(value = "调整原因")
    private Integer subject;

    @NotEmpty(message = "变更金额不能为空")
    @ApiModelProperty(value = "变更金额")
    private BigDecimal amount;

    @NotEmpty(message = "订单编号不能为空")
    @ApiModelProperty(value = "订单编号")
    private String orderId;

    //@NotEmpty(message = "文件url不能为空")
    @ApiModelProperty(value = "文件url不能为空")
    private String fileUrl;

    @ApiModelProperty(value = "项目id")
    private String projectId;

    @ApiModelProperty(value = "线路id")
    private String lineId;

    @ApiModelProperty(value = "出车日期")
    private Date departureDate;

    @ApiModelProperty(value = "运单编号")
    private String waybillId;

    @ApiModelProperty(value = "备注")
    private String remark = "";

    @ApiModelProperty(value = "操作人ID")
    private Long userId;

}