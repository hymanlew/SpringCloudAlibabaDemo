package com.hyman.common.enums.line;

import lombok.Getter;

/**
 * @Author:zhanglichao
 * @Date:2021/5/8 11:01
 * @Description:
 */
@Getter
public enum LineManagerVisitProjectStatusEnum {
    NORMAL(0, "未删除"),
    DELETE(1, "已删除");

    private Integer code;

    private String value;

    LineManagerVisitProjectStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
