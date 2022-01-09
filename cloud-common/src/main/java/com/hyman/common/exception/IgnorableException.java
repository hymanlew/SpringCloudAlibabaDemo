package com.hyman.common.exception;

import lombok.Getter;

/**
 * 可忽略的异常，用于需要抛出异常让事务回滚但又不需要打印错误日志的场景
 *
 * @author Haitong Wang
 */
@Getter
public class IgnorableException extends RuntimeException {
    private int status = 500;
    private final String message;

    public IgnorableException(String message){
        super(message);
        this.message = message;
    }

    public IgnorableException(int status, String message){
        super(message);
        this.message = message;
        this.status = status;
    }
}
