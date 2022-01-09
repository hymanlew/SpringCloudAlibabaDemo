package com.hyman.common.enums.match;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

/**
 * @description: 即时撮合临时线路的状态
 * @author: hyman
 * @date: 2020/5/29
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TemMatchLineStateEnum {

    NOT_COMPLETE(1, "未完成"),
    WORK(2, "已撮合"),
    FAILURE(3, "已失效");

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
    public static TemMatchLineStateEnum getByValue(int value) {
        return Arrays.stream(values()).filter(e -> value == e.code).findAny().orElse(null);
    }

}
