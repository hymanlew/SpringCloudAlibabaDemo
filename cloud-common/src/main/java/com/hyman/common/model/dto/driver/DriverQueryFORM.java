package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * 司机信息查询FORM
 *
 * @author hucl
 * @date 2021/5/10 11:44
 */
@Getter
@Setter
@ApiModel("司机信息查询FORM表单")
public class DriverQueryFORM {

    @ApiModelProperty(value = "司机撮合经理Id集合")
    private Set<Long> dmIds;

    @ApiModelProperty(value = "司机工作城市编码集合")
    private Set<Integer> cityCodes;

}
