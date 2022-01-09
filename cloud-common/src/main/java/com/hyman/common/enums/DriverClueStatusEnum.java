package com.hyman.common.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author Changyuan Su
 * @date 2020/7/7 下午4:16
 * @Description: 司机线索状态枚举
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DriverClueStatusEnum {


    TOBE_ALLOCATED(1, "待分配"),
    TOBE_FOLLOWED_UP(2, "待跟进"),
    FOLLOWING_UP(3, "跟进中"),
    INTERVIEWED(4, "已面试"),
    COMPLETED(5, "已成交"),
    ABANDONED(6, "已放弃");

    private final int value;

    private final String desc;

    public static DriverClueStatusEnum getByValue(int value) {
        return Arrays.stream(values()).filter(e -> e.value == value).findAny().get();
    }


}
