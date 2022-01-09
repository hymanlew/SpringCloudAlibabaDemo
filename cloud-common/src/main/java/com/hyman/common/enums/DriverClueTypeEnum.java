package com.hyman.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: tc
 * @create: 2019-04-25
 * @description: 司机线索类型
 **/
public enum DriverClueTypeEnum {
    INIT(0, "刚初始化数据"),

    AUTHORIZE(1, "用户授权"),
    RECOMMEND(2, "用户推荐"),
    SETTLED_IN(3, "立即入驻"),
    COLLECTION(4, "收藏"),
    BSS_CREATE(5, "BSS手动创建"),
    INTERVIEW_SYNC(6, "面试表同步");

    private Integer code;
    private String value;

    DriverClueTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (DriverClueTypeEnum driverStateEnum : values()) {
                if (code.equals(driverStateEnum.code)) {
                    return driverStateEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static DriverClueTypeEnum getByValue(int code) {
        for (DriverClueTypeEnum driverClueTypeEnum : values()) {
            if (driverClueTypeEnum.getCode() == code) {
                return driverClueTypeEnum;
            }
        }
        return null;
    }
}
