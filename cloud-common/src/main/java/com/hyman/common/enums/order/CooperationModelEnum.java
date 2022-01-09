package com.hyman.common.enums.order;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @description:
 * @author: hyman
 * @date: 2020/7/9
 */
@Getter
public enum CooperationModelEnum {
    /**
     * 合作模式
     */
    BUY("购车", 1),
    RENT("租车", 2),
    WITH("带车", 3);

    private String Name;
    private Integer code;

    CooperationModelEnum(String Name, Integer code) {
        this.Name = Name;
        this.code = code;
    }


    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (CooperationModelEnum contractStatusEnum : values()) {
                if (code.intValue() == contractStatusEnum.code) {
                    return contractStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
