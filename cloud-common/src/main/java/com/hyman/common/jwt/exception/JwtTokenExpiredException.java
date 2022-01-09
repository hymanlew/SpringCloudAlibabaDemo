package com.hyman.common.jwt.exception;

/**
 * @Author
 * @Date: 2018/3.4/28 16:19
 * @Description:
 */
public class JwtTokenExpiredException extends Exception {
    public JwtTokenExpiredException(String s) {
        super(s);
    }
}
