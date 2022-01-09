package com.hyman.common.model.vo.driver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author:
 * @create: 2019-03-20
 * @description: 司机信息返回对象
 **/
@Data
public class DriverInfoVO extends BaseDAO implements Serializable {

    private static final long serialVersionUID = -2204120273349260975L;

    /**
     * 司机名称
     */
    @ApiModelProperty(value = "司机名称")
    private String name;

    @ApiModelProperty(value = "第三方司机id")
    private String thirdDriverId;

    /**
     * 身份证号
     */
    @JsonInclude(JsonInclude.Include.ALWAYS)
    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    /**
     * 司机电话
     */
    @ApiModelProperty(value = "司机电话")
    private String phone;

    /**
     * 司机编号
     */
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 工作城市
     */
    @ApiModelProperty(value = "工作城市")
    private Integer workCity;

    /**
     * 工作城市
     */
    @ApiModelProperty(value = "工作城市[中文]")
    private String workCityName;


    /**
     * 司机年龄
     */
    @ApiModelProperty(value = "司机年龄")
    private Integer age;

    /**
     * 户籍-省
     */
    @ApiModelProperty(value = "户籍-省")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer province;

    /**
     * 户籍-省
     */
    @ApiModelProperty(value = "户籍-省[中文]")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String provinceName;

    /**
     * 户籍-市
     */
    @ApiModelProperty(value = "户籍-市")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer city;

    /**
     * 户籍-市
     */
    @ApiModelProperty(value = "户籍-市[中文]")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String cityName;

    /**
     * 现居住地址
     */
    @ApiModelProperty(value = "现居住地址")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String address;

    /**
     * 来源渠道
     */
    @ApiModelProperty(value = "来源渠道")
    private Integer source;

    /**
     * 来源渠道
     */
    @ApiModelProperty(value = "来源渠道[中文]")
    private String sourceName;

    /**
     * 货物经验
     */
    @ApiModelProperty(value = "货物经验")
    private String cargoType;

    /**
     * 货物经验
     */
    @ApiModelProperty(value = "货物经验[中文]")
    private String cargoTypeName;

    /**
     * 物流从业经验
     */
    @Column(name = "work_experience")
    @ApiModelProperty(value = "物流从业经验")
    private Integer workExperience;

    /**
     * 物流从业经验
     */
    @Column(name = "work_experience")
    @ApiModelProperty(value = "物流从业经验[中文]")
    private String workExperienceName;

    /**
     * 期望月收入
     */
    @Column(name = "exp_monthly_income")
    @ApiModelProperty(value = "期望月收入")
    private Integer expMonthlyIncome;

    /**
     * 期望月收入
     */
    @ApiModelProperty(value = "期望月收入[中文]")
    private String expMonthlyIncomeName;

    /**
     * 可接受工作时长
     */
    @ApiModelProperty(value = "可接受工作时长")
    private Integer workHour;

    /**
     * 可接受工作时长
     */
    @ApiModelProperty(value = "可接受工作时长[中文]")
    private String workHourName;

    /**
     * 意向车型
     */
    @ApiModelProperty(value = "意向车型")
    private Integer carType;

    /**
     * 意向车型
     */
    @ApiModelProperty(value = "意向车型[中文]")
    private String carTypeName;

    /**
     * 可接受首付范围
     */
    @ApiModelProperty(value = "可接受首付范围")
    private Integer acceptPayRange;

    /**
     * 可接受首付范围
     */
    @ApiModelProperty(value = "可接受首付范围[中文]")
    private String acceptPayRangeName;

    /**
     * 之前在哪工作
     */
    @ApiModelProperty(value = "之前在哪工作")
    private String whereWorked;

    /**
     * 是否有在还贷款（1是 2否）
     */
    @ApiModelProperty(value = "是否有在还贷款（1是 2否）")
    private Integer isHaveLoan;

    /**
     * 是否有在还贷款（1是 2否）
     */
    @ApiModelProperty(value = "是否有在还贷款（1是 2否）[中文]")
    private String isHaveLoanName;

    /**
     * 是否有车（1是 2否）
     */
    @ApiModelProperty(value = "是否有车（1是 2否）")
    private Integer isHaveCar;

