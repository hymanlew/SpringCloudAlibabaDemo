package com.hyman.common.enums.line;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Authorzhanglichao
 * @Date 2021-05-10 10:57
 * @description 项目是否拜访枚举类
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ProjectIsVisitEnum {

    /**
     * 线路是否有余额枚举
     */
    IS_VISIT(1, "是"),
    NO_VISIT(2, "否");

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

    ProjectIsVisitEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }


    public static String getValueByCode(Integer code) {
        if (code != null) {
            for (ProjectIsVisitEnum projectIsVisitEnum : values()) {
                if (code.equals(projectIsVisitEnum.code)) {
                    return projectIsVisitEnum.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static ProjectIsVisitEnum getByValue(int value) {
        for (ProjectIsVisitEnum projectIsVisitEnum : values()) {
            if (projectIsVisitEnum.getCode() == value) {
                return projectIsVisitEnum;
            }
        }
        return null;
    }
}
