package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Changyuan Su
 * @date 2019/9/18 17:06
 * @Description: 客户线索跟进状态枚举
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LineCustomerClueStateEnum {

    WAIT_FOLLOW(1, "待跟进"),
    FOLLOWING(2, "跟进中"),
    DEAL_DONE(3, "已成交");

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

    public static String getValueByCode(Integer code) {
        if (Objects.isNull(code)) {
            return StringUtils.EMPTY;
        }
        return Arrays.stream(values()).filter(e -> code == e.code).map(e -> e.value).findAny().orElse(StringUtils.EMPTY);
    }

}
