package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Changyuan Su
 * @date 2020/3/4 上午10:58
 * @Description:
 */
@ApiModel("标书生成司机运单实体")
@Data
public class GenerateDispatchDeliveryRecordDTO implements Serializable {

    private static final long serialVersionUID = -1515365806005734118L;


    /**
     * 运单编号,对应于标书标号
     */
    @NotBlank
    @ApiModelProperty(value = "运单编号")
    private String dispatchId;

    /**
     * 预估运费(单位：元) ，对应于标书的日价格，即线路日价格
     */
    @NotNull
    @DecimalMin("0")
    @ApiModelProperty(value = "预估运费(单位：元)")
    private BigDecimal predictCost;

    /**
     * 司机编号
     */
    @NotBlank
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    @ApiModelProperty(value = "业务类型")
    private Integer busiType;

}
