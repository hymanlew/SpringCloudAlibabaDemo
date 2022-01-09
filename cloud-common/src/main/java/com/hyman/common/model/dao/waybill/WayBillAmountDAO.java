package com.hyman.common.model.dao.waybill;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "way_bill_amount")
public class WayBillAmountDAO implements Serializable {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 运单编号
     */
    @Column(name = "way_bill_id")
    private String wayBillId;

    /**
     * 运单金额id
     */
    @Column(name = "way_bill_amount_id")
    private String wayBillAmountId;

    /**
     * 第几趟
     */
    @Column(name = "trip_no")
    private Integer tripNo;

    /**
     * 加盟侧金额
     */
    @Column(name = "gm_fee")
    private BigDecimal gmFee;

    /**
     * 外线侧金额
     */
    @Column(name = "line_fee")
    private BigDecimal lineFee;

    /**
     * GMC确认金额
     */
    @Column(name = "gmc_fee")
    private BigDecimal gmcFee;

    /**
     * 二次确认金额
     */
    @Column(name = "again_confirm_fee")
    private BigDecimal againConfirmFee;

    /**
     * 最终金额
     */
    @Column(name = "confirm_fee")
    private BigDecimal confirmFee;

    /**
     * 备注
     */
    private String remark;

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

    /**
     * 逻辑删除，1存在，0不存在
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 配送时间段
     */
    @Column(name = "deliver_time")
    private String deliverTime;

}