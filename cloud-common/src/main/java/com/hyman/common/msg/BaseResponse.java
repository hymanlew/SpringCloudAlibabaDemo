package com.hyman.common.msg;

/**
 * @Author
 * @Date: 2018/3.4/28 16:19
 * @Description:
 */
public class BaseResponse {
    private int code = 200;
    private String message;

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
