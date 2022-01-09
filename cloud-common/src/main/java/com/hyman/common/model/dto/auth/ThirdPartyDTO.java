package com.hyman.common.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:
 * @create: 2018-10-08
 * @description: 第三方系统的登录信息，同步到auth工程 提交表单数据
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThirdPartyDTO implements Serializable {

    private static final long serialVersionUID = 663579065756348319L;
    /**
     * 第三方系统用户id
     */
    private String thirdPartyId;
    /**
     * 用户名
     */
    private String loginName;
    /**
     * 旧的用户名
     */
    private String oldLoginName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户来源类型
     */
    private String type;
}