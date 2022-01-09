package com.hyman.common.enums.waybill;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

/**
 * 司撮取消试跑原因
 * @author LiuJu
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum MatchIntentionFailureReasonEnum {
    DRIVER_TIME_FAIL(1, "司机时间有冲突"),
    CAR_FAIL(2, "车辆故障"),
    DRIVER_REASON(3, "司机个人原因请假"),
    PRICE_REASON(4, "价格不合适"),
    OTHER_WORK(5, "有其他活"),
    OTHER(6, "其他"),
    ;

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
    public static MatchIntentionFailureReasonEnum getByValue(int value) {
        return Arrays.stream(values()).filter(e -> value == e.code).findAny().orElse(null);
    }
}
