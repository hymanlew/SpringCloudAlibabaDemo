package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2020/3/8 14:28
 * @Description:
 */
@ApiModel("司机信息")
@Data
public class PartDriverInfoDTO implements Serializable {
    private static final long serialVersionUID = -1867338813158278122L;

    /**
     * 司机名称
     */
    @ApiModelProperty(value = "司机名称")
    private String name;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 意向车型
     */
    @ApiModelProperty(value = "意向车型")
    private Integer carType;

    /**
     * 意向车型
     */
    @ApiModelProperty(value = "意向车型[中文]")
    private String carTypeName;

    private String phone;


    /**
     * 工作城市
     */
    @ApiModelProperty(value = "工作城市")
    private Integer workCity;


    private String cityName;

    @ApiModelProperty(value = "货物经验")
    private String cargoType;

    @ApiModelProperty(value = "货物经验")
    private String cargoTypeName;

    @ApiModelProperty(value = "司机类型")
    private Integer driverType;

}
