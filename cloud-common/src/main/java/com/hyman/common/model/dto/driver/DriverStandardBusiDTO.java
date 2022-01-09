package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yantao
 * @Param
 * @Return
 * @Date 2020/7/9 11:21
 * @Describe ©
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("司机标准返回值")
public class DriverStandardBusiDTO implements Serializable {

    private static final long serialVersionUID = 5518031628323989663L;

    @ApiModelProperty(value = "返回标记")
    private boolean flag;

    @ApiModelProperty(value = "返回内容")
    private String msg;
}
