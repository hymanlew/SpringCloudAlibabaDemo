package com.hyman.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author
 * @Date: 2018/5/30 17:15
 * @Description:
 */
@Data
public class LocItem {
    @ApiModelProperty(value = "编码")
    String code;
    @ApiModelProperty(value = "名称")
    String name;
    @ApiModelProperty(value = "名称简写")
    String shortName;
    @ApiModelProperty(value = "名称")
    String enName;
    @ApiModelProperty(value = "子项")
    List<LocItem> children;

    public LocItem() {
    }

    public LocItem(String code, String name,String shortName,String enName) {
        this.code = code;
        this.name = name;
        this.shortName = shortName;
        this.enName = enName;
    }
}
