package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author:
 * @create: 2019-04-11
 * @description: 标书下线，司机状态修改提交form
 **/
@Data
@ToString
@ApiModel("标书下线，司机状态修改提交form")
public class BidDownUpdateDriverStateForm {

    @ApiModelProperty(value = "司机编号")
    @NotBlank(message = "司机编号不能为空")
    @Length(min = 0, max = 32, message = "司机编号长度必须介于 0 和 32 之间")
    private String driverId;

    @ApiModelProperty(value = "标书下线，司机状态改变所需要的信息")
    private List<DriverDownFromLine> driverDownFromLines;

}
