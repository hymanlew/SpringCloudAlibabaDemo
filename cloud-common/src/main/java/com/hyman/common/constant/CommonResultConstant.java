package com.hyman.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by tianc on 18/9/14.
 */
@Getter
@AllArgsConstructor
public enum CommonResultConstant {

    VILAD_ERROR(400, "参数校验错误"),
    AUTH_ERROR(401, "权限不足, 请登录"),
    LOGIN_TIMEOUT(402, "登陆超时,请重新登陆"),

    FORBIDDEN(403, "请求被拒绝"),
    NOT_FOUND(404, "数据不存在"),
    METHOD_NOT_SUPPORT(405, "方法不支持"),

    INFO_UPDATE(406, "您的信息被修改，请重新登录"),
    NORMAL(200, "正常"),
    SQUEEZE_OUT(407, "您的账号被其他人登录，请重新登录"),
    LOGIN_OVERDUE(408, "登陆状态已过期，请重新登录"),

    FILE_BIG_ERROR(413, "文件过大"),
    PARSE_ERROR(415, "解析错误"),
    SERRVER_ERROR(500, "内部错误"),

    ;

    private Integer errorCode;
    private String errorMsg;
}
