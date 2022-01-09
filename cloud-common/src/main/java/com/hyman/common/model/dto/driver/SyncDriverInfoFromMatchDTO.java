package com.hyman.common.model.dto.driver;

import com.hyman.common.model.dto.BasicMQDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 撮合打标签同步司机云的一些信息
 *
 * @author hucl
 * @date 2021/5/21 10:05 上午
 */
@Getter
@Setter
public class SyncDriverInfoFromMatchDTO extends BasicMQDTO implements Serializable {
    private static final long serialVersionUID = -7628867603030534876L;

    /**
     * 司机编号
     */
    private String driverId;

    /**
     * 期望收入-趟
     * 司机面试表
     */
    private BigDecimal expIncomeTrip;

    /**
     * 司机情况
     * 司机标签表
     */
    private Integer driverSituation;

    /**
     * 装卸接受度
     * 司机面试表
     */
    private Integer heavyLiftingType;

    /** 是否为租赁全藏 */
    private Boolean isRentalHide;

    /**
     * 操作人
     */
    private Long userId;
}
