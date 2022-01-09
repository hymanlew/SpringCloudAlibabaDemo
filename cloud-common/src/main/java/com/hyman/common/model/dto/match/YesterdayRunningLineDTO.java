package com.hyman.common.model.dto.match;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Changyuan Su
 * @date 2020/3/3 下午6:56
 * @Description:
 */
@ApiModel("昨日在跑线路实体")
@Data
public class YesterdayRunningLineDTO implements Serializable {
    private static final long serialVersionUID = 1554373499125577473L;

    private Set<String> yesterdayUplineLineIds;

    private Set<String> yesterdayAllRunningLineIds;

}
