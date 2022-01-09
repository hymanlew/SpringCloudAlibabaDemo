package com.hyman.common.cache;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2020/12/1 下午1:11
 * @Description: 司机缓存信息
 */
@Data
public class DriverCacheInfo implements Serializable {
    private static final long serialVersionUID = -576533288507191691L;

    private String driverId;

    @ApiModelProperty(value = "业务类型code")
    private Integer busiType;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "城市code")
    private Integer workCity;
    
    @ApiModelProperty(value = "城市Name")
    private String workCityName;

    @ApiModelProperty(value = "状态code")
    private Integer status;

    @ApiModelProperty(value = "加盟经理id")
    private Long gmId;

    @ApiModelProperty(value = "撮合经理id")
    private Integer dmId;

    @ApiModelProperty(value="车型code")
    private Integer carType;

}
