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
public class DriverInterViewSearchFORM  implements Serializable {

    private static final long serialVersionUID = -6914825788392050454L;

    /**
     * 数据库集合
     */
    @ApiModelProperty("参数集合")
    @NotNull(message = "数据集合不为空")
    private List<DriverInterViewFORM> data;
}
