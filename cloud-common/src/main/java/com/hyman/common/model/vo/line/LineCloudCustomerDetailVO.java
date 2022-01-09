package com.hyman.common.model.vo.line;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName LineCloudCustomerDetailVO
 * @Description 线路云-客户详情视图
 * @Author shiyunlong
 * @Date 2020/8/27 16:07
 */
@Data
@ApiModel("线路云-客户详情视图")
public class LineCloudCustomerDetailVO {

    /**
     * 客户编号
     */
    @ApiModelProperty("客户编号")

    private String customerId;

    /**
     * 客户名称
     */
    @ApiModelProperty("客户名称")

    private String customerCompanyName;

    /**
     * 客户主体
     */
    @ApiModelProperty("客户主体")

    private String customerCompanyMain;

    /**
     * 客户类型(1公司,2个体)
     */
    @ApiModelProperty("客户类型")

    private Integer customerType;

    /**
     * 客户类型(1公司,2个体)Name
     */
    @ApiModelProperty("客户类型Name")

    private String customerTypeName;

    /**
     * 业务对接人姓名
     */
    @ApiModelProperty("业务对接人姓名")

    private String bussinessName;

    /**
     * 业务对接人电话
     */
    @ApiModelProperty("业务对接人电话")

    private String bussinessPhone;

    /**
     * 创建人所属城市
     */
    @ApiModelProperty("创建人所属城市")
    private Integer city;

    /**
     * 创建人所属城市Name
     */
    @ApiModelProperty("创建人所属城市")
    private String cityName;

    /**
     * 客户所属-省
     */
    @ApiModelProperty("客户所属-省")

    private Integer areaProvince;


    /**
     * 客户所属-省Name
     */
    @ApiModelProperty("客户所属-省Name")

    private String areaProvinceName;

    /**
     * 客户所属-市
     */
    @ApiModelProperty("客户所属-市")

    private Integer areaCity;
    /**
     * 客户所属-市Name
     */
    @ApiModelProperty("客户所属-市Name")

    private String areaCityName;

    /**
     * 客户所属-县Name
     */
    @ApiModelProperty("客户所属-县")

    private Integer areaCounty;


    /**
     * 客户所属-县Name
     */
    @ApiModelProperty("客户所属-县Name")

    private String areaCountyName;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    private String address;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 营业执照
     */
    @ApiModelProperty("营业执照")

    private String businessLicenseUrl;

    /**
     * 合同截止期
     */
    @ApiModelProperty("合同截止期")

    private Date contractEnd;

    /**
     * 客户体量
     */
    @ApiModelProperty("客户体量")

    private String customerSize;

    /**
     * 客户意向度(1高意向客户,2中意向客户,3低意向客户)
     */
    @ApiModelProperty("客户意向度")
    private Integer customerIntention;
    /**
     * 客户意向度(1高意向客户,2中意向客户,3低意向客户)
     */
    @ApiModelProperty("客户意向度Name")
    private String customerIntentionName;


    /**
     * 业务对接人身份证
     */
    @ApiModelProperty("业务对接人身份证")

    private String bussinessCard;

    /**
     * 业务对接人职务
     */
    @ApiModelProperty("业务对接人职务")

    private String bussinessPosition;

    /**
     * 客户状态（1启用,2禁用）
     */
    @ApiModelProperty("客户状态")

    private Integer customerState;

    /**
     * 客户状态Name（1启用,2禁用）
     */
    @ApiModelProperty("客户状态Name")

    private String customerStateName;


    /**
     * 审核状态（1审核通过,2审核不通过）
     */
    @ApiModelProperty("审核状态")
    private Integer reviewState;


    /**
     * 审核状态Name（1审核通过,2审核不通过）
     */
    @ApiModelProperty("审核状态Name")
    private String reviewStateName;

    /**
     * 客户分类
     */
    @ApiModelProperty("客户分类1、外线客户，2、自成运客户，3、集团客户")
    private Integer classification;
    /**
     * 客户分类Name
     */
    @ApiModelProperty("客户分类Name")
    private String classificationName;

    /**
     * 客户渠道（1直客,2三方）
     */
    @ApiModelProperty("客户渠道")
    private Integer customerChannels;

    /**
     * 客户渠道Name（1直客,2三方）
     */
    @ApiModelProperty("客户渠道Name")
    private String customerChannelsName;

    /**
     * 创建人ID
     */
    @ApiModelProperty("创建人ID")
    private Long createId;
    @ApiModelProperty("创建人姓名")
    private String createName;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createDate;


    /**
     * 修改人ID
     */
    @ApiModelProperty("修改人ID")
    private Long updateId;

    /**
     * 修改人ID
     */
    @ApiModelProperty("修改人ID")
    private String updateName;


    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateDate;

    /**
     * 外线销售ID
     */
    @ApiModelProperty("外线销售ID")
    private Long lineSaleId;

    /**
     * 外线销售名称
     */
    @ApiModelProperty("外线销售名称")
    private String lineSaleName;
}
