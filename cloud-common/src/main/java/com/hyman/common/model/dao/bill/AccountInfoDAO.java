package com.hyman.common.model.dao.bill;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "acct_info")
public class AccountInfoDAO {

    /**
     * 自增ID
     */
    @Id
    private Long id;

    /**
     * 账户编号
     */
    @Column(name = "acct_no")
    private String acctNo;

    /**
     * 账户类型
     */
    @Column(name = "acct_type")
    private Integer acctType;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private String userId;

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
     * 支付密码
     */
    @Column(name = "pay_password")
    private String payPassword;

    /**
     * 账户状态(1待激活 2正常 3冻结)
     */
    @Column(name = "acct_status")
    private Integer acctStatus;

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