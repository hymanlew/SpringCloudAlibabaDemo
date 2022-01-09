package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Changyuan Su
 * @date 2019/6/10 18:45
 * @Description:
 */
@ApiModel("订单上岗,包括前进标书状态与回退标书状态两部分")
@Data
public class OrderGoToWorkDTO implements Serializable {
    private static final long serialVersionUID = 1141727807921301353L;

    @ApiModelProperty("目前选择的标书")
    private Set<String> nowTenderIds;

    @ApiModelProperty("之前的标书")
    private Set<String> beforeTenderIds;

    @Valid
    @ApiModelProperty("标书所需的司机和订单信息实体")
    private TenderNeededDriverAndOrderInfoDTO neededDriverAndOrderInfoDTO;


    @ApiModel("标书所需的司机和订单信息")
    @Data
    public static class TenderNeededDriverAndOrderInfoDTO implements Serializable {
        private static final long serialVersionUID = 3404303589641829947L;
        /**
         * 司机编号
         */
        @NotBlank(message = "司机编号不能为空")
        @ApiModelProperty(value = "司机编号")
        private String driverId;

        /**
         * 司机名称
         */
        @NotBlank(message = "司机姓名不能为空")
        @ApiModelProperty(value = "司机名称")
        private String driverName;

        /**
         * 司机电话
         */
        @NotBlank(message = "司机电话不能为空")
        @ApiModelProperty(value = "司机电话")
        private String driverPhone;

        /**
         * 订单编号
         */
        @NotBlank(message = "订单号不能为空")
        @ApiModelProperty(value = "订单编号")
        private String orderId;

        @Nullable
        @ApiModelProperty(value = "预计上岗时间")
        private Date appointmentDate;
    }

}
