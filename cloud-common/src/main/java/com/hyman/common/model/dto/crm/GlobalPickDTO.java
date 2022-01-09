package com.hyman.common.model.dto.crm;

import lombok.Data;

import java.util.List;

/**
 * @description: 通用选项集实体类 <br>
 * @date: 2020/9/9 16:26 <br>
 * @author: hyman <br>
 */
@Data
public class GlobalPickDTO {
    
    private String label;
    
    private String description;
    
    List<PickOption> pickOptionData;
    
}
