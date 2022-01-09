package com.hyman.common.model.dao.waybill;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 司机月度账单
 *
 * @author wanghaitong
 * @date 2020-09-29 09:58:37
 */
@Data
@Table(name = "driver_monthly_bill")
public class DriverMonthlyBillDAO implements Serializable {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 司机运费月账单ID
     */
    @Column(name = "month_bill_id")
    private String monthBillId;

    /**
     * 账本编号
     */
    @Column(name = "acct_book_no")
    private String acctBookNo;

    /**
     * 账单所属年月
     */
    @Column(name = "month_bill_date")
    private Date monthBillDate;

    /**
     * 司机id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 账单运费金额总数(元)
     */
    @Column(name = "amount")
    private BigDecimal amount;

    /**
     * 账单出车单总数
     */
    @Column(name = "waybill_total_count")
    private Integer waybillTotalCount;

    /**
     * 账单出车趟数总数
     */
    @Column(name = "departure_total_count")
    private Integer departureTotalCount;

    /**
     * 账单出车费用流水总数
     */
    @Column(name = "turnover_total_count")
    private Integer turnoverTotalCount;

    /**
     * 是否封账
     */
    @Column(name = "close_status")
    private Integer closeStatus;

    /**
     * 月账单封账时间
     */
    @Column(name = "close_date")
    private Date closeDate;

    /**
     * 对账状态
     */
    @Column(name = "check_status")
    private Integer checkStatus;

    /**
     * 对账凭证文件路径
     */
    @Column(name = "check_voucher_path")
    private String checkVoucherPath;

    /**
     * 对账备注
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 创建者id
     */
    @Column(name = "create_id")
    private Integer createId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者id
     */
    @Column(name = "update_id")
    private Integer updateId;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    public void update(Integer updateId) {
        this.updateId = updateId;
        this.updateDate = new Date();
    }
}