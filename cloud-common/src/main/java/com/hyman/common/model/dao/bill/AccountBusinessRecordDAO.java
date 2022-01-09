package com.hyman.common.model.dao.bill;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "acct_business_record")
public class AccountBusinessRecordDAO {
    /**
     * 自增ID
     */
    @Id
    private Long id;

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
     * 费项-科目
     */
    private Integer subject;

    /**
     * 业务单号
     */
    @Column(name = "business_no")
    private String businessNo;

    /**
     * 描述
     */
    private String description;

    /**
     * 支付方式(1账户 2微信支付 3云鸟钱包 4支付宝 5银联支付 9梧桐平台)
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 支付编号
     */
    @Column(name = "pay_no")
    private String payNo;

    /**
     * 记账金额
     */
    private BigDecimal amount;

    /**
     * 原始金额
     */
    @Column(name = "original_amount")
    private BigDecimal originalAmount;

    /**
     * 流向类型(1账户 2微信 3云鸟钱包 4支付宝 5银联 9梧桐平台)
     */
    @Column(name = "flow_type")
    private Integer flowType;

    /**
     * 流向编号
     */
    @Column(name = "flow_no")
    private String flowNo;

    /**
     * 手续费
     */
    @Column(name = "service_fee")
    private BigDecimal serviceFee;

    /**
     * 该笔收入是否在冻结状态
     */
    @Column(name = "is_can_use")
    private Integer isCanUse;

    /**
     * 状态(1进行中 2成功 3失败)
     */
    private Integer status;
    
    /**
     * 创建标识 1 手动 2自动
     */
    @Column(name = "create_flag")
    private Integer createFlag;

    /**
     * 账单日
     */
    @Column(name = "bill_day")
    private Date billDay;

    /**
     * 备注
     */
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
    
    /**
     * 业务发生时间
     */
    @Column(name = "happened_date")
    private Date happenedDate;
    
    /**
     * 进账发生时间
     */
    @Column(name = "income_date")
    private Date incomeDate;

    /**
     * 凭证上传地址
     */
    @Column(name = "proof_url")
    private String proofUrl;

    /**
     * 凭证类型：0图片，1文件，2音频
     */
    @Column(name = "proof_type")
    private Integer proofType;

    /**
     * 凭证文件名
     */
    @Column(name = "proof_name")
    private String proofName;

}