package com.hyman.common.crm.result;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author:yanwei
 * @Date: 2020/9/3 - 9:28
   通用结果返回集
 */
@Data
@Builder
public class CrmResult<CT> implements Serializable {
       private String code;
       private String msg;
       private CT result;
       private String name;
       private String errorInfo;
       private Boolean success = true;
}
