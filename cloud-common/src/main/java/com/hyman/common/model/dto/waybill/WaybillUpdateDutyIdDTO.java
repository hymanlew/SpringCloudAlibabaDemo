package com.hyman.common.model.dto.waybill;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * @author xiefujiang
 * @Classname WaybillUpdateDutyIdDTO
 * @Description
 * @Date 2021/1/6
 */
@Data
@Validated
public class WaybillUpdateDutyIdDTO implements Serializable {
    /**
     * 项目ids
     */
    @NotNull(message = "集合不能为空")
    @Size(min = 1)
    private Set<String> projectIdOrLineIds;

    /**
     * 上岗经理
     */
    @NotNull(message = "上岗经理不能为空")
    private Long dutyManageId;
}
