package com.hyman.common.enums.match;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author LiuJu
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum MatchTypeByRunTestEnum {
    DRIVER(1, "司推系"),
    LINE(2, "客邀系");

    private Integer code;
    private String value;

    /**
     * 根据枚举code获取枚举value
     *
     * @param code 枚举code
     * @return
     */
    public static String getValueByCode(@NotNull Integer code) {
        return Objects.isNull(code) ? StringUtils.EMPTY : Arrays.stream(values()).filter(e -> Objects.equals(code, e.code)).map(e -> e.value).findAny().orElse(StringUtils.EMPTY);
    }

    /**
     * 获取枚举类实例
     *
     * @param value 枚举value
     * @return
     */
    public static MatchTypeByRunTestEnum getByValue(int value) {
        return Arrays.stream(values()).filter(e -> value == e.code).findAny().orElse(null);
    }
}
