package com.hyman.common.enums.match;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author
 * @date 2020-04-12
 * @Description: 撮合大会 -> 撮合记录状态枚举
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DriverLineMatchHistoryStateEnum {

    MATCH(0, "促撮推荐司机"),
    PUSH(1, "推送"),
    SEEN(2, "看活"),
    TRY_RUN(3, "试跑"),
    ON_GUARD(4, "上岗"),
    FAILURE(5, "失败"),
    HAPPEN(6, "发起");

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
    public static DriverLineMatchHistoryStateEnum getByValue(int value) {
        return Arrays.stream(values()).filter(e -> value == e.code).findAny().orElse(null);
    }

}
