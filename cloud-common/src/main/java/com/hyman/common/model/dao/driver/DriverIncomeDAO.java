package com.hyman.common.model.dao.driver;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com.hyman.domain.driver.façade.DriverIncome")
@Data
@Table(name = "driver_income")
public class DriverIncomeDAO extends BaseDAO implements Serializable {

    /**
     * 司机编号
     */
    @Column(name = "driver_id")
    @ApiModelProperty(value="司机编号")
    private String driverId;

    /**
     * 第三方司机id
     */
    @Column(name = "third_driver_id")
    @ApiModelProperty(value="第三方司机id")
    private String thirdDriverId;

    /**
     * 第三方货主id
     */
    @Column(name = "goods_owner_id")
    @ApiModelProperty(value="第三方货主id")
    private String goodsOwnerId;

    /**
     * 云鸟 客户名称
     */
    @Column(name = "customer_name")
    @ApiModelProperty(value = "云鸟 客户名称")
    private String customerName;

    /**
     * 收入来源类型【1云鸟，2七只鸟】
     */
    @Column(name = "income_source")
    @ApiModelProperty(value="收入来源类型【1云鸟，2七只鸟】")
    private Byte incomeSource;

    /**
     * 司机总价格
     */
    @Column(name = "dprice_total")
    @ApiModelProperty(value="司机总价格")
    private Integer dpriceTotal;

    /**
     * 司机保障费总额
     */
    @Column(name = "driver_insurance_money")
    @ApiModelProperty(value="司机保障费总额")
    private Integer driverInsuranceMoney;

    /**
     * 变动金额-减少
     */
    @Column(name = "money_decrease")
    @ApiModelProperty(value="变动金额-减少")
    private Integer moneyDecrease;

    /**
     * 扣款项备注
     */
    @Column(name = "source_type")
    @ApiModelProperty(value="扣款项备注")
    private String sourceType;

    /**
     * 状态类型 1，出车记录 2 业务流水详情列表
     */
    @Column(name = "state_type")
    @ApiModelProperty(value="状态类型 1，出车记录 2 业务流水详情列表")
    private Integer stateType;

    /**
     * 收入时间
     */
    @Column(name = "income_date")
    @ApiModelProperty(value="收入时间")
    private Date incomeDate;

    private static final long serialVersionUID = 2191292396095732476L;
}