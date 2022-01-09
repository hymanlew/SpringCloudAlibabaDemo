package com.hyman.common.model.dto.line;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ojt
 */
@ApiModel("地点字段")
@Data
public class AreaItemDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;
}
