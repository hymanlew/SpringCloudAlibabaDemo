package com.hyman.common.enums.core;

/**
 * 导出下载文件类型
 * Created by tianc on 2019/9/16.
 */
public enum ExportDownFileTypeEnum {
    DRIVER_PORTRAIT(1, "司机画像"),
    LINE_LIST(2, "线路列表"),
    ORDER_LIST(3, "订单列表"),
    DRIVER_LIST(4, "司机列表"),
    LINE_GMV_LIST(5, "线路GMV"),
    CUSTOMER_LIST(6, "货主列表"),
    DRIVER_LABEL_LIST(7, "自承运免抽佣、免押金标签"),
    CONTRACT(8, "电子合同"),
    IMPORT_REJECTED_DRIVER_CLUE_LIST(9, "拒绝导入的司机线索列表"),
    ;


    private Integer code;
    private String name;

    ExportDownFileTypeEnum(Integer code, String name) {
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
