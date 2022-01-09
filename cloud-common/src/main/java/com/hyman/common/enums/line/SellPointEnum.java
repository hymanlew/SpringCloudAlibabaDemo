package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName SellPointEnum
 * @Description 卖点枚举
 * @Author shiyunlong
 * @Date 2021/3/9 11:19
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum  SellPointEnum {

    LINE_SELL_POINT(1, "selling_points"),
    PROJECT_SELL_POINT(2, "selling_points_project");

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
}
