package com.hyman.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: hyman
 * @Date: 2018/5/9 11:29
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysCode {
    @ApiModelProperty(value = "编码类型")
    private String type;
    @ApiModelProperty(value = "编码提交值")
    private String code;
    @ApiModelProperty(value = "编码显示值")
    private String codeVal;
    @ApiModelProperty(value = "编码备注")
    private String memo;
    @ApiModelProperty(value = "编码排序值")
    private Float sort;

//    public SysCode(String code, String codeVal){
//        this.code = code;
//        this.codeVal = codeVal;
//    }

}


