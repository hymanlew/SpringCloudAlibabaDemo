package com.hyman.common.model.dto.driver;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2019/10/31 下午3:45
 * @Description:
 */
@NoArgsConstructor
@ApiModel("BSS司机运费监控根据司机ID获取所有标书")
@Data
public class DriverAllBidsByDriverIdDTO implements Serializable {
    private static final long serialVersionUID = -3687838427649878460L;


    /**
     * lineId : 201908151034
     * tenderId : 201908291007
     * customerId : 201908151033
     * customerName : 北京易酒批
     * lineName : 酒水饮料配送
     * carTypeName : 金杯
     * cargoType : 酒水饮料
     * warehouse : 北京市北京市通州区北京森工木业有限公司易酒批（通州仓）
     * lowestQuotations : 380
     * city : 110100
     * cityName : 北京市
     * createDate : 1567070882000
     * driverId : BJS201906251003
     * driverName : 刘江臣
     * tenderState : 9
     * tenderStateName : 到期结束下线
     * orderNo : BJS201908151000
     * createId : 52
     * timeDiff : 12小时
     * dayNum : 2
     * creatorName : 薛艳霞
     * primaryClassification : 3
     * primaryClassificationName : 集团客户
     * lineRank : 0
     * lineRankName : null
     * incomeSettlementMethod : 1
     */

    private String lineId;
    private String tenderId;
    private String customerName;
    private String lineName;
    private Double lowestQuotations;
    private String driverId;
    private String tenderStateName;
    private Integer dayNum;
    private Integer monthNum;
    private String primaryClassificationName;
    private Integer incomeSettlementMethod;
}
