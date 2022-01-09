package com.hyman.common.enums;

import lombok.Getter;

/**
 * description: DelFlagEnum <br>
 * date: 2020/7/14 17:56 <br>
 * author: hyman <br>
 */
@Getter
public enum DelFlagEnum {

    NORMAL(0,"正常"),DELETE(1,"删除");

    Integer code;
    String value;
    DelFlagEnum(int code, String value){
        this.code = code;
        this.value = value;
    }


    }
