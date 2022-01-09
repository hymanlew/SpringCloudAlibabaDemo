package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-03-20
 * @description: 司机标准返回值
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("司机标准返回值")
public class DriverStandardDTO implements Serializable {

    private static final long serialVersionUID = -559344786651069119L;
    @ApiModelProperty(value = "返回标记")
    private boolean flag;

    @ApiModelProperty(value = "返回内容")
    private String msg;
}
