package com.hyman.common.enums.waybill;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyman
 * @description: 运单状态
 * @createTime: 2020/8/27
 */
@Getter
public enum WayBillStatusEnum {
    /**
     * 运单状态
     */
    INIT("初始化",0),
    NOT_REPORTED("待上报", 5),
    TO_BE_CONFIRMED("待单边确认", 10),
    CONFIRMED("单边已确认", 20),
    SECOND_TO_BE_CONFIRMED("待交叉确认", 30),
    SECOND_CONFIRMED("已交叉确认", 40);

    private String name;
    private Integer code;

    WayBillStatusEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static WayBillStatusEnum getByCode(Integer code) {
        if (code != null) {
            for (WayBillStatusEnum anEnum : values()) {
                if (code.intValue() == anEnum.code) {
                    return anEnum;
                }
            }
        }
        throw new IllegalArgumentException(StrUtil.format("不支持的类型：{}", code));
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (WayBillStatusEnum wayBillStatusEnum : values()) {
                if (code.intValue() == wayBillStatusEnum.code) {
                    return wayBillStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
