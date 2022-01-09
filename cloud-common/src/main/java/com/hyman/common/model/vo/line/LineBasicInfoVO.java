package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by tc on 2019/5/17.
 */
@Data
@ApiModel("线路基本信息对象")
public class LineBasicInfoVO {

    @ApiModelProperty(value = "线路编号")
    private String lineId;

    @ApiModelProperty(value = "线路名称")
    private String lineName;

//    @ApiModelProperty(value = "仓库位置")
//    private String warehouse;

    @ApiModelProperty(value = "仓库位置-省")
    private Integer warehouseProvince;

    @ApiModelProperty(value = "仓库位置-市")
    private Integer warehouseCity;

    @ApiModelProperty(value = "仓库位置-区、县")
    private Integer warehouseCounty;

    @ApiModelProperty(value = "仓库位置-省")
    private String warehouseProvinceName;

    @ApiModelProperty(value = "仓库位置-市")
    private String warehouseCityName;

    @ApiModelProperty(value = "仓库位置-区、县")
    private String warehouseCountyName;

    @ApiModelProperty(value = "仓库位置-具体位置")
    private String warehouseDistrict;


    @ApiModelProperty(value = "具体线路区域范围")
    private String districtArea;

    @ApiModelProperty(value = "已发布标书数量")
    private Integer publishedBidsNum;

    @ApiModelProperty(value = "可以发布的线路数量")
    private Integer deployNum;

}
