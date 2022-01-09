package com.hyman.common.enums.driver;

/**
 * @author zhangjunkui
 */

public enum ErrorMessageEnum {

    EMPTY_USER_INFO(90001, "用户信息为空"),
    PARAMETERS_ERROR(90002, "参数有误"),
    NULL_RESULT(90003, "操作失败：结果为空"),
    PHONE_NUM_NOT_FOUND(90004, "手机号不存在，请认真核对"),
    FAILED_TO_CREATE_DRIVER_LABEL(90005, "创建司机标签失败"),
    CAR_MODEL_NOT_NULL_WHEN_HAVE_CAR(90006, "有车情况下，车型不能为空"),
    FAILED_TO_CALL_UPLOAD_FILE_TO_OSS_INTERFACE(90007, "调用上传文件到oss接口失败"),
    FAILED_TO_CALL_UPDATE_EXPORT_DOWNLOAD_RECORD_INTERFACE(90008, "调用更新导出下载记录接口失败"),
    FAILED_TO_CALL_CREATE_EXPORT_DOWNLOAD_RECORD_INTERFACE(90009, "调用创建导出下载记录接口失败"),
    PHONE_NUM_IS_NULL(90010, "手机号为空"),
    PHONE_NUM_FORMAT_IS_INCORRECT(90011, "手机号格式不正确"),
    GET_PHONE_NUM_IS_NULL_BY_TOKEN(90012, "token获取手机号为空"),
    FAILED_TO_GENERATE_CLUE(90013, "生成线索失败，该用户已经存在线索，请核对是否为正确授权手机号"),
    PHONE_NUM_ENTERED(90014, "手机号已经入驻"),
    PHONE_NUM_EXISTS(90015, "手机号已存在"),
    USER_INFORMATION_NOT_FOUND(90016, "未找到用户信息"),
    CURRENT_BUSINESS_LINE_NOT_SUPPORT_QRCODE(90017, "当前用户业务线暂不支持生成二维码"),
    NO_CLUE_EXISTS(90018, "无线索"),
    NO_SUCH_CLUE_INFORMATION(90019, "无此线索信息"),
    NO_DATA_FOUND(90020, "未查到数据"),
    NO_SUPPORT_TO_CHANGE_GM(90021, "暂不支持待成交、已成交、已上岗司机跨业务线更换加盟经理"),
    EMPTY_INFORMATION(90022, "信息为空"),
    SNAPSHOT_HISTORY_RESOURCE_NOT_EXISTS(90023, "快照历史资源不存在"),
    NO_SUPPORT_TO_CHANGE_DM(90024, "暂不支持 已面试/待成交 司机更换司撮经理"),
    FAILED_TO_GET_GM_BY_SUCH_PHONE_NUM(90025, "该手机号查询不到加盟经理"),
    DRIVER_INFORMATION_NOT_EXISTS(90026, "司机信息不存在"),
    CLUE_GM_NOT_EXISTS(90027, "线索信息异常，线索加盟经理不存在"),
    GM_NOT_EXISTS(90028, "选择的加盟经理不存在"),
    TRANSFORMED_CLUE_NO_SUPPORT_TO_CHANGE_OWNER(90029, "暂不支持已转化的线索更换归属人"),
    CLUE_ID_NOT_EXISTS(90030, "提交的需要修改线索id不存在"),
    TRANSFORMED_CLUE_CAN_NOT_MODIFY(90031, "已转化的线索不能修改"),
    CURRENT_BUSITYPE_PHONE_NUMBER_HAS_USED(90032, "当前业务线手机号已被使用"),
    EXPECTED_CAR_TYPE_OR_CURRENT_CAT_TYPE_INCOMPLETED(90033, "意向驾驶车型或当前车型未填写完整"),
    CURRENT_WUTONG_DRIVER_NOT_EXISTS(90034, "当前梧桐司机不存在"),
    A_DRIVER_CODE_ALREADY_EXISTS(90035, "A端司机编号已经被添加"),
    FAILED_TO_EDIT_DRIVER_LABEL(90036, "编辑司机标签失败，driverId不存在"),
    FAILED_TO_CALL_SELF_CARRIAGE_CANCEL_DRIVER_LABEL_INTERFACE(90037, "编辑司机标签异常, 调用自承运取消司机标签接口失败"),
    INTERVIEWED_OR_DEALED_CLUE_NOT_SUPPORT_TO_ASSIGN(90038, "不支持已面试、已成交线索分配，请再次确认"),
    INTERVIEWED_TIME_MUST_GREATER_THAN_CURRENT_TIME(90039, "面试时间必须大于当前时间"),
    SUCH_CLUE_NOT_INVITE_TO_INTERVIEW_OR_CAN_NOT_CANCEL_INTERVIEW(90040, "该线索没有邀约面试，不可以取消面试"),
    ERROR_VERFICATION_CODE(90041, "验证码错误，请重新输入"),
    FAILED_TO_GENERATE_USER_INFORMATION(90042, "openId重复！无法生成用户信息"),
    FAILED_TO_QUERY_SUCH_USER_BY_USEID(90043, "根据编号未查询到用户"),
    CURRENT_ROLE_NO_ACCESS_TO_GENERATE_QRCODE(90044, "当前角色无生成二维码权限"),

    NOT_CURRENT_CITY_CANCEL(90045, "非本城撮合成功不可取消意向"),
    OUT_OF_ONLINE_DATE(90046, "已过上架截止日期，更新撮合单和客邀单状态失败"),
    MATCH_STATUS_NOT_MATCH(90047, "只有撮合成功状态，才能取消试跑意向")


    ;


    private Integer code;
    private String message;

    ErrorMessageEnum(Integer code, String message) {
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
