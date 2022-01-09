package com.hyman.common.model.dao.order;

import com.hyman.common.model.dao.BaseDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_refund_apply")
public class OrderRefundApplyDAO extends BaseDAO implements Serializable {

    /**
     * 退款申请编号
     */
    @Column(name = "refund_apply_no")
    private Long refundApplyNo;

    /**
     * 订单编号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 支付方式(1账户 2微信支付 3支付宝 4云鸟钱包 5银联支付)
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 退款原因
     */
    @Column(name = "refund_reason")
    private Integer refundReason;

    /**
     * 收据图片
     */
    @Column(name = "receipt_photo")
    private String receiptPhoto;

    /**
     * 退款状态(1待审核;2审核通过(待退款);3退款审核不通过;4退款中;5退款成功;6退款失败)
     */
    @Column(name = "refund_state")
    private Integer refundState;

    /**
     * 扣款金额
     */
    @Column(name = "deduct_money")
    private BigDecimal deductMoney;

    /**
     * 实际退款金额
     */
    @Column(name = "refund_money")
    private BigDecimal refundMoney;

    /**
     * 邮件确认截图
     */
    @Column(name = "mail_confirm_photo")
    private String mailConfirmPhoto;

    /**
     * 退款失败原因
     */
    @Column(name = "refund_faild_reason")
    private String refundFaildReason;

    /**
     * 退款不通过原因
     */
    @Column(name = "not_through_reason")
    private Integer notThroughReason;

}