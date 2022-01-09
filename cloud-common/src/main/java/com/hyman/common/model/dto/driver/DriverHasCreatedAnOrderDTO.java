package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-09-19
 * @description: 内部调用，定时调度，判断司机30天内有无创建订单
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("内部调用，定时调度，判断司机30天内有无创建订单")
@ToString
public class DriverHasCreatedAnOrderDTO implements Serializable {

    private static final long serialVersionUID = 2386557392130834315L;

    @ApiModelProperty(value = "司机编号")
    private String driverId;

    @ApiModelProperty(value = "面试时间")
    private String interviewTimeStr;

}