    /**
     * 是否有车（1是 2否）
     */
    @ApiModelProperty(value = "是否有车（1是 2否）[中文]")
    private String isHaveCarName;

    /**
     * 购车最关注哪些方面
     */
    @ApiModelProperty(value = "购车最关注哪些方面")
    private String buyCarFollow;

    /**
     * 是否缴纳意向金（1是 2否）
     */
    @ApiModelProperty(value = "是否缴纳意向金（1是 2否）")
    private Integer isPay;

    /**
     * 是否缴纳意向金（1是 2否）
     */
    @ApiModelProperty(value = "是否缴纳意向金（1是 2否）[中文]")
    private String isPayName;

    /**
     * 意向金缴纳日期
     */
    @ApiModelProperty(value = "意向金缴纳日期")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Date payDate;

    /**
     * 征信是否通过（1是 2否）
     */
    @ApiModelProperty(value = "征信是否通过（1是 2否）")
    private Integer isCreditPass;

    /**
     * 征信是否通过（1是 2否）
     */
    @ApiModelProperty(value = "征信是否通过（1是 2否）[中文]")
    private String isCreditPassName;

    /**
     * 平均月收入
     */
    @Nullable
    @ApiModelProperty(value = "平均月收入")
    private Integer monthlyIncome;

    @Nullable
    @ApiModelProperty(value = "平均月收入[ZN-CN]")
    private String monthlyIncomeName;

    /**
     * 户口类型(城镇户口:1,农村户口:2)
     */
    @NotNull(message = "户口类型不能为空")
    @ApiModelProperty(value = "户口类型(城镇户口:1,农村户口:2)")
    private Integer accountType;

    /**
     * 家里几个孩子(默认0个)
     */
    @NotNull(message = "家里几个孩子,不能为空")
    @ApiModelProperty(value = "家里几个孩子(默认0个)")
    private Integer childrenNum;

    /**
     * 孩子的年龄
     */
    @Nullable
    @ApiModelProperty(value = "孩子的年龄")
    private String childrenAge;


    /**
     * 司机状态
     */
    @ApiModelProperty(value = "司机状态")
    private Integer state;

    /**
     * 司机状态
     */
    @ApiModelProperty(value = "司机状态[中文]")
    private String stateName;

    /**
     * 报名时间
     */
    @ApiModelProperty(value = "报名时间")
    private Date signUpDate;

    /**
     * 合同起始时间
     */
    @ApiModelProperty(value = "合同起始时间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Date contractStart;

    /**
     * 合同截止时间
     */
    @ApiModelProperty(value = "合同截止时间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Date contractEnd;

    /**
     * 司机首次上岗时间
     */
    @ApiModelProperty(value = "司机首次上岗时间")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Date goToWorkTime;

    /**
     * 签约操作人ID
     */
    @ApiModelProperty(value = "签约操作人ID")
    private Integer signId;

    /**
     * 签约操作人ID
     */
    @ApiModelProperty(value = "签约操作人ID[中文]")
    private String signIdName;

    /**
     * 开户银行
     */
    @ApiModelProperty(value = "开户银行")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String bankName;

    /**
     * 开户支行
     */
    @ApiModelProperty(value = "开户支行")
    private String accountOpeningBranch;

    /**
     * 银行开户名
     */
    @ApiModelProperty(value = "银行开户名")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String accountName;

    /**
     * 银行账户
     */
    @ApiModelProperty(value = "银行账户")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String cardNumber;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "面试时间")
    private Date interviewTime;

    @ApiModelProperty(value = "是否为高意向(1是2否)")
    private Integer isAdvancedIntentional;

    @ApiModelProperty(value = "司机类型")
    private Integer driverType;

    /**
     * 加盟经理id
     */
    @ApiModelProperty(value = "加盟经理id")
    protected Long joinManagerId;

    /**
     * 加盟经理名称
     */
    @ApiModelProperty(value = "加盟经理名称")
    private String joinManagerName;

    @ApiModelProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "企业微信-外部联系人id")
    private String externalUserId;

    @ApiModelProperty(value = "企业微信-成员id")
    private String corpUserId;

}