package com.hyman.common.enums.core;

/**
 * 导出下载记录状态
 * Created by tianc on 2019/9/16.
 */
public enum ExportDownStatusEnum {
    WAIT(1, "待处理"),
    ONGOING(2, "处理中"),
    SUCCESS(3, "成功"),
    FAIL(4, "失败");

    private Integer code;
    private String name;

    ExportDownStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
