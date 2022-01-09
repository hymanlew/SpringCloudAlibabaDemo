package com.hyman.common.model.dao.waybill.billing;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 司机账本表
 *
 * @author wanghaitong
 * @date 2020-09-29 09:58:37
 */
@Data
@Table(name = "driver_acct_book")
public class DriverAcctBookDAO implements Serializable {

    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 账本编号
     */
    @Column(name = "acct_book_no")
    private String acctBookNo;

    /**
     * 账户编号
     */
    @Column(name = "acct_no")
    private String acctNo;

    /**
     * 账本类型
     */
    @Column(name = "book_type")
    private Integer bookType;

    /**
     * 用户编号（司机编号）
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 账户余额（运费总额）
     */
    @Column(name = "balance")
    private BigDecimal balance;

    /**
     * 已收款金额
     */
    @Column(name = "receive_payment")
    private BigDecimal receivePayment;

    /**
     * 出车单数
     */
    @Column(name = "way_bill_count")
    private Integer wayBillCount;

    /**
     * 出车趟数
     */
    @Column(name = "way_bill_trip_count")
    private Integer wayBillTripCount;

    /**
     * 流水数量
     */
    @Column(name = "record_count")
    private Integer recordCount;

    /**
     * 生效时间
     */
    @Column(name = "effect_date")
    private Date effectDate;

    /**
     * 失效时间
     */
    @Column(name = "expire_date")
    private Date expireDate;

    /**
     * 账本状态(1待激活 2正常 3冻结)
     */
    @Column(name = "book_status")
    private Integer bookStatus;

    /**
     * 加盟经理id
     */
    @Column(name = "gm_id")
    private Integer gmId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

}