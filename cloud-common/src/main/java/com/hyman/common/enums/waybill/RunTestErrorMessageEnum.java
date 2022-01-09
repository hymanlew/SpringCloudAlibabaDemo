package com.hyman.common.enums.waybill;

/**
 * @author NiuZhiPeng
 * @date 2021/01/25 9:48
 * @Description： 试跑在跑异常信息枚举
 */
public enum RunTestErrorMessageEnum {

    LINE_ID_NOT_NULL(301680036, "线路id不能为空"),
    FAILED_TO_UPDATE_LINE_STATE_BY_LINE_DOMAIN(301680037, "调用线路域更新线路状态失败"),
    RUN_TEST_ID_NOT_NULL(301680038, "试跑在跑ID不能为空"),
    RUN_TEST_INTENTION_IS_FAILED_NOT_FOLLOW_CAR_OR_TRY_RUN(301680039, "试跑意向已经失败，不能跟车或者试跑!"),
    THIS_RUN_TEST_HAS_SWITCH_FOLLOW_CAR_HAVE_TRY_RUN_NOT_OPERATE_FOLLOW_CAR_DROPPER_QUIT(301680040, "该试跑已经从跟车转为试跑，不能操作跟车掉线,请退出当前操作!"),
    THIS_TUN_TEST_DATA_HAS_UPDATE_CLOSE_AND_REPEAT(301680041, "该试跑数据已被更新，请关闭当前页面重新操作"),
    FAILED_GET_CAR_NO_BY_ORDER_DOMAIN(301680042, "调用订单域获取车牌号失败"),
    FAILED_GET_DRIVER_MSG_BY_DRIVER_DOMAIN(301680043, "调用司机域获取司机信息失败"),
    STEADY_RUNNING_FAILED_UPDATE_LINE_STATE_BY_LINE_DOMAIN(301680044, "稳定在跑，掉用线路域更新线路状态异常"),
    FAILED_GET_LINE_MSG_BY_LINE_DOMAIN(301680045, "调用线路域获取线路信息失败"),
    FAILED_INSERT_DRIVER_SNAPSHOT_BY_DRIVER_DOMAIN(301680046, "调用司机域保存司机快照失败"),
    FAILED_INSERT_LINE_SNAPSHOT_BY_LINE_DOMAIN(301680047, "调用线路域保存线路快照失败"),
    FAILED_GET_ORDER_MSG_BY_ORDER_DOMAIN(301680048, "调用订单域获取订单信息异常"),
    DRIVER_NOT_HAVE_CLOSED_ORDER_NOT_CREATE_RUN_TEST(301680049, "司机没有已成交订单, 无法创建试跑"),
    THIS_LINE_IS_OCCUPY(301680050, "该线路被占用"),
    FAILED_GET_LINE_STATE_BY_LINE_DOMAIN(301680051, "调用线路域获取线路状态失败"),
    FAILED_SYNC_LINE_FOLD_STATE_BY_LINE_DOMAIN(301680052, "调用线路域,同步同步折叠线路状异常"),
    START_TIME_AND_END_TIME_NOT_NULL(301680053, "开始时间，和结束时间不能为空"),
    FAILED_UPDATE_RUN_TEST_INTENTION(301680054, "更新试跑意向失败异常"),
    ARRIVAL_TIME_NOT_NULL(301680055, "到仓时间不能为空"),
    LINE_CATEGORY_NOT_NULL(301680056, "线路类型(临时/稳定) 不能为空"),
    ARRIVAL_TIME_CHECKED_NO_PASS(301680057, "到仓时间校验不通过"),
    FOLLOW_CAR_DELIVER_TIME_AND_END_TIME_NOT_NULL(301680058, "跟车时配送开始和结束时间不为空"),
    FOLLOW_CAR_START_DATE_END_DATE_SCOPE(301680059, "需要选择跟车开始日期和结束日期；开始日期可选范围为T-3，结束日期为开始日期的未来7天内"),
    STABLE_LINE_DELIVER_TIME_NOT_NULL(301680060, "稳定线路配送开始时间不为空"),
    STABLE_LINE_START_DATE(301680061, "开始日期只能为T-3"),
    TEMPORARY_LINE_DELIVER_TIME_AND_END_TIME_NOT_NULL(301680062, "配送开始和结束时间不能为空"),
    TEMPORARY_LINE_DELIVER_TIME_START_END_SCOPE(301680063, "开始日期可选范围为T-3，结束日期为开始日期的未来30天内"),
    NEED_ARTIFICIAL_FOLLOW_CAR_SWITCH_TRY_RUN_TEMPORARY_LINE_DROPPED_TIME_LT_RUN_TEST_DROPPED(301680064, "【需人工跟进补偿】跟车转试跑或者意向转试跑，临时新路配送时间小于当天试跑掉线，同步线路域失败"),
    NEED_ARTIFICIAL_FOLLOW_CAR_OR_RUN_TEST_INTENTION_SWITCH_TRY_RUN_UPDATE_DRIVER_ID_BY_DRIVER_DOMAIN(301680065, "【需人工跟进补偿】跟车转试跑或意向转试跑-在跑"),
    NEED_ARTIFICIAL_FOLLOW_CAR_OR_RUN_TEST_INTENTION_SWITCH_TRY_RUN_SYNC_DRIVER_OR_LINE_DOMAIN_FAILED(301680066, "【需人工跟进补偿】跟车转试跑或者意向转试跑，同步司机或线路域异常"),
    NEED_ARTIFICIAL_SWITCH_TRY_RUN_SYNC_LINE_DOMAIN_FAILED(301680067, "【需人工跟进补偿】转试跑或者试跑，同步线路域失败"),
    NEED_ARTIFICIAL_BATCH_SYNC_FOLD_LINE_AND_LINE_STATE_FAILED(301680068, "【需人工跟进补偿】，批量同步折叠线路和线路状态失败"),
    NEED_ARTIFICIAL_TRY_RUN_BATCH_DROPPED_UPDATE_DRIVER_STATE_BY_DRIVER_DOMAIN_FAILED(301680069, "【需人工跟进补偿】试跑批量掉线-通知司机域批量更新司机状态异常"),
    THIS_LINE_IS_FOLLOW_CAR(301680070, "该线路已经跟车"),
    THIS_LINE_IS_HAVE_TRY_RUN(301680071, "该线路已经试跑"),
    THIS_RUN_TEST_INTENTION_HAS_UPDATE_REFRESH(301680072, "该试跑意向已被更新，请刷新重试"),
    THIS_NOT_RUN_TEST_INTENTION_NOT_CANCEL_INTENTION(301680073, "当前非试跑意向状态不能取消意向"),
    CANCEL_RUN_TEST_INTENTION_AFFECT_ROWS_GT_ONE(301680074, "试跑意向取消操作影响行数大于1"),
    FAILED_SYNC_LINE_STATE_BY_LINE_DOMAIN(301680075, "调用线路域,同步线路状态失败"),
    FAILED_SYNC_LINE_MESSAGE_BY_LINE_DOMAIN(301680076, "调用线路域批量同步线路信息失败"),
    FAILED_SYNC_FOLD_LINE_MESSAGE_BY_LINE_DOMAIN(301680077, "调用线路域批量同步折叠线路信息失败"),
    SWITCH_STEADY_RUNNING_ERROR(301680078, "转稳定在跑异常"),
    UPDATE_RUN_TEST_FAILED_ERROR_LINE_IDS(301680079, "更新试跑意向失败异常,线路集合编号为:"),
    NOT_CREATE_RUN_TEST_THIS_LINE_STATE(301680080, "不能创建试跑,因为该线路状态为："),
    CONFIRM_INTENTION_SYNC_LINE_STATUS(301680081, "确认试跑意向同步线路状态失败,失败原因为："),
    CAN_NOT_TO_WAIT_CONFIRM(301680082, "当前试跑状态不能转到 “待确认到场” "),
    MATCH_ID_NOT_NULL(301680083, "撮合单ID不能为空"),
    MATCH_TYPE_NOT_NULL(301680084, "撮合类型不能为空"),
    MATCH_STATUS_NOT_NULL(301680085, "撮合状态不能为空"),
    DRIVER_DEAL_NOT_NULL(301680086, "司机是否新成交不能为空"),
    MAtCH_STATUS_UPDATE_FAIL(301680087, "撮合单状态更新失败"),
    MAtCH_CANCEL_INTENTION_NOT_NULL(301680088, "意向取消原因不能为空"),
    DRIVER_STATES_EXIT(301680089, "司机已退出，请重新刷新列表"),
    DRIVER_NO_FREE(301680090, "司机已欠费，请重新刷新列表"),
    DRIVER_NO_BALANCE(301680091, "司机梧桐账户不存在，请先创建司机梧桐账户并充值"),
    RUN_TEST_SYNC_MATCH_STATUS(301680092, "试跑状态变话同步撮合域失败,失败原因为："),
    ;


    private Integer code;
    private String message;

    RunTestErrorMessageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("%s。错误代码：%d。", this.message, this.code);
    }
}
