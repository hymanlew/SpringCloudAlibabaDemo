package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author:
 * @create: 2019-04-09
 * @description: 司机上岗入参
 **/
@Data
@ApiModel("司机上岗入参")
public class GoToWorkFORM implements Serializable {

    private static final long serialVersionUID = 4685523404898586588L;
    @ApiModelProperty(value = "订单id")
    @NotBlank(message = "订单id不能为空")
    @Length(min = 0, max = 32, message = "订单id长度必须介于 0 和 32 之间")
    private String orderId;

    @ApiModelProperty(value = "标书id")
    @NotBlank(message = "标书id不能为空")
    @Length(min = 0, max = 256, message = "标书id长度必须介于 0 和 256 之间")
    private String tenderId;

    @ApiModelProperty(value = "司机id")
    @NotBlank(message = "司机id不能为空")
    private String driverId;

    /**
     * 标书域使用，新标书 需要
     */
    @ApiModelProperty(value = "司机名称")
    private String driverName;

    /**
     * 标书域使用，新标书 需要
     */
    @ApiModelProperty(value = "司机电话")
    private String driverPhone;

    @ApiModelProperty(value = "第三方司机id")
    private String thirdDriverId;

    @ApiModelProperty(value = "合同起始时间")
    private Date contractStart;

    @ApiModelProperty(value = "标记位，区分是从订单页面调用还是标书页面。默认是订单页面，为空。标书页面有值 match")
    private String source;

    public void setSource(String source) {
        if (!"match".equals(source)) {
            source = null;
        }
        this.source = source;
    }

}
