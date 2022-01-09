package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Changyuan Su
 * @date 2019/4/15 10:40
 * @Description: 线路状态枚举类
 */
@Getter
@AllArgsConstructor
public enum LineTaskStatusEnum {

    WAIT_APPLY(1, "待审核"),
    APPLY_NOT_PASS(3, "审核未通过"),
    APPLY_PASS(2, "审核通过"),
    TO_BE_CONFIRMED(4, "待确认");

    /**
     * 对用于字典中的 键值
     */
    @ApiModelProperty("编码值")
    private int code;

    /**
     * 对用于字典 标签
     */
    @ApiModelProperty("编码对应的value")
    private String value;

    /**
     * 根据code值获取中文名
     *
     * @param code
     * @return
     */
    public static String getValueByCode(Integer code) {
        if (Objects.isNull(code)) {
            return StringUtils.EMPTY;
        }
        return Arrays.stream(values()).filter(e -> code == e.code).map(e -> e.value).findAny().orElse(StringUtils.EMPTY);
    }

    public static LineTaskStatusEnum getByValue(int value) {
        for (LineTaskStatusEnum lineTaskStatusEnum : values()) {
            if (lineTaskStatusEnum.getCode() == value) {
                return lineTaskStatusEnum;
            }
        }
        return null;
    }


}
