package com.hyman.common.model.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: ChenJingBin
 * @date: 2020/7/8
 */
@Data
@ApiModel("返利信息")
public class OrderDeliverRebateVO {


    /**
     * 业务主键
     */
    @ApiModelProperty(value = "业务主键")
    private String orderId;

    /**
     * 逻辑主键，自增长，无符号
     */
    @ApiModelProperty(value = "逻辑主键")
    private Integer id;

    /**
     * 项目返利类型，enum
     */
    @ApiModelProperty(value = "项目返利类型enum")
    private Integer priceType;

    /**
     * 底盘返利金额
     */
    @ApiModelProperty(value = "底盘返利金额")
    private BigDecimal chassis;

    /**
     * 车辆返利金额
     */
    @ApiModelProperty(value = "车辆返利金额")
    private BigDecimal vehicle;

    /**
     * GPS返利金额
     */
    @ApiModelProperty(value = "GPS返利金额")
    private BigDecimal gps;

    /**
     * 尾板返利金额
     */
    @ApiModelProperty(value = "尾板返利金额")
    private BigDecimal tailgate;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private Integer createId;

    /**
     * 创建者姓名
     */
    @ApiModelProperty(value = "创建者姓名")
    private String createName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private Integer updateId;

    /**
     * 更新者姓名
     */
    @ApiModelProperty(value = "更新者姓名")
    private String updateName;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;
}
