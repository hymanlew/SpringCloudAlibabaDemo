package com.hyman.common.model.form.waybill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author oujunting
 * @date 2021/5/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("司机标签同步参数")
public class DriverLabelSynFORM {

    @ApiModelProperty(value = "是否全量同步")
    @NotNull(message = "同步方式不能为空")
    private boolean synAll;

    @ApiModelProperty(value = "司机编码")
    private List<String> driverIds;

}
