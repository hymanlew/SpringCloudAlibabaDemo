package com.hyman.common.enums;

/**
 * Created by tc on 2018/11/2.
 */
public enum SmsTemplateEnum {
    PHONE_VERIFICATION_CODE("special.wt_special_id_verify", "手机验证码<专车>"),
    PHONE_VERIFICATION_CODE_SHARE("share.wt_share_id_verify", "手机验证码<共享>"),
    XIQUE_ORDER_CONTRACT_CREATE("special.wt_special_order_complete_contract_signed_remind", "喜鹊创建订单发送签署合同提醒<专车>"),
    YUNQUE_ORDER_CONTRACT_CREATE("share.wt_share_order_complete_contract_signed_remind", "云雀创建订单发送签署合同提醒<共享>"),
    XIQUE_ORDER_CONTRACT_COMPLETE("special.wt_special_contract_complete", "喜鹊合同签署完成提醒<专车>"),
    YUNQUE_ORDER_CONTRACT_CONPLETE("share.wt_share_contract_complete", "云雀签署完成提醒<共享>"),
    WUTO_PLATEFORM_DEAL_WITH_TRY_RUN("wutongplatform.deal_with_try_run", "梧桐平台通知上岗经理处理试跑意向"),
    MARK_CLUE_INTERVIEW_APPOINT_SUCCESS("dahanyunniao.interview_appoint_success", "市场部线索-私海池-邀约成功"),
    MARK_CLUE_INTERVIWE_APPOINT_FAIL("dahanyunniao.congratulation_join_yunniao", "市场部线索-私海池-邀约失败"),
    MARK_CLUE_FIRST_INVITE_FAIL("dahanyunniao.information_audit_passed", "市场部线索-私海池-首邀未联系上"),
    LEI_NIAO_CAR_LOGIN_SEND_CIDE("leiniao.leiniao_verify","雷鸟小程序登录获取验证码")
    ;

    private String code;
    private String name;

    SmsTemplateEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
