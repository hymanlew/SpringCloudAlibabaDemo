package com.hyman.common.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ApiModel("es的index和type枚举")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ESIndexTypeEnum {

    DRIVER_CLUE_LIST("szjw_driver_clue", "driver_clue", "司机线索列表"),
    DRIVER_CLUE_H5_LIST("szjw_driver_clue_h5_list", "driver_clue_h5_list", "司机H5线索列表"),
    DRIVER_INFO_LIST("szjw_driver_list", "driver_list", "司机列表"),
    DRIVER_LABEL_SYNC_LIST("szjw_driver_label_sync_list", "driver_label_sync", "司机打自承运免押金、平台服务费ES列表"),
    DRIVER_MARKET_CLUE_MANAGEMENT_LIST("szjw_driver_market_clue_management_list", "market_clue_management_list", "市场部线索列表"),
    DRIVER_MARKET_CLUE_USER_GROUP_LIST("szjw_driver_market_clue_user_group_list", "market_clue_user_group_list", "客群细分列表"),
    DRIVER_MARKET_CAMPAIGN_LIST("szjw_driver_market_campaign_list", "market_campaign_list", "campaign列表"),
    DRIVER_INTERVIEW_LIST("szjw_driver_interview_list","driver_interview_list","司机面试表"),

    TIME_PROJECT_INFO_LIST("szjw_time_project_list", "time_project_list", "项目周报列表"),


    RUN_TEST_INFO_LIST("szjw_runtest_list", "runtest_list", "试跑在跑es索引列表"),
    WAY_BILL_INFO_LIST("szjw_waybill_list", "waybill_list", "运单es索引列表"),
    DRIVER_ACCT_BUSINESS_RECORD_LIST("szjw_driver_acct_business_record_list", "driver_acct_business_record_list", "司机账户流水es索引列表"),
    DRIVER_MONTHLY_BILL_LIST("szjw_driver_monthly_bill_list", "monthly_bill_list", "司机账户月账单流水es索引列表"),
    CUSTOMER_ACCT_BUSINESS_RECORD_LIST("szjw_customer_acct_business_record_list", "customer_acct_business_record_list", "客户运费账户流水es索引列表"),
    CUSTOMER_MONTHLY_BILL_LIST("szjw_customer_monthly_bill_list", "customer_monthly_bill_list", "客户运费账户月账单流水es索引列表"),
    DRIVER_SHIPPING_CHANGE_LIST("szjw_driver_shipping_change_list", "driver_shipping_change_list", "司机运费变更记录es索引列表"),

    BILL_ACCT_BUSINESS_RECORD_LIST("szjw_bill_acct_business_record_list", "acct_business_record_list", "梧桐账户流水es索引列表"),
    BILL_ACCT_BOOK_LIST("szjw_bill_acct_book_list", "acct_book_list", "梧桐司机账户es索引列表"),
    BILL_REFUND_APPLICATION_LIST("szjw_refund_application_list","refund_application_list","退费列表"),
    BILL_PAYMENT_APPLICATION_LIST("szjw_payment_application_list","payment_application_list","梧桐账户缴费es索引"),

    LINE_FOLD_LIST("szjw_linecloud_fold", "fold_list", "折叠线路es索引列表"),

    LINE_INFO_LIST("szjw_line_list","line_list","线路es索引列表"),
    LINE_CUSTOMER_LIST("szjw_linecloud_customer","customer_list","客户es索引列表"),
    LINE_PROJECT_LIST("szjw_linecloud_project","project_list","客户es索引列表"),
    LINE_SHELF_REDUNDANT_LIST("szjw_line_shelf_redundant","line_shelf_redundant_list","冗余线路es索引列表"),


    MATCH_DRIVER_INFO_LIST("szjw_match_driver_list", "match_driver_list", "撮合工作台-司推列表"),
    MATCH_LINE_INFO_LIST("szjw_match_line_list", "match_line_list", "撮合工作台-线路列表"),

    ;
    /**
     * index
     */
    @ApiModelProperty("index")
    private String index;

    /**
     * type
     */
    @ApiModelProperty("type")
    private String type;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String desc;

}
