package com.hyman.common.model.vo.wechat.corp;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("企业微信成员信息vo")
public class WxCpUserInfoVO implements Serializable {

    private static final long serialVersionUID = -4669807360965188876L;

    private String userId;
    private String name;
    private String alias;
    private String mobile;
    private Integer gender;
    private String email;
    private String avatar;
    /**
     * 地址。长度最大128个字符
     */
    private String address;
    private Integer status;
    private Integer enable;
    private String telephone;

}
