package com.hyman.common.model.vo.line;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName TestRunDetailsVO
 * @Description 线路试跑详情视图
 * @Author shiyunlong
 * @Date 2020/9/3 9:27
 */
@Data
public class TestRunDetailsVO {
    /**
     * 线路id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "线路id")
    private String lineId;

    /**
     * 线路状态
     */
    @ApiModelProperty(value = "线路状态")
    private String lineState;

    /**
     * 线路状态
     */
    @ApiModelProperty(value = "线路状态")
    private String lineStateName;


    /**
     * 线路名称
     */
    @ApiModelProperty(value = "线路名称")
    private String lineName;

    /**
     * 外线销售id
     */
    @ApiModelProperty(value = "外线销售id")
    private Integer lineSaleId;

    /**
     * 线路销售姓名+电话
     */
    @ApiModelProperty("线路销售姓名")
    private String lineSaleNamePhone;


    /**
     * 配送区域-省
     */
    @ApiModelProperty(value = "配送区域-省")
    private Integer provinceArea;

    /**
     * 配送区域-市
     */
    @ApiModelProperty(value = "配送区域-市")
    private Integer cityArea;

    /**
     * 配送区域-区、县
     */
    @ApiModelProperty(value = "配送区域-区、县")
    private Integer countyArea;

    /**
     * 配送省区域名称
     */
    @ApiModelProperty(value = "配送省区域名称")
    private String deliveryAreaName;

    /**
     * 仓位置-省
     */
    @ApiModelProperty("仓位置-省")
    private Integer warehouseProvince;

    /**
     * 仓位置-市
     */
    @ApiModelProperty("仓位置-市")
    private Integer warehouseCity;

    /**
     * 仓位置-区、县
     */
    @ApiModelProperty("仓位置-区、县")
    private Integer warehouseCounty;


    /**
     * 仓位置
     */
    @ApiModelProperty("仓位置")
    private String warehouseAreaName;


    @ApiModelProperty(value = "创建时间")
    protected Date createDate;
}
