package com.hyman.common.enums.bill;

import com.hyman.common.enums.waybill.ShippingSubjectEnum;

import javax.validation.constraints.NotNull;

/**
 * @description: SubjectEnum <br>
 * @date: 2020/10/14 19:15 <br>
 * @author: hyman <br>
 */
public enum SubjectEnum {
    
    DEFAULT(0, "默认科目"),

    ORDER_PAY_COST(1, "订单缴费"),
    PAY_COST(2, "缴费"),
    UNILATERA_CONFIRMATION(3, "单边确认抽佣"),
    THE_DEFAULT_PUNISH(4, "违约扣罚"),
    CROSS_VALIDATION(5, "交叉确认抽佣"),
    FREIGHT_ADJUSTMENT(6, "运费调整"),
    ACCOUNT_ADJUSTMENT(7, "账号退费"),
    FREEZE(8, "冻结"),
    UNFREEZE(9, "解冻"),
    RECORD_ADJUSTMENT(10, "手动调流水"),

    /**
     * 订单相关的费用科目
     */
    ORDER_TO_BE_APPROVED_USE_EXTRACT_MONEY(11, "订单-待审核-可提现金额支付"),
    ORDER_NOT_APPROVED_USE_EXTRACT_MONEY(12, "订单-审核不通过-可提现金额支付"),
    ORDER_APPROVED_USE_OFFLINE(13, "订单-审核通过-线下支付"),

    /**
     * 运费费用科目
     */
    WAY_BILL_UNILATERAL_CONFIRMATION(1001, "单边已确认"),
    WAY_BILL_BILATERAL_CONFIRMATION(1003, "已交叉确认"),
    WAY_BILL_INITIALIZATION(1005, "运费初始化"),
    WAY_BILL_ADJUSTMENT(1006, "运费调整"),

    /**
     * sop计费
     */
    G_BREAK_A_PROMISE(2001, "爽约(共享)"),
    LATE(2002, "迟到"),
    JUMP_LIST(2003, "跳单"),
    PRE_TERMINATION(2004, "提前解约"),
    TO_LIE_ABOUT(2005, "谎报/少报/故意不报超3次"),
    IRREGULARITIES(2006, "违规操作"),
    Z_BREAK_A_PROMISE(2007, "爽约(专车)"),
    CUSTOMER_CHURN(2008, "客户流失"),
    FREIGHT_UNDERREPORTED(2009, "运费少报"),
    FREIGHT_IS_NOT_SUBMITTED(2010, "运费不报"),
    ;;

    private final int code;
    private final String desc;

    SubjectEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static String getDesc(Integer code) {
        for (SubjectEnum ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getDesc();
            }
        }
        return DEFAULT.getDesc();
    }

    public static SubjectEnum getSubjectEnum(Integer code) {
        for (SubjectEnum ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele;
            }
        }
        return DEFAULT;
    }

    /**
     * for example
     *
     * 获取运费相关的科目
     *
     * @param code {@link ShippingSubjectEnum#getCode()}
     * @return SubjectEnum
     * @see com.hyman.common.enums.waybill.ShippingSubjectEnum
     */
    public static SubjectEnum getWayBillSubjectEnum(@NotNull Integer code) {
        code += 1000;
        return getSubjectEnum(code);
    }
    
    /**
     * for example
     *
     * 获取计费相关的科目
     *
     * @param code {@link ShippingSubjectEnum#getCode()}
     * @return SubjectEnum
     * @see com.hyman.common.enums.waybill.ShippingSubjectEnum
     */
    public static SubjectEnum getChargeSubjectEnum(@NotNull Integer code) {
        code += 2000;
        return getSubjectEnum(code);
    }
}
