package com.hyman.common.model.dto.match;

import com.hyman.common.model.dao.tender.DriverLineMatchRateInfoDAO;
import com.hyman.common.model.dto.driver.DriverWorkIntentionDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author Changyuan Su
 * @date 2020/4/14 下午3:13
 * @Description:
 */
@ApiModel("司机接活意向")
@Data
public class DriverWorkIntention2dbDTO implements Serializable {
    private static final long serialVersionUID = 3764458429702364449L;

    @ApiModelProperty("司机接活意向得分")
    private DriverLineMatchRateInfoDAO driverLineMatchRateInfoDAO;

    @ApiModelProperty("司机接活意向")
    private List<DriverWorkIntentionDTO> driverWorkIntentionDTOS;

    @ApiModelProperty("匹配了的意向id")
    private Set<Integer> matchIds;

}
