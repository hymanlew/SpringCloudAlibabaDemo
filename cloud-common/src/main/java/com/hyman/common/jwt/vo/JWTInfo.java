package com.hyman.common.jwt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date: 2018/3.4/28 16:19
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTInfo implements IJWTInfo {

    /**
     * 微信openid
     */
    private String openId;

    /**
     * 普通游客的手机号
     */
    private Long phone;

    /**
     * 平台用户id 司机域 qzn_driver.driver_user_info 表
     */
    private String userId;

    /**
     * 云鸟业务人员姓名，对应下面 thirdPartyId
     */
    private String username;

    /**
     * 云鸟业务人员的id,qzn_base.sys_user 表
     */
    private String thirdPartyId;

    /**
     * type 表示当前token 的类型：APP，Applets，BSS
     */
    private String type;

    /**
     * 当前运行环境 d1,m1,staging,prod
     */
    private String profile;

    /**
     * 业务权限
     */
    private String busiPermission;

    /**
     * 登录标识
     * 1.如果redis中不存在，说明token过期，需要返回登录页面
     * 2.如果redis中存的登录标识不一致，说明这个账号在其他处登录，强制挤出当前用户
     */
    private String loginFlag;

    /**
     * 系统标识 比如：梧桐系统 雷鸟系统等
     */
    private String systemtype;

}
