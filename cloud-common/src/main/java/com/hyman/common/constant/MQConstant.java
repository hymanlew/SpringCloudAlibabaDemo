package com.hyman.common.constant;

/**
 * @author hucl
 * @date 2021/5/11 11:32 上午
 */
public interface MQConstant {
    /**
     * 司机标签相关MQ信息
     */
    String DRIVER_LABEL_DRIVER_GROUP = "GID_DRIVER_DRIVER_LABEL";
    String DRIVER_LABEL_DRIVER_TOPIC = "szjw_driver_label";
    String DRIVER_LABEL_DRIVER_TAG = "labelSyncFromDriver";
    String DRIVER_LABEL_DRIVER_SHARDING_KEY = "driverId";

    /**
     * 司机梧桐账户
     */
    String WT_ACCT_DRIVER_TOPIC = "szjw_bill_driver_acct";
    String WT_ACCT_DRIVER_TAG = "balanceChanged";
    String WT_ACCT_DRIVER_GROUP = "GID_ACCT_DRIVER_BOOK";

    /**
     * 撮合向司机测同步数据
     */
    String DRIVER_INFO_MATCH_GROUP = "GID_DRIVER_MATCH_GROUP";
    String DRIVER_INFO_MATCH_TAG = "driverSyncFromMatch";
    String DRIVER_INFO_MATCH_TOPIC = "szjw_driver_label";


}
