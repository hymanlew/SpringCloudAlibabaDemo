package com.hyman.common.enums.line;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author:zhaoxiaokang
 * @Date:2021/3/23 9:58
 * @Description: 冗余线路待办状态
 */
@Getter
public enum LineShelfAgentStatusEnum {
    DEFAULT(0, "待处理"),
    REMOVE_SHELVES(1, "已下架"),
    IGNORE(2, "忽略");

    private int code;
    private String value;

    LineShelfAgentStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (LineShelfAgentStatusEnum lineShelfAgentStatusEnum : values()) {
                if (code.equals(lineShelfAgentStatusEnum.getCode())) {
                    return lineShelfAgentStatusEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
