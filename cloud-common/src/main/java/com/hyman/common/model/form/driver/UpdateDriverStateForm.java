package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author:
 * @create: 2019-04-12
 * @description: 司机状态修改更新form
 **/
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("司机状态修改更新form")
public class UpdateDriverStateForm implements Serializable {

    private static final long serialVersionUID = 7830269245148025255L;

    @ApiModelProperty(value = "司机编号")
    @NotBlank(message = "司机编号不能为空")
    @Length(min = 0, max = 32, message = "司机编号长度必须介于 0 和 32 之间")
    private String driverId;

    @ApiModelProperty(value = "司机状态")
    private Integer state;
}
