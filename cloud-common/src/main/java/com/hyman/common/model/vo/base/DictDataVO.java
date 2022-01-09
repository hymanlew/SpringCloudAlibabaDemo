package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: DictDataVO <br>
 * date: 2020/7/9 10:26 <br>
 * author: hyman <br>
 */
@Data
@ApiModel("字典值信息VO")
public class DictDataVO {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Integer id;

    /**
     * 父级编号
     */
    @ApiModelProperty(value = "父级编号")
    private Integer parentId;

    /**
     * 所有父级编号
     */
    @ApiModelProperty(value = "所有父级编号")
    private String parentIds;

    /**
     * 字典类型
     */
    @ApiModelProperty(value = "字典类型")
    private String dictType;

    /**
     * 字典标签
     */
    @ApiModelProperty(value = "字典标签")
    private String dictLabel;

    /**
     * 字典键值
     */
    @ApiModelProperty(value = "字典键值")
    private String dictValue;

    /**
     * 排序（升序）
     */
    @ApiModelProperty(value = "排序（升序）")
    private Integer sort;

    /**
     * 字典描述
     */
    @ApiModelProperty(value = "字典描述")
    private String description;


    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remarks;
}
