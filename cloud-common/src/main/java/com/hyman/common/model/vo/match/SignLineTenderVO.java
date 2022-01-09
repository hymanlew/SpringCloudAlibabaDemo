package com.hyman.common.model.vo.match;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyman.common.model.dao.line.LineDeliveryInfoDAO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Changyuan Su
 * @date 2019/3/28 18:41
 * @Description:
 */
@Data
public class SignLineTenderVO implements Serializable {
    private static final long serialVersionUID = -5637333444063609085L;
    /**
     * 线路编号
     */
    @ApiModelProperty(value = "线路编号")
    private String lineId;

    /**
     * 标书编号
     */
    @ApiModelProperty(value = "标书编号")
    private String bidId;

    /**
     * 客户名称[简称]
     */
    @ApiModelProperty(value = "客户名称[简称]")
    private String customerName;

    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    private String customerId;

    /**
     * 线路名称
     */
    @ApiModelProperty(value = "线路名称")
    private String lineName;

    public String getWarehouse() {
        return warehouseProvinceName.concat(warehouseCityName).concat(warehouseCountyName).concat(warehouseDistrict);
    }

    @ApiModelProperty("仓库位置")
    private String warehouse;

    /**
     * 标书的创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "创建时间")
    protected String createDate;

    @ApiModelProperty(value = "城市")
    private Integer city;

    @ApiModelProperty(value = "城市")
    private String cityName;

//    /**
//     * 预计工作时间起始
//     */
//    @JsonFormat(pattern = "HH:mm")
//    @ApiModelProperty(value = "到仓时间")
//    private String workingTimeStart;
//
//    /**
//     * 预计工作时间截止
//     */
//    @JsonFormat(pattern = "HH:mm")
//    @ApiModelProperty(value = "配送完成时间")
//    private String workingTimeEnd;

    @ApiModelProperty(value = "前端：客户报价[单位：元]")
    private Double preLowestQuotations;

//    @ApiModelProperty(value = "创建线路任务的创建者姓名")
//    private String createrName;

    /**
     * 每日配送趟数
     */
    @ApiModelProperty(value = "每日配送趟数")
    private String dayNum;

    @ApiModelProperty("配送时间")
    List<LineDeliveryInfoDAO> lineDeliveryInfoFORMS;

    @JsonIgnore
    @ApiModelProperty(value = "仓库位置-省")
    private String warehouseProvinceName;

    @JsonIgnore
    @ApiModelProperty(value = "仓库位置-市")
    private String warehouseCityName;

    @JsonIgnore
    @ApiModelProperty(value = "仓库位置-区、县")
    private String warehouseCountyName;

    @JsonIgnore
    @ApiModelProperty(value = "仓库位置-具体位置")
    private String warehouseDistrict;

}
