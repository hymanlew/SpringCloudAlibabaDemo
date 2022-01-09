package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:
 * @create: 2019-09-03
 * @description: 司机收入业务流水信息DTO
 **/
@Data
public class DriverIncomeBusinessFlowDTO implements Serializable {
    private static final long serialVersionUID = 1577352628768207420L;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 第三方司机id
     */
    @ApiModelProperty(value = "第三方司机id")
    private String thirdDriverId;

    /**
     * 业务流水详情列表里面的流水编号
     */
    @ApiModelProperty(value = "业务流水详情列表里面的流水编号")
    private Integer businessLogId;

    /**
     * 业务流水详情列表里面的变动金额[money为正表示增加字段，为负表示减少]
     */
    @ApiModelProperty(value = "业务流水详情列表里面的变动金额[money为正表示增加字段，为负表示减少]")
    private Integer money;

    /**
     * 业务流水详情列表里面的余额
     */
    @ApiModelProperty(value = "业务流水详情列表里面的余额")
    private Integer balance;

    /**
     * 业务流水详情列表里面的变动类型-编码
     */
    @ApiModelProperty(value = "业务流水详情列表里面的变动类型-编码")
    private Integer sourceType;

    /**
     * 业务流水详情列表里面的变动类型
     */
    @ApiModelProperty(value = "业务流水详情列表里面的变动类型")
    private String sourceTypeDisplay;

    /**
     * 业务流水详情列表里面的业务发生相关时间
     */
    @ApiModelProperty(value = "业务流水详情列表里面的业务发生相关时间")
    private Date createdAt;

    /**
     * 业务流水详情列表里面的记录业务流水时间
     */
    @ApiModelProperty(value = "业务流水详情列表里面的记录业务流水时间")
    private Date logCts;

    /**
     * 业务流水详情列表里面的流水状态-编码
     */
    @ApiModelProperty(value = "业务流水详情列表里面的流水状态-编码")
    private Integer status;

    /**
     * 业务流水详情列表里面的流水状态
     */
    @ApiModelProperty(value = "业务流水详情列表里面的流水状态")
    private String statusDisplay;

    /**
     * 业务流水详情列表里面的结算状态
     */
    @ApiModelProperty(value = "业务流水详情列表里面的结算状态")
    private String isInWalletDisplay;

    /**
     * 业务流水详情列表里面的结算时间
     */
    @ApiModelProperty(value = "业务流水详情列表里面的结算时间")
    private String inWalletDtDisplay;
}
