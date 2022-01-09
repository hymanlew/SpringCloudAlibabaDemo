package com.hyman.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: hyman
 * @Date: 2018/7/6 11:13
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysCodeList {
    @ApiModelProperty(value = "字典编码")
    String code;
    @ApiModelProperty(value = "字典值")
    List<SysCode> data;
}
