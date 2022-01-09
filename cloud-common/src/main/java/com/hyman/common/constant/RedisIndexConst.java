package com.hyman.common.constant;

/**
 * Redis索引常量
 *
 * @author wanghaitong
 * @date 2020/10/20 15:51
 */
public class RedisIndexConst {

    /**
     * 司机月账单
     */
    public static final String IDX_DRIVER_MONTHLY_BILL = "idx_driver_monthly_bill_create";
    /**
     * 司机运费账户
     */
    public static final String IDX_DRIVER_ACCT = "idx_driver_acct_create";
    /**
     * 客户月账单
     */
    public static final String IDX_CUSTOMER_MONTHLY_BILL = "idx_customer_monthly_bill_create";
    /**
     * 客户运费账户
     */
    public static final String IDX_CUSTOMER_ACCT = "idx_customer_acct_create";
    /**
     * 试跑在跑意向
     */
    public static final String IDX_RUN_TEST_INTENTION = "idx_run_test_intention";
    /**
     * 试跑在跑状态修改
     */
    public static final String IDX_RUN_TEST_UPDATE_STATUS = "idx_run_test_update_status";
    
    /**
     * 试跑在跑状态修改
     */
    public static final String IDX_BASE_CALL_LOG = "idx_base_call_log";
    /***
     * 司机标签修改
     */
    public static final String LABEL_DRIVER_UPDATE = "label_driver_update";

    /**
     * 雷鸟车池小程序线索入池
     */
    public static final String LN_MN_PROGRAM_CLUE_CREATE = "idx_ln_clue_create";
}
