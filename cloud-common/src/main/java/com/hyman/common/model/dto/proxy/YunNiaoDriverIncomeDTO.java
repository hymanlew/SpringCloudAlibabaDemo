package com.hyman.common.model.dto.proxy;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:
 * @create: 2019-06-21
 * @description: 云鸟司机收入对象
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YunNiaoDriverIncomeDTO implements Serializable {

    private static final long serialVersionUID = 8889049508241821642L;

    @ApiModelProperty(value = "司机id【这里是七只鸟系统的司机id】")
    private String driverId;

    @ApiModelProperty(value = "第三方司机id【这里是云鸟端司机id】")
    private String thirdDriverId;

    @ApiModelProperty(value = "货主id【这里是云鸟端货主id】")
    private String goodsOwnerId;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

}
