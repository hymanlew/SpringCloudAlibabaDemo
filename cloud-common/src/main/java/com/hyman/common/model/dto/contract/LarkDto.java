package com.hyman.common.model.dto.contract;

import lombok.Data;

/**
 * @description:
 * @author: hyman
 * @date: 2020/5/11
 */
@Data
public class LarkDto {
    //乙方
    private String partyB;
    //身份证
    private String iDCard;
    //手机号
    private String phoneNo;
    //地址
    private String address;
    //邮箱
    private String email;
    //退还百分比
    private String afterPercent;
    //服务金额大写
    private String capDeal;
    //服务金额小写
    private String lowerDeal;
}
