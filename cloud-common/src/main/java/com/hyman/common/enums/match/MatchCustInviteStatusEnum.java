package com.hyman.common.enums.match;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

/**
 * @description: 客邀单状态枚举
 * @author: yzy
 * @date: 2021/05/05
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum MatchCustInviteStatusEnum {
    MATCH_CUST_INVITE_WAITED(1, "未发起客邀"),
    MATCH_CUST_INVITE_ALREADY(2, "已发起客邀"),
    MATCH_CUST_INVITE_NOT(3, "不可发起客邀");

    private Integer code;
    private String value;

    /**
     * 根据枚举code获取枚举value
     *
     * @param code 枚举code
     * @return
     */
    public static String getValueByCode(@NotNull Integer code) {
        return Objects.isNull(code) ? StringUtils.EMPTY : Arrays.stream(values()).filter(e -> code == e.code).map(e -> e.value).findAny().orElse(StringUtils.EMPTY);
    }

    /**
     * 获取枚举类实例
     *
     * @param value 枚举value
     * @return
     */
    public static MatchCustInviteStatusEnum getByValue(int value) {
        return Arrays.stream(values()).filter(e -> value == e.code).findAny().orElse(null);
    }
}
