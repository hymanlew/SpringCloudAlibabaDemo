package com.hyman.common.enums.waybill;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运费流水操作类型枚举
 *
 * @author wanghaitong
 * @date 2020/9/30 10:47
 */
public enum OpTypeEnum {

    /**
     * 运费流水操作类型
     */
    CONFIRMATION(1, "运费确认"),
    INITIALIZATION(2, "运费初始化"),
    ADJUSTMENT(3, "运费调整"),
    DATA_REPAIR(4, "数据迁移"),
    ;

    private final Integer code;
    private final String name;

    OpTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 根据code换name
     *
     * @param code
     * @return
     */
    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (OpTypeEnum shippingSubjectEnum : values()) {
                if (code.intValue() == shippingSubjectEnum.code) {
                    return shippingSubjectEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * 根据code换枚举
     *
     * @param code
     * @return
     */
    public static OpTypeEnum getEnum(Integer code) {
        if (code != null) {
            for (OpTypeEnum shippingSubjectEnum : values()) {
                if (code.intValue() == shippingSubjectEnum.code) {
                    return shippingSubjectEnum;
                }
            }
        }
        return null;
    }

    public static List<Map<String, String>> getDict() {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        HashMap<String, String> map;
        for (OpTypeEnum value : OpTypeEnum.values()) {
            map = new HashMap<>(2);
            map.put("code", String.valueOf(value.getCode()));
            map.put("name", value.getName());
            list.add(map);
        }
        return list;
    }

}
