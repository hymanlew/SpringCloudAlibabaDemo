package com.hyman.common.model.vo.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author yzy
 * @Date 2021/05/07 10:02
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("批量发起客邀返回值")
public class StartCustInviteBatchVO implements Serializable {


    @ApiModelProperty(value = "返回标记")
    private boolean flag;

    @ApiModelProperty(value = "返回内容")
    private List<Map<String,Object>> msg;
}
