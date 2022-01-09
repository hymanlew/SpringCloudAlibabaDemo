package com.hyman.common.enums.line;

import com.hyman.common.util.qiyuesuosdk.lang.StringUtils;
import lombok.Getter;

@Getter
public enum LineShelAgentStatusTypeEnum {
    REMOVE_SHELVES(1, "已下架"),
    IGNORE(2, "忽略"),
    ALL(3, "全部");


    private int code;
    private String value;

    LineShelAgentStatusTypeEnum(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (LineShelAgentStatusTypeEnum lineShelAgentStatusType : values()) {
                if (code.equals(lineShelAgentStatusType.code)) {
                    return lineShelAgentStatusType.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static LineShelAgentStatusTypeEnum getByValue(int value) {
        for (LineShelAgentStatusTypeEnum lineShelAgentStatusType : values()) {
            if (lineShelAgentStatusType.getCode() == value) {
                return lineShelAgentStatusType;
            }
        }
        return null;
    }
}
