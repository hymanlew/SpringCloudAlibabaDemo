package com.hyman.common.model.form.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * 根据小组officeId去找同级别的用户并用职责过滤 form
 *
 * @author hucl
 * @date 2021/5/27 11:04 上午
 */
@Getter
@Setter
@ApiModel("根据小组officeId去找同级别的用户并用职责过滤FORM")
public class GetUserByGroupOfficeIdAndDutyFORM {

    @NotEmpty(message = "roleType不能为空")
    @ApiModelProperty(value = "对应sys_duty_mapping#front_value")
    private Set<Integer> roleTypes;

    @ApiModelProperty("组织id")
    @NotNull(message = "组织id不能为空")
    private Integer officeId;

    @ApiModelProperty("系统类别 1梧桐系统 3雷鸟系统 6权限管理系统 7线索管理系统 8数据平台系统")
    @NotNull(message = "系统类别不能为空")
    private Integer sysType;


}
