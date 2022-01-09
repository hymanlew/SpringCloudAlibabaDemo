package com.hyman.common.model.dto.crm;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: PickOption <br>
 * @date: 2020/9/9 16:29 <br>
 * @author: hyman <br>
 */
@Data
@AllArgsConstructor
public class PickOption {
    
    private String optionCode;
    
    private String optionLabel;
}
