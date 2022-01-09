package com.hyman.common.enums.waybill;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyman
 * @description: 加盟侧和线路侧运单状态
 * @createTime: 2020/8/27
 */
@Getter
public enum WayBillGMSaleStatusEnum {
    /**
     * 运单状态
     */
    NOT_REPORT("待上报", 0),
    REPORTED("已上报", 1),
    NO_CAR("未出车", 2);

    private String name;
    private Integer code;

    WayBillGMSaleStatusEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static WayBillGMSaleStatusEnum getByCode(Integer code) {
        if (code != null) {
            for (WayBillGMSaleStatusEnum anEnum : values()) {
                if (code.intValue() == anEnum.code) {
                    return anEnum;
                }
            }
        }
        throw new IllegalArgumentException(StrUtil.format("不支持的类型：{}", code));
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (WayBillGMSaleStatusEnum wayBillGMSaleStatusEnum : values()) {
                if (code.intValue() == wayBillGMSaleStatusEnum.code) {
                    return wayBillGMSaleStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
