package com.hyman.common.model.vo.base;

import lombok.Data;

import java.util.List;

/**
 * @author xiefujiang
 * @Classname OfficeVOWitchSelected
 * @Description
 * @Date 2021/3/23
 */
@Data
public class OfficeVoNewWitchSelected {
    /**
     * 默认选中值
     */
    private Integer selected;

    /**
     * 返回用户下所属城市组织
     */
    private List<OfficeNewVO> officeVOList;
}
