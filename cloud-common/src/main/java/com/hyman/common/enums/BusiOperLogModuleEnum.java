package com.hyman.common.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Changyuan Su
 * @date 2019/4/18 13:55
 * @Description: 线路日志模块枚举
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BusiOperLogModuleEnum {

    BASE_AGENT_BUNDLING("base_agent_bundling", "坐席绑定"),
    BASE_AGENT_UN_BUNDLING("base_agent_un_bundling", "坐席解绑"),
    BASE_AGENT_CHANGE("base_agent_change", "坐席更换绑定"),

    RUN_TEST_DROPS_LINE_STATUS("run_test_drops_line_status", "试跑掉线变更线路状态"),
    LINEPROJECT_AUDITCHANGE_STATUS("lineProject_auditState", "项目审核任务状态变更类操作"),
    LINEPROJECT_CHANGE_STATUS("lineProject_changeProjectState", "项目任务状态变更类操作"),
    LINETASK_CHANGE_STATUS("lineTask_changeStatus", "线路任务状态变更类操作"),
    LINE_MANAGER_VISIT_PROJECT("line_manager_visit_project","项目拜访状态变更类操作"),
    LINECLUE_CHANGE_STATUS("lineClue_change", "货主线索任务变更类操作"),
    LINETASK_ORDINARY_OPERATION("lineTask_ordinaryOperation", "线路任务普通类型操作"),
    LINETASK_LIFECYCLE_CHANGE_STATUS("lineTask_lifecycleChangeStatus", "线路任务生命周期状态变更类操作"),
    LINECUSTOMER_AUDITCHANGE_STATUS("lineCustomer_auditState", "项目审核任务状态变更类操作"),
    LINECUSTOMER_CHANGE_STATUS("lineCustomer_changeStatus", "线路方客户状态变更类操作"),
    LINECUSTOMER_ORDINARY_OPERATION("lineCustomer_ordinaryOperation", "线路方客户普通类型操作"),
    LINECUSTOMERPOOL_FOLLOW_OPERATION("lineCustomerPool_followOperation", "线路客户池跟进类型操作"),
    LINECUSTOMERPOOLCLUE_ORDINARY_OPERATION("lineCustomerPoolClue_ordinaryOperation", "客户沙盘池普通类型操作"),
    LINECUSTOMERCLUE_ORDINARY_OPERATION("lineCustomerClue_ordinaryOperation", "客户线索普通类型操作"),
    LINECUSTOMERCLUE_FOLLOW_OPERATION("lineCustomerClue_followOperation", "客户线索跟进类型操作"),
    TENDER_CHANGE_STATUS("tender_changeStatus", "标书状态变更类操作"),
    TENDER_ORDINARY_OPERATION("tender_ordinaryOperation", "标书普通类型操作"),
    ORDERREFUNDAPPLY_CHANGE_STATUS("order_refund_apply_changeStatus", "订单退款申请状态变更类操作"),
    ORDER_PAY_STATUS_CHANGE("order_pay_status_change", "订单支付状态变更类操作"),
    ORDER_REFUND_STATUS_CHANGE("order_refund_status_change", "订单退款状态变更类操作"),
    XIQUE_ORDER_MONEY("xique_order_money", "通过喜鹊app创建订单支付定金相关操作"),
    BID_AUCTION_SCENE_OPERATION("bid_auction_scene_operation", "标书拍场相关操作"),
    BID_BIDDING_OPERATION("bid_bidding_operation", "竞价信息相关操作"),
    DISPATCH_DELIVERY_RECORD_GENERATE("gen_dispatch_delivery_record", "生成司机运单记录操作"),
    DISPATCH_DELIVERY_RECORD_CONFIRM_COST("confirm_delivery_record_cost", "运费确认"),
    DISPATCH_DELIVERY_RECORD_DEV_CHANGED("dev_changed_delivery_record_cost", "运费修改"),
    LINEPROJECT_DOCKING_PEOPLE("line_project_docking_people", "设置项目接待人"),
    LINE_SHELF_MAINTENANCE("line_shelf_maintenance", "线路货架维护"),
    CARRIER_OPERATION("carrier_operation", "运力操作"),

    /*司机相关 begin*/
    DRIVER_BIND_BD_MANAGER("driver_bind_bd_manager", "给司机分配加盟经理"),
    DRIVER_BIND_DM_MANAGER("driver_bind_dm_manager", "给司机分配司撮经理"),
    DRIVER_WORK_CITY_UPDATE("driver_work_city_update", "司机工作城市修改"),
    DRIVER_BUSI_USER_NORMAL("driver_busi_user_normal", "普通业务操作"),
    DRIVER_FOLLOW_USER_INSERT("driver_follow_user_insert", "跟进"),
    DRIVER_FOLLOW_USER_UPDATE("driver_follow_user_update", "跟进操作"),
    DRIVER_STATUS_USER_UPDATE("driver_status_user_update", "司机状态变更"),
    DRIVER_CREATE_NORMAL("driver_create_normal", "自动创建司机"),
    DRIVER_GIVE_UP("driver_give_up", "放弃"),
    CLUE_BIND_BD_MANAGER("clue_bind_bd_manager", "给线索分配加盟经理"),
    CLUE_EDIT("clue_edit", "编辑线索"),
    MARKET_CLUE_EDIT("market_clue_edit", "市场部线索操作"),
    MARKET_CLUE_CREATE("market_clue_create", "市场部线索创建"),
    LN_MINI_CLUE_CREATE("ln_mini_clue_create", "雷鸟车池小程序线索创建"),
    MARKET_CAMPAIGN_CREATE("market_campaign_create", "campaing创建"),
    MARKET_CLUE_USER_GROUP("market_clue_user_group", "市场部线索客群细分"),
    DRIVER_LINE_COLLECTION("driver_line_collection", "司机收藏线路"),
    DRIVER_CLUE_PAY_RECORD("driver_clue_pay_record", "线索缴费"),
    MARKET_CLUE_INTERVIEW("market_clue_interview", "市场部线索邀请面试"),
    MARKET_CLUE_ADD_FOLLOW("market_clue_add_follow", "市场部线索添加跟进"),
    MARKET_CLUE_INTERVIEW_TIME("market_clue_interview_time", "市场部线索面试时间"),
    MARKET_CLUE_REFLOW("market_clue_reflow", "市场部线索回流时间配置"),
    MARKET_CLUE_CANCEL_INTERVIEW_TIME("market_clue_interview_time", "市场部线索面试时间"),
    MARKET_CLUE_REPEAT_CREATE("market_clue_repeat_create", "市场部线索-线索重复录入"),
    MARKET_CLUE_ZLB2ZL("market_clue_zlb2zl", "市场部线索-雷鸟租赁B线索数据清洗到雷鸟租赁"),

    DRIVER_LABEL_SYNC_CREATE("driver_label_sync_create", "梧桐-自承运司机打标签-新增"),
    DRIVER_LABEL_SYNC_UPDATE("driver_label_sync_update", "梧桐-自承运司机打标签-修改"),
    DRIVER_LABEL_SYNC_ACTIVATE("driver_label_sync_activate", "梧桐-自承运司机打标签-激活"),
    DRIVER_LABEL_SYNC_UNBIND("driver_label_sync_unbind", "梧桐-自承运司机打标签-解绑"),
    /*司机相关 end*/

    WT_DRIVER_ACCOUNT_CREATE("wt_driver_account_insert", "梧桐司机账户创建"),
    WT_DRIVER_ACCOUNT_REFUND("wt_driver_account_refund", "梧桐司机账户退款"),
    WT_DRIVER_RECORD_CREATE("wt_driver_record_insert", "梧桐司机流水新建"),
    WT_DRIVER_FREEZE_OR_MELT("wt_driver_freeze_or_melt", "梧桐司机账户冻结或解冻"),
    WT_DRIVER_ORDER_PAYMENT_CREATE("wt_driver_order_payment_create", "梧桐司机-订单缴费申请单创建"),

    /*赋能打分*/
    SCORE_RULE("assess_ass_rule", "设置赋能打分打分规则"),
    START_SCORE("assess_ass_session","赋能打分-开始打分"),
    SCORE_VIEW_REPORT("assess_ass_report","赋能打分-查看报表详情"),
    SCORE_NEW_EXAM("assess_ass_session","赋能打分-开启新场次考核"),

    //撮合相关
    MATCH_LIST_INFO_UPDATE("match_list_info_update","撮合单状态更新"),
    MATCH_CUST_INVITE_UPDATE("match_cust_invite_update","客邀单状态更新"),
    MATCH_START_CUST_INVITE("match_start_cust_invite","发起客邀"),
    MATCH_CANCEL_CUST_INVITE("match_cancel_cust_invite","取消客邀"),
    MATCH_START_CUST_INVITE_BATCH("match_start_cust_invite_batch","批量发起客邀"),
    MATCH_CANCEL_CUST_INVITE_BATCH("match_cancel_cust_invite_batch","批量取消客邀"),

    DRIVER_INTERVIEW_CHANNEL("driver_interview_channel", "司机面试表渠道管理")
    ;


    /**
     * 对应存储到数据库中module的code值
     */
    private String module;

    /**
     * 对应于数据库中module的code的中文值
     */
    private String moduleName;

}
