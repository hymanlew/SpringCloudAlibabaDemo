package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2019/3/21 13:55
 * @Description:
 */
@ApiModel(value = "com.hyman.common.model.dto.match.ChooseDriverVO", description = "选择司机返回数据")
@Data
@Builder
public class ChooseDriverDTO implements Serializable {
    private static final long serialVersionUID = -1324469166098551496L;

    @ApiModelProperty(value = "司机id")
    private String driverId;

    @ApiModelProperty(value = "标书id")
    private String tenderId;

    @ApiModelProperty(value = "成功与否标识")
    private Boolean flag;

}
