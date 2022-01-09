package com.hyman.common.model.dto.label;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 试跑在跑同步最后一次出车日期到司机标签
 *
 * @author hucl
 * @date 2021/5/12 1:36 下午
 */
@Getter
@Setter
public class DriverLabelSyncLastRunDateDTO implements Serializable {

    private static final long serialVersionUID = 8420791624646302054L;

    /**
     * 司机编号
     */
    @NotBlank(message = "司机编号不能为空")
    private String driverId;

    /**
     * 最后一次出车日期
     */
    @NotNull(message = "最后一次出车日期不能为空")
    private Date lastRunDate;

}
