package com.hyman.common.model.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @description: ConvertDTO <br>
 * @date: 2021/1/19 14:33 <br>
 * @author: hyman <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertDTO {
    
    @NotBlank(message = "字段名不能为空")
    //目标对象的字段名
    private String fieldName;
    
    @NotBlank(message = "字典类型不能为空")
    //字典类型
    private String dictType;
    
    @NotBlank(message = "字典值不能为空")
    //字典值
    private Object dictValue;
    
    public static ConvertDTO of (String fieldName,String dictType,Object dictValue){
        return new ConvertDTO(fieldName,dictType,dictValue);
    }
}
