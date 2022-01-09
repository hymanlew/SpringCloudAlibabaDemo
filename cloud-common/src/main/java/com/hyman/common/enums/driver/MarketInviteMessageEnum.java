package com.hyman.common.enums.driver;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyman
 * @description:
 * @createTime: 2021/3/8
 */
@Getter
public enum MarketInviteMessageEnum {
    /**
     * 市场部线索发送短信邀约情况枚举
     */
    INVITE_SUCCESS("邀约成功", 1),
    INVITE_FAIL("邀约失败", 2),
    FIRST_INVITE_NOT_LINK("首邀未联系上", 3);

    private String name;
    private Integer code;

    MarketInviteMessageEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (MarketInviteMessageEnum marketClueAllocationEnum : values()) {
                if (code.intValue() == marketClueAllocationEnum.code) {
                    return marketClueAllocationEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
