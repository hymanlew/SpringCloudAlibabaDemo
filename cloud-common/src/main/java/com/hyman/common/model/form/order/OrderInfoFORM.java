package com.hyman.common.model.form.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author:
 * @create: 2019-03-22
 * @description: 创建订单信息对象
 **/
@Data
@ApiModel("创建订单信息对象")
public class OrderInfoFORM {

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderId;

    /**
     * 标书编号
     */
    @ApiModelProperty(value = "标书编号")
    @NotBlank(message = "标书编号不能为空")
    @Length(min = 0, max = 32, message = "标书编号长度必须介于 0 和 32 之间")
    private String bidId;

    @ApiModelProperty(value = "标书业务类型")
    @NotNull(message = "标书业务类型不能为空")
    private Integer bidBusiType;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    @NotBlank(message = "司机编号不能为空")
    @Length(min = 0, max = 32, message = "司机编号长度必须介于 0 和 32 之间")
    private String driverId;

    /**
     * 司机名称
     */
    @ApiModelProperty(value = "司机名称")
    @NotBlank(message = "司机名称不能为空")
    @Length(min = 0, max = 32, message = "司机名称长度必须介于 0 和 32 之间")
    private String driverName;

    /**
     * 司机电话
     */
    @ApiModelProperty(value = "司机电话")
    @NotBlank(message = "司机电话不能为空")
    @Length(min = 0, max = 11, message = "司机电话长度必须介于 0 和 11 之间")
    private String driverPhone;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    @NotNull(message = "城市不能为空")
    @Range(min = 1, max = 999999, message = "range在[1,999999]之间")
    private Integer city;


    /**
     * 意向车型
     */
    @ApiModelProperty(value = "意向车型")
    @NotNull(message = "意向车型不能为空")
    @Range(min = 0, max = 50, message = "range在[1,50]之间")
    private Integer carType;

    public void setDriverPhone(String driverPhone) {
        // 手机号验证
        driverPhone = driverPhone.trim();
        if (driverPhone.length() != 11) {
            throw new IllegalArgumentException(String.format("手机号：%s 不合法,请输入合法11位手机号", driverPhone));
        } else {
            this.driverPhone = driverPhone;
        }
    }
}
