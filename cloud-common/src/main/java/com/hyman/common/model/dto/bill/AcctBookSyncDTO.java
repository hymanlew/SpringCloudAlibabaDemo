package com.hyman.common.model.dto.bill;

import com.hyman.common.model.dto.BasicMQDTO;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hucl
 * @date 2021/5/12 5:28 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcctBookSyncDTO extends BasicMQDTO implements Serializable {

    private static final long serialVersionUID = -2476226233355280734L;

    /*
     * 司机编号
     */
    private String driverId;

    /*
     * 余额
     */
    private BigDecimal balance;
}
