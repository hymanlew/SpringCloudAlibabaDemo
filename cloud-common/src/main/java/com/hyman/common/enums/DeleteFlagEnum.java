package com.hyman.common.enums;

import lombok.Getter;

/**
 * @description: 逻辑删除状态
 * @author: hyman
 * @date: 2020/5/28
 */
@Getter
public enum DeleteFlagEnum {
    /**
     * 存在
     */
    NORMAL(1),
    /**
     * 已经删除
     */
    DELETE(0);

    private int status;

    DeleteFlagEnum(int status) {
        this.status = status;
    }
}
