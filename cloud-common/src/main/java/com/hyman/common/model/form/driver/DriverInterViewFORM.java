package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * desc.
 *
 * @author oujunting
 * @date 2021/05/14
 */
@Data
public class DriverInterViewFORM implements Serializable{
    private static final long serialVersionUID = 3952530604888533515L;

    /**
     * 司机编码
     */
    @ApiModelProperty("司机编码")
    @NotNull(message = "司机编码不为空")
    private String driverId;

    /**
     * 业务类型(0专车1共享)
     */
    @ApiModelProperty("业务类型(0专车1共享)")
    @NotNull(message = "业务类型不为空")
    private Integer busiType;
}
