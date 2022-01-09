package com.hyman.common.model.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * description: OffIceVO <br>
 * date: 2020/7/7 10:24 <br>
 * author: hyman <br>
 */
@Data
@ApiModel("组织列表VO")
public class OfficeNewVO {

    @ApiModelProperty(value = "Id")
    private Integer id;

    @ApiModelProperty(value = "当前序列")
    private Integer seq;

    @ApiModelProperty(value = "组织名")
    private String name;

    @ApiModelProperty(value = "层级类型:1总部，2大区，3城市，4业务线，5小组")
    private Integer type;

    @ApiModelProperty(value = "父节点")
    private Integer parentId;

    @ApiModelProperty(value = "根节点到父节点序列")
    private String  parentIds;

    @ApiModelProperty(value = "子组织")
    private List<OfficeNewVO> officeVOs;

    @ApiModelProperty(value = "当前组织下的用户数")
    private Integer userCount = 0;

    @ApiModelProperty(value = "区域Code")
    private String  areaId;
    
    @ApiModelProperty(value = "职责Id")
    private Integer  dutyId;
    
    @ApiModelProperty(value = "父级结构的名字")
    private String parentName;

}
