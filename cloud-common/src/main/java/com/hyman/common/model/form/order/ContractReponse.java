package com.hyman.common.model.form.order;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @description:业务数据明文参数
 * @author: hyman
 * @date: 2020/5/11
 */
@Data
@ApiModel("电子合同第三方回调结果，已解密为业务数据明文参数")
public class ContractReponse {
    //当前回调的合同Id
    private String contractId;
    //当前回调的通知类型
    private String callbackType;
    //当前回调的合同状态
    private String contractStatus;
    //签署方类型: PERSONAL-个人 COMPANY-公司
    private String tenantType;
    //签署方名称
    private String tenantName;
    //联系方式
    private String contact;
    //签署方ID
    private String tenantId;

}
