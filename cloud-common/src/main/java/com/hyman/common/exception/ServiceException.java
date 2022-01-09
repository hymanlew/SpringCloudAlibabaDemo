package com.hyman.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

/**
 * Created by tianc on 2018/9/13.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ServiceException extends RuntimeException {
    private Integer errorCode;
    private String errorMsg;

    public ServiceException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
