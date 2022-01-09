package com.hyman.common.model.dto.driver;

import com.hyman.common.model.vo.match.ReleaseTenderBidStatusAndListVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author:
 * @create: 2019-08-07
 * @description: 订单删除，司机状态回撤传递对象
 **/
@Data
@ApiModel("订单删除，司机状态回撤传递对象")
public class DriverStateRebackBecauseOrderDeleteDTO implements Serializable {

    private static final long serialVersionUID = 8947190219016950099L;
    @ApiModelProperty(value = "司机id")
    public String driverId;

    @ApiModelProperty(value = "标书状态和与之对应的标书ids")
    public List<ReleaseTenderBidStatusAndListVO> lists;

    @ApiModelProperty("是否还有更多成交标书")
    private boolean hasMoreDealOrder;

}
