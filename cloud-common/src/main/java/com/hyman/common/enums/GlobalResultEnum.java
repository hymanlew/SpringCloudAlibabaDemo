package com.hyman.common.enums;

/**
 * @author:
 * @create: 2019-03-24
 * @description:
 **/
public enum GlobalResultEnum {
    GENERATE_ID_ERROR(2015501, "生成司机id 失败"),
    FEIGN_BASE_ERROR(2015502, "远程调用Base工程 失败"),
    CONVERT_BASE_ERROR(2015503, "编码转译中文 失败");

    private Integer errorCode;
    private String errorMsg;

    GlobalResultEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
