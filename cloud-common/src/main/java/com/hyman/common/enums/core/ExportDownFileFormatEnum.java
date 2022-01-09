package com.hyman.common.enums.core;

/**
 * 导出下载文件格式
 * Created by tianc on 2019/9/16.
 */
public enum ExportDownFileFormatEnum {
    CSV(1, "CSV"),
    EXCEL(2, "EXCEL"),
    PDF(3, "PDF"),
    TXT(4, "TXT"),
    WORD(5, "WORD");

    private Integer code;
    private String name;

    ExportDownFileFormatEnum(Integer code, String name) {
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
