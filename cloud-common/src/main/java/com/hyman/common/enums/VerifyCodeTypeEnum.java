package com.hyman.common.enums;

/**
 * Created by tc on 2019/5/27.
 */
public enum VerifyCodeTypeEnum {
    SIGN_IN("SIGN_IN", "登录验证码"),
    CASH_OUT("CASH_OUT", "余额提现验证码"),;

    private String code;
    private String value;

    VerifyCodeTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
