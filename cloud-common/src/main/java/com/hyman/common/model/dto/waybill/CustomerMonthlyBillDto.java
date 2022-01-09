package com.hyman.common.model.dto.waybill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 客户月账单批量创建接口
 *
 * @author wanghaitong
 * @date 2020/10/29 上午11:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMonthlyBillDto {

    String customerId;
    String projectId;
    Date billDate;
}
