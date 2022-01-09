package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Changyuan Su
 * @date 2020/5/25 下午7:43
 * @Description:
 */
@ApiModel("删除司机线路匹配度DTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDriverLineMatchRateDTO implements Serializable {
    private static final long serialVersionUID = 3649735054000220034L;

    @ApiModelProperty("司机ids")
    private Collection<String> driverIds;

    @ApiModelProperty("线路ids")
    private Collection<String> lineIds;

}
