
package com.hyman.common.model.vo.base;

import lombok.Data;

import java.util.Date;

/**
 * 用户Entity
 *
 * @author
 * @version 2013-12-05
 */
@Data
public class UserAndBusiType {



    private Integer busiType;
    private Long userId;
    private String company;    // 归属公司
    private String office;    // 归属部门
    private String loginName;// 登录名
    private String password;// 密码
    private String no;        // 工号
    private String titleName;
    private String name;    // 姓名
    private String email;    // 邮箱
    private String phone;    // 电话
    private String mobile;    // 手机
    private String userType;// 用户类型
    private String busiPermission;
    private String photo;    // 头像
    private String loginIp;    // 最后登陆IP
    private Date loginDate;    // 最后登陆日期
    private String loginFlag;    // 是否允许登陆
    private String corpUserId;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String delFlag;




}