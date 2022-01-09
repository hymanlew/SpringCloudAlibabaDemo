package com.hyman.common.model.dao.bill;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "acct_book")
@Getter
@Setter
public class AccountBookDAO {
    /**
     * 自增ID
     */
    @Id
    private Long id;

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
     * 用户编号
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 账户余额
     */
    private BigDecimal balance;

    /**
     * 冻结中金额
     */
    private BigDecimal freezing;

    /**
     * 可提现金额
     */
    @Column(name = "can_extract")
    private BigDecimal canExtract;

    /**
     * 提现中金额
     */
    private BigDecimal extracting;

    /**
     * 累计已提现金额
     */
    @Column(name = "total_extract")
    private BigDecimal totalExtract;

    /**
     * 累计已扣除金额
     */
    @Column(name = "total_deduct")
    private BigDecimal totalDeduct;

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