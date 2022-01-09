package com.hyman.common.model.form.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author:
 * @create: 2019-06-10
 * @description: 生成新订单 v1.5
 * GeneraNewOrderFORM已经废弃，使用 GeneraNewOrderFORMV111 实体
 **/
@Data
@ApiModel("生成新订单 v1.5")
@Deprecated
public class GeneraNewOrderFORM implements Serializable {

    private static final long serialVersionUID = -2802565063865596817L;

    /**
     * 生成订单中，司机基础信息
     */
    @Valid
    @ApiModelProperty(value = "生成订单中，司机基础信息 v1.5")
    private DriverBasicInfoForGeneraNewOrder driverBasicInfoForGeneraNewOrder;

    /**
     * 生成订单中，产品信息
     */
    @ApiModelProperty(value = "生成新订单，产品信息 v1.5")
    private ProductInfoForGeneraNewOrder productInfoForGeneraNewOrder;

    @ApiModelProperty(value = "订单提交状态【1，保存，2提交成交，3提交并新建,4 编辑产品】")
    @NotNull(message = "订单提交状态不能为空")
    @Range(min = 1, max = 4, message = "订单提交状态在[1,4]之间")
    private Integer orderCommitState;

    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private String orderId;

}
