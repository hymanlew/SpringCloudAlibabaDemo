package com.hyman.common.model.vo.car;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiefujiang
 * @Classname LeiNiaoUserInfoDTO
 * @Description
 * @Date 2021/4/12
 */
@Data
public class LeiNiaoUserInfoDTO implements Serializable {
    private static final long serialVersionUID = -3549263584102744116L;
    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户手机号
     */
    private Long phone;

    /**
     * 微信的OpenId
     */
    private String openId;

    /**
     * 微信的UnionId
     */
    private String unionId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 性别(1男，2女)
     */
    private Boolean sex;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 用户头像
     */
    private String headImage;

    /**
     * 外部联系人userid
     */
    private String externalUserId;

    /**
     * 企业微信成员id
     */
    private String corpUserId;

    /**
     * 创建者ID
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后一次修改人员
     */
    private Integer updateId;

    /**
     * 最后一次修改时间
     */
    private Date updateDate;

}
