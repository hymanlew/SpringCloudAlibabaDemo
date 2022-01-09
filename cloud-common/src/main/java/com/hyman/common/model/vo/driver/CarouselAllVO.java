package com.hyman.common.model.vo.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:
 * @create: 2019-05-17
 * @description:
 **/
@Data
@ApiModel(value = "CarouselAllVO")
public class CarouselAllVO implements Serializable {
    private static final long serialVersionUID = 12589588445232404L;

    /**
     * 自增ID
     */
    @ApiModelProperty(value = "自增ID")
    private Long id;

    /**
     * 业务ID
     */
    @ApiModelProperty(value = "业务ID")
    private String businessId;

    /**
     * 模块(order:订单 customer:客户)
     */
    @ApiModelProperty(value = "模块(order:订单 customer:客户)")
    private String module;

    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    private String operType;

    /**
     * 操作描述
     */
    @ApiModelProperty(value = "操作描述")
    private String operDesc;

    /**
     * 操作后状态
     */
    @ApiModelProperty(value = "操作后状态")
    private String afterState;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    private Long createId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 操作结果
     */
    @ApiModelProperty(value = "操作结果")
    private String result;

    /**
     * 司机姓名
     */
    @ApiModelProperty(value = "司机姓名")
    private String name;

}