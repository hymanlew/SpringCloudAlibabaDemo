package com.hyman.common.enums.waybill;

/**
 * @author NiuZhiPeng
 * @date 2021/01/25 9:49
 * @Description： 运单、司机、客户账单异常信息枚举
 */
public enum WayBillErrorMessageEnum {

    DATA_IS_UPDATE_REFRESH_AGAIN_CONFIRM(301680001," 数据已被更新，请手动刷新页面后再次确认"),
    GM_WAY_BILL_SEND_DRIVER_MSG_FAILED(301680002,"加盟代报运费给司机发短信失败"),
    WAY_NUM_MORE_THEN_LINE_DELIVER_TIME_MSG_TOTAL(301680003,"运单趟数超出线路配送时间信息总数"),
    GM_NO_REPORT_NOT_CONFIRM(301680004,"加盟侧未上报，不可以进行确认"),
    SECOND_NO_REPORT_NOT_SECOND_CONFIRM(301680005,"外线侧未上报，不可以交叉确认"),
    WAY_BILL_IS_NULL(301680006,"运单为空"),
    CREATE_WAY_BILL_BUT_RUN_TEST_ID_IS_NULL(301680007,"创建运单时试跑id为空"),
    NEED_ARTIFICIAL_RUN_TEST_CREATE_WAY_BILL_FAILED(301680008,"【需人工手动补偿】试跑-创建运单失败"),
    NEED_ARTIFICIAL_RUN_TEST_WAY_BILL_NUM(301680009,"【需人工手动补偿】试跑-创建出车单趟数"),
    NEED_ARTIFICIAL_RUN_TEST_CREATE_WAY_BILL_AMOUNT_FAILED(301680010,"【需人工手动补偿】试跑-创建出车单趟数实体失败"),
    NEED_ARTIFICIAL_CREATE_OR_UPDATE_TIME_PROJECT_FAILED(301680011,"【需人工手动补偿】周报生成或者更新异常"),
    PARAMS_NOT_FULL(301680012,"参数不全"),
    DEPARTURE_DATE_NOT_NULL(301680013,"出车时间不能为空"),
    NOT_HAVE_ORDER_ID(301680014,"缺少订单编号"),
    THIS_VERSION_ONLY_SUPPORT_WAY_BILL_INIT(301680015,"当前版本只支持运费初始化"),
    NOT_HAVE_PROJECT_ID(301680016,"缺少项目编号"),
    NOT_HAVE_LINE_ID(301680017,"缺少线路编号"),
    NOT_HAVE_WAY_BILL_ID(301680018,"缺少运单编号"),
    NOT_HAVE_DEPARTURE_TIME(301680019,"缺少出车时间"),
    NOT_HAVE_SUBJECT(301680020,"缺少费用科目"),
    DEPARTURE_ERROR_GT_NOW(301680021,"出车日期异常，大于当前时间"),
    CUSTOMER_NOT_EXIT_CREATE_AMOUNT_NOW(301680022,"客户账户不存在，请先创建账户"),
    FAILED_GET_LINE_MESSAGE(301680023,"获取线路信息失败"),
    GET_LINE_MESSAGE_IS_EMPTY(301680024,"获取线路信息为空"),
    CUSTOMER_ID_IS_EMPTY_IN_LINE_MESSAGE(301680025,"线路信息中客户ID为空"),
    CUSTOMER_WAY_BILL_ID(301680026,"客户运费账户ID"),
    SUBJECT_MUST_WAY_BILL_CONFIRM(301680027,"费用科目必须为运费确认"),
    PROJECT_UPDATE_FAILED(301680028,"项目更新失败"),
    PROJECT_ID_NOT_EXIT(301680029,"项目id不存在"),
    NOT_HAVE_CUSTOMER_AMOUNT_SYSTEM_AUTO_CREATE(301680030,"没有客户运费账户，系统自动创建"),
    GET_COMMISSION_FAILED(301680031,"抽佣失败"),
    AUTO_CONFIRM_ERROR(301680032,"自动单边确认异常"),
    DRIVER_NOT_HAVE_ACCOUNT_BOOK(301680033,"司机没有账本，司机id: "),
    DRIVER_WAY_BILL_ACCOUNT_NOT_HAVE_ACCOUNT_BOOK(301680034,"司机运费账户没有账本,司机运费账户ID:"),
    RUN_TEST_DROPPED_UPDATE_DRIVER_ID_FAILED(301680035,"试跑-在跑掉线，更新司机域司机编号失败")
    ;

    private Integer code;
    private String message;

    WayBillErrorMessageEnum(Integer code, String message) {
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
