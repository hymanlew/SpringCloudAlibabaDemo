package com.hyman.common.enums.line;

import com.hyman.common.util.qiyuesuosdk.lang.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * 拒绝原因类型
 **/
@Getter
public enum LineShelfRejectionReasonsType {
    DEFAULT(0, "默认"),
    MEDIA_CURATORIAL_INFORMATION(1, "项目策展信息"),
    LINE_INFORMATION(2, "线路基础信息"),
    All(3, "项目策展信息、线路基础信息");


    LineShelfRejectionReasonsType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

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
        if (code != null) {
            for (LineShelfRejectionReasonsType lineShelfRejectionReasonsType : values()) {
                if (code.equals(lineShelfRejectionReasonsType.code)) {
                    return lineShelfRejectionReasonsType.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
