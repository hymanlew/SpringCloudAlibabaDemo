package com.hyman.common.model.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: RedisQueryParamDTO <br>
 * @date: 2021/1/19 15:41 <br>
 * @author: hyman <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisQueryParamDTO {
  
  private  String key;
  
  private String field;
  
  public static RedisQueryParamDTO of(String key, String field){
      return new RedisQueryParamDTO(key,field);
  }
}
