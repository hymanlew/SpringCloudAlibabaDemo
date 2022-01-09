package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
/**
 * desc.
 *
 * @author oujunting
 * @date 2021/05/14
 */
@Data
public class DriverLabelInfoFORM implements Serializable {

    private static final long serialVersionUID = -2616039583279647106L;
    /**
     * 司机编码
     */
    @ApiModelProperty("司机编码")
    @NotNull(message = "司机编码不为空")
    List<String> driverIds;
}
