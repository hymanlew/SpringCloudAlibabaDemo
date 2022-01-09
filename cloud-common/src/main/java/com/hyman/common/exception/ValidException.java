package com.hyman.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * @Date: 2018/5/17 11:01
 * @Description:    验证失败异常
 */
@Getter
@Setter
public class ValidException extends RuntimeException {
    private int status = 500;
    private String message;

    public ValidException(String message){
        super(message);
        this.message = message;
    }

    public ValidException(int status,String message){
        super(message);
        this.message = message;
        this.status = status;
    }
}
