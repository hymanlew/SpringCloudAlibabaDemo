package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author:zhanglichao
 * @Date:2021/1/21 10:27
 * @Description:
 */
@Data
@ApiModel("试跑获取线路详情字段明确VO")
public class LineToRunTestDetailVO {

    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
    private String customerName;

    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    private String customerId;

    /**
     * 线路id
     */
    @ApiModelProperty(value = "线路id")
    private String lineId;

    /**
     * 线路名称
     */
    @ApiModelProperty(value = "线路名称")
    private String lineName;


    /**
     * 线路分类1:稳定线路  2：临时线路
     */
    @ApiModelProperty(value = "线路分类1:稳定线路  2：临时线路")
    private Integer lineCategory;

    /**
     * 线路分类名称
     */
    @ApiModelProperty(value = "线路分类名称")
    private String lineCategoryName;

    /**
     * 线路标签类型(1:超肥 2:单肥 3:次肥 4:中瘦 5:极瘦)
     */
    @ApiModelProperty(value = "线路标签类型")
    private Integer labelType;

    /**
     * 线路标签类型名称
     */
    @ApiModelProperty(value = "线路标签类型名称")
    private String labelTypeName;

    /**
     * 配送车型
     */
    @ApiModelProperty(value = "配送车型")
    private Integer carType;

    /**
     * 选择车型
     */
    @ApiModelProperty(value = "选择车型名")
    private String carTypeName;

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
    private String provinceAreaName;

    /**
     * 配送市区域名称
     */
    @ApiModelProperty(value = "配送市区域名称")
    private String cityAreaName;

    /**
     * 配送区、县区域名称
     */
    @ApiModelProperty(value = "配送区、县区域名称")
    private String countyAreaName;

    /**
     * 具体配送区域范围
     */
    @ApiModelProperty(value = "具体配送区域范围")
    private String districtArea;

    /**
     * 配送总里程
     */
    @ApiModelProperty(value = "配送总里程")
    private Integer distance;

    /**
     * 总配送时长
     */
    @ApiModelProperty(value = "总配送时长")
    private String timeDiff;

    /**
     * 稳定线路时的配送时间(周一至周日对应数字拼接)
     */
    @ApiModelProperty(value = "稳定线路时的配送时间(周一至周日对应数字拼接)")
    private String deliveryWeekCycle;

    /**
     * 配送开始日期
     */
    @ApiModelProperty(value = "配送开始日期")
    private Date deliveryStartDate;

    /**
     * 配送结束日期
     */
    @ApiModelProperty(value = "配送结束日期")
    private Date deliveryEndDate;

    /**
     * 外线销售id
     */
    @ApiModelProperty(value = "外线销售id")
    private Integer lineSaleId;

    /**
     * 线路销售姓名
     */
    @ApiModelProperty("线路销售姓名")
    private String lineSaleName;

    /**
     * 线路销售电话
     */
    @ApiModelProperty("线路销售电话")
    private String lineSalePhone;

    /**
     * 上岗经理id
     */
    @ApiModelProperty(value = "上岗经理id")
    private Integer dutyManagerId;

    /**
     * 上岗经理姓名
     */
    @ApiModelProperty("上岗经理姓名")
    private String dutyManagerIdName;

    /**
     * 上岗经理手机号
     */
    @ApiModelProperty("上岗经理手机号")
    private String dutyManagerPhone;

    @ApiModelProperty("配送时间")
    List<LineDeliveryDetailInfoVO> lineDeliveryInfoFORMS;

    /**
     * 项目编号
     */
    @ApiModelProperty("项目编号")
    private String projectId;

    /**
     * 项目名称
     */
    @ApiModelProperty("项目名称")
    private String projectName;

    /**
     * 仓位置-省
     */
    @ApiModelProperty("仓位置-省")
    private Integer warehouseProvince;
    /**
     * 仓位置-省名称
     */
    @ApiModelProperty("仓位置-省名称")
    private String warehouseProvinceName;

    /**
     * 仓位置-市
     */
    @ApiModelProperty("仓位置-市")
    private Integer warehouseCity;

    /**
     * 仓位置-市
     */
    @ApiModelProperty("仓位置-市名称")
    private String warehouseCityName;

    /**
     * 仓位置-区、县
     */
    @ApiModelProperty("仓位置-区、县")
    private Integer warehouseCounty;
    /**
     * 仓位置-区、县
     */
    @ApiModelProperty("仓位置-区、县名称")
    private String warehouseCountyName;

    /**
     * 仓详细地址
     */
    @ApiModelProperty("仓详细地址")
    private String warehouseDistrict;
}
