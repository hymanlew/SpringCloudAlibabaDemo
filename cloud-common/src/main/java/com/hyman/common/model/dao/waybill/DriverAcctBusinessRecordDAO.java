package com.hyman.common.model.dao.waybill;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 司机账户流水记录表
 *
 * @author wanghaitong
 * @date 2020-09-29 09:58:37
 */
@Data
@Table(name = "driver_acct_business_record")
public class DriverAcctBusinessRecordDAO implements Serializable {

    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 运费调整id
     */
    @Column(name = "change_id")
    private String changeId;

    /**
     * 流水编号
     */
    @Column(name = "record_no")
    private String recordNo;

    /**
     * 账户编号
     */
    @Column(name = "acct_no")
    private String acctNo;

    /**
     * 账本编号
     */
    @Column(name = "acct_book_no")
    private String acctBookNo;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 费项-科目（如何发生的变更，交叉确认等）
     */
    @Column(name = "subject")
    private Integer subject;

    /**
     * 业务单号（运单号）
     */
    @Column(name = "business_no")
    private String businessNo;

    /**
     * 描述（如何触发的，或者其他）
     */
    @Column(name = "description")
    private String description;

    /**
     * 记账金额（正负钱数）
     */
    @Column(name = "amount")
    private BigDecimal amount;

    /**
     * 原始金额
     */
    @Column(name = "original_amount")
    private BigDecimal originalAmount;

    /**
     * 是否已收款
     */
    @Column(name = "payment_received_flag")
    private Integer paymentReceivedFlag;

    /**
     * 收款凭证文件路径
     */
    @Column(name = "payment_voucher_path")
    private String paymentVoucherPath;

    /**
     * 出车日期
     */
    @Column(name = "departure_date")
    private Date departureDate;

    /**
     * 状态(1进行中 2成功 3失败)
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 账单日
     */
    @Column(name = "bill_day")
    private Date billDay;

    /**
     * 收款备注
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