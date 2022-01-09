package com.hyman.common.model.dto.line;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xxx
 */
@ApiModel("货主列表内部调用统计线路,标书等汇总字段")
@Data
@Builder
public class LineCustomerCountDto implements Serializable {
    private Long number;
    private String customerId;
}
