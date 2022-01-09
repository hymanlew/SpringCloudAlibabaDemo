package com.hyman.common.model.dao.driver;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com.hyman.common.model.dao.driver.DriverIncomeBusinessFlowDAO")
@Data
@Table(name = "driver_income_business_flow")
public class DriverIncomeBusinessFlowDAO extends BaseDAO implements Serializable {

    private static final long serialVersionUID = 7279027016400888999L;


    /**
     * 司机编号
     */
    @Column(name = "driver_id")
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 第三方司机id
     */
    @Column(name = "third_driver_id")
    @ApiModelProperty(value = "第三方司机id")
    private String thirdDriverId;

    /**
     * 业务流水详情列表里面的流水编号
     */
    @Column(name = "business_log_id")
    @ApiModelProperty(value = "业务流水详情列表里面的流水编号")
    private Integer businessLogId;

    /**
     * 业务流水详情列表里面的变动金额[money为正表示增加字段，为负表示减少]
     */
    @Column(name = "money")
    @ApiModelProperty(value = "业务流水详情列表里面的变动金额[money为正表示增加字段，为负表示减少]")
    private Integer money;

    /**
     * 业务流水详情列表里面的余额
     */
    @Column(name = "balance")
    @ApiModelProperty(value = "业务流水详情列表里面的余额")
    private Integer balance;

    /**
     * 业务流水详情列表里面的变动类型-编码
     */
    @Column(name = "source_type")
    @ApiModelProperty(value = "业务流水详情列表里面的变动类型-编码")
    private Integer sourceType;

    /**
     * 业务流水详情列表里面的变动类型
     */
    @Column(name = "source_type_display")
    @ApiModelProperty(value = "业务流水详情列表里面的变动类型")
    private String sourceTypeDisplay;

    /**
     * 业务流水详情列表里面的业务发生相关时间
     */
    @Column(name = "created_at")
    @ApiModelProperty(value = "业务流水详情列表里面的业务发生相关时间")
    private Date createdAt;

    /**
     * 业务流水详情列表里面的记录业务流水时间
     */
    @Column(name = "log_cts")
    @ApiModelProperty(value = "业务流水详情列表里面的记录业务流水时间")
    private Date logCts;

    /**
     * 业务流水详情列表里面的流水状态-编码
     */
    @Column(name = "`status`")
    @ApiModelProperty(value = "业务流水详情列表里面的流水状态-编码")
    private Integer status;

    /**
     * 业务流水详情列表里面的流水状态
     */
    @Column(name = "status_display")
    @ApiModelProperty(value = "业务流水详情列表里面的流水状态")
    private String statusDisplay;

    /**
     * 业务流水详情列表里面的结算状态
     */
    @Column(name = "is_in_wallet_display")
    @ApiModelProperty(value = "业务流水详情列表里面的结算状态")
    private String isInWalletDisplay;

    /**
     * 业务流水详情列表里面的结算时间
     */
    @Column(name = "in_wallet_dt_display")
    @ApiModelProperty(value = "业务流水详情列表里面的结算时间")
    private String inWalletDtDisplay;
}