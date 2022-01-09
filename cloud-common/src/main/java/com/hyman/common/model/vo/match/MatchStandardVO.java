package com.hyman.common.model.vo.match;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yzy
 * @Date 2021/05/07 10:02
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("撮合标准返回值")
public class MatchStandardVO implements Serializable {


    @ApiModelProperty(value = "返回标记")
    private boolean flag;

    @ApiModelProperty(value = "返回内容")
    private String msg;
}
