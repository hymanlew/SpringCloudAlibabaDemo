package com.hyman.common.crm.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
/**
 * @Author:yanwei
 * @Date: 2020/9/3 - 15:59
 *  获取token 远程认证配置
 */
@Configuration
@ConfigurationProperties("crm.config")
@RefreshScope
@Data
public class CrmRemoteConfig {
    /**
     * 全局访问前缀
     */
     private   String url;

    /**
     * clientId
     * 客户端唯一标识
     */
    private String clientId;

    /**
     * clientSecret
     * 授权密钥
     */
    private String clientSecret;

    /**
     * redirect_uri
     *  密码模式登录，非 code授权服务资源。
     */
    @Deprecated
    private String redirectUri;

    /**
     * password
     */
     private String password;
    /**
     * username
     */
     private String username;
    /**
     * token
     * 安全令牌
     */
     private String token;

    /**
     * grant_type
     * 认证方式
     */
    private String grantType;

    /**
     * timeout
     * 访问crm 全局超时时间
     */
    private int timeout = 10;

   public String getAuthPassword(){
       return password == null ? null : password.concat(token);
   }

}
