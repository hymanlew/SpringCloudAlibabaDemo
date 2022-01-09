package com.hyman.common.model.dao.bill;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "acct_financial_flow_info")
public class AccountFinancialFlowInfoDAO {
    @Id
    private Long id;

    /**
     * 财务流水申请唯一id
     */
    @Column(name = "flow_apply_id")
    private String flowApplyId;

    /**
     * 司机id
     */
    @Column(name = "driver_id")
    private String driverId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * sop计费id
     */
    @Column(name = "charge_id")
    private String chargeId;

    /**
     * 申请调整金额
     */
    private BigDecimal money;

    /**
     * 原因
     */
    private String reason;

    /**
     * 创建人id
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取财务流水申请唯一id
     *
     * @return flow_apply_id - 财务流水申请唯一id
     */
    public String getFlowApplyId() {
        return flowApplyId;
    }

    /**
     * 设置财务流水申请唯一id
     *
     * @param flowApplyId 财务流水申请唯一id
     */
    public void setFlowApplyId(String flowApplyId) {
        this.flowApplyId = flowApplyId == null ? null : flowApplyId.trim();
    }

    /**
     * 获取司机id
     *
     * @return driver_id - 司机id
     */
    public String getDriverId() {
        return driverId;
    }

    /**
     * 设置司机id
     *
     * @param driverId 司机id
     */
    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取sop计费id
     *
     * @return charge_id - sop计费id
     */
    public String getChargeId() {
        return chargeId;
    }

    /**
     * 设置sop计费id
     *
     * @param chargeId sop计费id
     */
    public void setChargeId(String chargeId) {
        this.chargeId = chargeId == null ? null : chargeId.trim();
    }

    /**
     * 获取申请调整金额
     *
     * @return money - 申请调整金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置申请调整金额
     *
     * @param money 申请调整金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取原因
     *
     * @return reason - 原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置原因
     *
     * @param reason 原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 获取创建人id
     *
     * @return create_id - 创建人id
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置创建人id
     *
     * @param createId 创建人id
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}