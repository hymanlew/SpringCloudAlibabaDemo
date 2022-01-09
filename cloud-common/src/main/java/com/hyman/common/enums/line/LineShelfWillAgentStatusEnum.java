package com.hyman.common.enums.line;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author shiyunlong
 * @Date 2021/4/17 9:41
 * @Description 即将到期待办处理状态枚举
 **/
@Getter
public enum LineShelfWillAgentStatusEnum {

    DEFAULT(0, "待处理"),
    EDITED(1, "已编辑"),
    IGNORE(2, "忽略");

    private int code;
    private String value;

    LineShelfWillAgentStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (LineShelfWillAgentStatusEnum lineShelfWillAgentStatusEnum : values()) {
                if (code.equals(lineShelfWillAgentStatusEnum.getCode())) {
                    return lineShelfWillAgentStatusEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
