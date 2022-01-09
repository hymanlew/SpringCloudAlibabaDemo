package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author:zhanglichao
 * @Date:2021/1/20 13:27
 * @Description:
 */
@Data
@ApiModel("批量获取线路详情VO")
public class BatchLineInfoVO {

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
     * 每趟保底、货主单趟报价(元)
     */
    @ApiModelProperty(value = "每趟保底、货主单趟报价(元)")
    private BigDecimal everyTripGuaranteed;

    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    private String customerId;

    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty("线路配送时间表list")
    List<BatchLineDeliveryDetailInfoVO> batchLineDeliveryDetailInfoVO;
}
