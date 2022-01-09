package com.hyman.common.enums.order;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: 创建来源
 * @author: hyman
 * @date: 2020/7/9
 */
@Getter
public enum CreateSourceEnum {
    /**
     * 创建来源
     */
    WEB("WEB", 1),
    XIQUE("喜鹊小程序", 2),
    YUNQUE("云雀小程序", 3);

    private String Name;
    private Integer code;

    CreateSourceEnum(String Name, Integer code) {
        this.Name = Name;
        this.code = code;
    }


    public static String getNameByCode(Integer code) {
        if (code != null) {
            for (CreateSourceEnum contractStatusEnum : values()) {
                if (code.intValue() == contractStatusEnum.code) {
                    return contractStatusEnum.getName();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
