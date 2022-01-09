package com.hyman.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author
 * @Date: 2018/5/8 17:18
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
public class SqlRuntimeException extends RuntimeException {
    private int status = 500;
    private String message;

    public SqlRuntimeException(String message){
        super(message);
        this.message = message;
    }

    public SqlRuntimeException(int status,String message){
        super(message);
        this.message = message;
        this.status = status;
    }
}
