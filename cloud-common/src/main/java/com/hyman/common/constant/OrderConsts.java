package com.hyman.common.constant;

/**
 * @Classname OrderConsts
 * @Description
 * @Date 2020/7/8
 * @Created by xiefujiang
 */
public class OrderConsts {
    /**
     * 操作标识位
     * creat订单创建  小程序需要confirm订单确认
     * cancel web订单手动取消 ,auditPass审核通过
     * auditNotPass 审核不通过  rePay订单再支付
     * refund 退款
     * resubmitAndCommit 重新提交
     */
    public static final String CREAT = "creat";
    public static final String DETIAL = "detial";
    public static final String CONFIRM = "confirm";
    public static final String CANCEL = "cancel";
    public static final String AUDITPASS = "auditPass";
    public static final String AUDITNOTPASS = "auditNotPass";
    public static final String RESUBMITANDCOMMIT = "resubmitAndCommit";
    public static final String REPAY = "rePay";
    public static final String REFUND = "refund";
    public static final String TIMEOUT = "timeout";
    public static final String STEP2 = "step2";
    public static final String STEP1 = "step1";
    public static final String SUBMIT = "submit";
    public static final String RESUBMIT = "resubmit";
    public static final String HAVE_DEAL = "haveDeal";
    public static final String ABORT = "abort";
    public static final String LIST = "list";
    public static final String ABORT_DEAL = "abort_deal";
    public static final String ORDER_AUDIT_REDIS_LOOK_KEY = "order_audit_redis_look_key";
    public static final String ORDER_SUBMIT_REDIS_LOOK_KEY = "order_submit_redis_look_key";

    /**
     * 标准订单金额：4000
     */
    public static final Integer standardPayMoney = 4000;
    /**
     * 默认抽佣比例：7%
     */
    public static final Integer defaultRake = 7;
    /**
     * 默认合作模式：带车
     */
    public static final Integer defaultCooperationModel = 3;
    /**
     * 默认合作期限：3个月
     */
    public static final Integer defaultCooperationTime = 3;
    /**
     * 默认运力配合：1
     */
    public static final Integer defaultCapacityQuota = 1;

    /**
     * 是否交付，是否支付完成;是否使用可提现支付
     */
    public static final Integer YES = 1;
    public static final Integer NO = 0;




}
