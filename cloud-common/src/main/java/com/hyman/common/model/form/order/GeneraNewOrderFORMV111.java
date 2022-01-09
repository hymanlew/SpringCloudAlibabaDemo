package com.hyman.common.model.form.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author:
 * @create: 2019-08-28
 * @description: 生成新订单 v1.11
 **/
@Data
@ToString
@ApiModel("生成新订单 v1.11")
public class GeneraNewOrderFORMV111 implements Serializable {

    private static final long serialVersionUID = -5763425781733132411L;
    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "业务类型")
    @NotNull(message = "业务类型不能为空")
    private Integer busiType;

    /**
     * 生成订单中，司机基础信息
     */
    @Valid
    @ApiModelProperty(value = "生成订单中，司机基础信息 v1.5")
    private DriverBasicInfoForGeneraNewOrder driverBasicInfoForGeneraNewOrder;

    @ApiModelProperty(value = "收入支出信息 v1.11")
    @Valid
    private IncomeAndExpenditureInformation incomeAndExpenditureInformation;

    @ApiModelProperty(value = "合作模式【1，购车，2租车，3带车】")
    @NotNull(message = "合作模式 不能为空")
    @Range(min = 1, max = 5, message = "合作模式在[1,5]之间")
    private Integer cooperationModel;

    /**
     * 生成订单中，产品信息
     */
    @ApiModelProperty(value = "生成新订单，产品信息【购车】 v1.5")
    private ProductInfoForGeneraNewOrderV111 productInfoForGeneraNewOrder;

    @ApiModelProperty(value = "租车需要的产品信息 v1.11")
    private ProductInformationRequiredForCarRental productInformationRequiredForCarRental;

    /**
     * 带车模式下需要勾选带车车型，当前字段供带车模式使用
     */
    @ApiModelProperty(value = "带车，产品id")
    private String productIdForOwnCar;

    @ApiModelProperty(value = "带车，产品id【中文】")
    private String productIdForOwnCarName;

    @ApiModelProperty(value = "带车，车检有效期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date carCheckTime;

    @ApiModelProperty(value = "带车，报销有效期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date claimTime;

    @ApiModelProperty(value = "带车，车牌号")
    private String carNo;




    @ApiModelProperty(value = "订单提交状态【1，保存，2提交成交，3提交并新建,4 编辑产品】")
    @NotNull(message = "订单提交状态不能为空")
    @Range(min = 1, max = 4, message = "订单提交状态在[1,4]之间")
    private Integer orderCommitState;

    @ApiModelProperty(value = "当前订单详情版本")
    private String orderVersion;

    @ApiModelProperty(value = "服务费抽佣")
    private String serviceFee;

}
