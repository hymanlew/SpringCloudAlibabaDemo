package com.hyman.common.enums.waybill;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author wanghaitong
 */
@Getter
public enum WayBillAutoConfirmStatusEnum {
    /**
     * 自动单边确认状态
     */
    INIT("初始", 0),
    EXECUTING("处理中", 1),
    SUCCESS("成功", 2),
    FAILURE("失败", 3),
    VALID_FAILURE("业务异常，不重试", 4),
    ;
    private String name;
    private Integer code;

    WayBillAutoConfirmStatusEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static WayBillAutoConfirmStatusEnum getByCode(Integer code) {
        if (code != null) {
            for (WayBillAutoConfirmStatusEnum anEnum : values()) {
                if (code.intValue() == anEnum.code) {
                    return anEnum;
                }
            }
        }
        throw new IllegalArgumentException(StrUtil.format("不支持的类型：{}", code));
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (WayBillAutoConfirmStatusEnum wayBillStatusEnum : values()) {
                if (code.intValue() == wayBillStatusEnum.code) {
                    return wayBillStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
