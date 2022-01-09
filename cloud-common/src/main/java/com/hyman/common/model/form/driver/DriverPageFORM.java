package com.hyman.common.model.form.driver;

import com.hyman.common.vo.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * desc.
 *
 * @author oujunting
 * @date 2021/05/13
 */
@Data
@ApiModel("司机分页实体")
public class DriverPageFORM extends PageQuery implements Serializable {

    @ApiModelProperty("多个司机ID")
    private List<String> driverIds;

    @ApiModelProperty("筛选状态")
    private List<Integer> statusList;
}
