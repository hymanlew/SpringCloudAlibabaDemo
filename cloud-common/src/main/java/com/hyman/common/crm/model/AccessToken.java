package com.hyman.common.crm.model;

import cn.hutool.core.date.DateUtil;
import lombok.*;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;

/**
 * @Author:yanwei
 * @Date: 2020/9/2 - 19:26
 *
 * crm 认证 主体
 */
@Data
@NoArgsConstructor
public class AccessToken implements Serializable {
    /**
     * 当前授权用户的唯一标示ID
     */
    private Long id;
    /**
     * 密钥
     */
    private String accessToken;
    /**
     * 请求头标识
     */
    private String tokenType;
    /**
     * 生成授权时间
     */
    private Long issuedAt;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String headerToken;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Date expiredDate;

    /**
     * 返回 header 中得值
     * @return
     */
    public String headerToken(){
        if (StringUtils.isBlank(headerToken))
            headerToken = tokenType.concat(" ").concat(accessToken);
        return headerToken;
    }

    /**
     * false 代表未token 未到期
     *      * true 代表token 已到期
     * @return
     */
    public Boolean isExpired(){
          if (Objects.isNull(issuedAt)) return Boolean.TRUE;
          if (Objects.isNull(expiredDate))
              expiredDate = DateUtil.offsetHour(new Date(issuedAt),24);
        return expiredDate.getTime() < LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
    
}
