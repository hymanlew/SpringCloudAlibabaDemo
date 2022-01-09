package com.hyman.common.enums.waybill;

/**
 * 运费账户的流水状态
 *
 * @author wanghaitong
 * @date 2020/10/9 11:03
 */
public enum AcctBusinessRecordStatusEnum {
    /**
     * 运费账户的流水状态
     */
    PROCESSING(1, "进行中"),
    SUCCESS(2, "成功"),
    FAILURE(3, "失败"),
    ;

    private final Integer code;
    private final String name;

    AcctBusinessRecordStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
