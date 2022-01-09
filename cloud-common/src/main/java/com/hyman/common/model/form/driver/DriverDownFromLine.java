package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author:
 * @create: 2019-04-12
 * @description: 标书下线，司机状态改变所需要的信息
 **/
@Data
@ToString
@ApiModel("标书下线，司机状态改变所需要的信息")
public class DriverDownFromLine {

    @ApiModelProperty(value = "标书编号")
    @NotBlank(message = "标书编号不能为空")
    @Length(min = 0, max = 32, message = "标书编号长度必须介于 0 和 32 之间")
    private String bidId;

    @ApiModelProperty(value = "线路编号")
    @NotBlank(message = "线路编号不能为空")
    @Length(min = 0, max = 32, message = "线路编号长度必须介于 0 和 32 之间")
    private String lineId;

    @ApiModelProperty(value = "客户编号")
    private String customerId;

    @ApiModelProperty(value = "合同起始时间")
    private Date contractStart;

    @ApiModelProperty(value = "合同截止时间")
    private Date contractEnd;

    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "标书状态")
    private Integer state;


}
