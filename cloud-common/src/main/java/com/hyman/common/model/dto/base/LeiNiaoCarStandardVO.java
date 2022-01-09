package com.hyman.common.model.dto.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yantao
 * @Date 2020/12/8 10:02
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("司机标准返回值")
public class LeiNiaoCarStandardVO implements Serializable {

    private static final long serialVersionUID = -8151889584590002757L;

    @ApiModelProperty(value = "返回标记")
    private boolean flag;

    @ApiModelProperty(value = "返回内容")
    private String msg;
}
