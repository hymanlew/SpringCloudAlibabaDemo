package com.hyman.common.model.dao.driver;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com.hyman.domain.driver.model.dao.DriverInfoDAO")
@Data
@Table(name = "driver_info")
public class DriverInfoDAO extends BaseDAO implements Serializable {


    private static final long serialVersionUID = -8694161464452906517L;
    /**
     * 司机编号
     */
    @Column(name = "driver_id")
    @ApiModelProperty(value = "司机编号")
    private String driverId;

    /**
     * 司机类型
     * 参看 DriverTypeEnum
     */
    @Column(name = "driver_type")
    @ApiModelProperty(value = "司机类型")
    private Integer driverType;

    /**
     * 第三方司机id
     * 这里不再使用，使用DriverYunniaoInfoDAO 来存，一个司机拥有多个云鸟司机编号
     */
    @Column(name = "third_driver_id")
    @ApiModelProperty(value = "第三方司机id")
    @Deprecated
    private String thirdDriverId;

    /**
     * 司机名称
     */
    @Column(name = "`name`")
    @ApiModelProperty(value = "司机名称")
    private String name;

    /**
     * 司机电话
     */
    @Column(name = "phone")
    @ApiModelProperty(value = "司机电话")
    private String phone;

    /**
     * 身份证号
     */
    @Column(name = "id_number")
    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    /**
     * 司机年龄
     */
    @Column(name = "age")
    @ApiModelProperty(value = "司机年龄")
    private Integer age;

    /**
     * 工作城市
     */
    @Column(name = "work_city")
    @ApiModelProperty(value = "工作城市")
    private Integer workCity;

    /**
     * 户籍-省
     */
    @Column(name = "province")
    @ApiModelProperty(value = "户籍-省")
    private Integer province;

    /**
     * 户籍-市
     */
    @Column(name = "city")
    @ApiModelProperty(value = "户籍-市")
    private Integer city;

    /**
     * 户籍-区县
     */
    @Column(name = "district")
    @ApiModelProperty(value = "户籍-区县")
    private Integer district;

    /**
     * 现居住地址
     */
    @Column(name = "address")
    @ApiModelProperty(value = "现居住地址")
    private String address;

    /**
     * 来源渠道
     */
    @Column(name = "`source`")
    @ApiModelProperty(value = "来源渠道")
    private Integer source;

    /**
     * 货物经验
     */
    @Column(name = "cargo_type")
    @ApiModelProperty(value = "货物经验")
    private String cargoType;

    /**
     * 物流从业经验
     */
    @Column(name = "work_experience")
    @ApiModelProperty(value = "物流从业经验")
    private Integer workExperience;

    /**
     * 期望月收入
     */
    @Column(name = "exp_monthly_income")
    @ApiModelProperty(value = "期望月收入")
    private Integer expMonthlyIncome;

    /**
     * 可接受工作时长
     */
    @Column(name = "work_hour")
    @ApiModelProperty(value = "可接受工作时长")
    private Integer workHour;

    /**
     * 意向车型
     */
    @Column(name = "car_type")
    @ApiModelProperty(value = "意向车型")
    private Integer carType;

    /**
     * 可接受首付范围
     */
    @Column(name = "accept_pay_range")
    @ApiModelProperty(value = "可接受首付范围")
    private Integer acceptPayRange;

    /**
     * 之前在哪工作
     */
    @Column(name = "where_worked")
    @ApiModelProperty(value = "之前在哪工作")
    private String whereWorked;

    /**
     * 是否有在还贷款（1是 2否）
     */
    @Column(name = "is_have_loan")
    @ApiModelProperty(value = "是否有在还贷款（1是 2否）")
    private Integer isHaveLoan;

    /**
     * 是否有车（1是 2否）
     */
    @Column(name = "is_have_car")
    @ApiModelProperty(value = "是否有车（1是 2否）")
    private Integer isHaveCar;

    /**
     * 购车最关注哪些方面
     */
    @Column(name = "buy_car_follow")
    @ApiModelProperty(value = "购车最关注哪些方面")
    private String buyCarFollow;

    /**
     * 是否跟车（1是 2否）
     */
    @Column(name = "is_pay")
    @ApiModelProperty(value = "是否跟车（1是 2否）")
    private Integer isPay;

    /**
     * 征信是否通过（1是 2否）
     */
    @Column(name = "is_credit_pass")
    @ApiModelProperty(value = "征信是否通过（1是 2否）")
    private Integer isCreditPass;

    /**
     * 是否为高意向(1是2否)
     */
    @Column(name = "is_advanced_intentional")
    @ApiModelProperty(value = "是否为高意向(1是2否)")
    private Integer isAdvancedIntentional;

    /**
     * 平均月收入
     */
    @Column(name = "`monthly_income`")
    @ApiModelProperty(value = "平均月收入")
    private Integer monthlyIncome;

    /**
     * 户口类型(城镇户口:1,农村户口:2)
     */
    @Column(name = "`account_type`")
    @ApiModelProperty(value = "户口类型(城镇户口:1,农村户口:2)")
    private Integer accountType;

    /**
     * 家里几个孩子(默认0个)
     */
    @Column(name = "`children_num`")
    @ApiModelProperty(value = "家里几个孩子(默认0个)")
    private Integer childrenNum;

    /**
     * 孩子的年龄
     */
    @Column(name = "`children_age`")
    @ApiModelProperty(value = "孩子的年龄")
    private String childrenAge;

    /**
     * 司机状态
     */
    @Column(name = "`state`")
    @ApiModelProperty(value = "司机状态")
    private Integer state;

    /**
     * 报名时间
     */
    @Column(name = "sign_up_date")
    @ApiModelProperty(value = "报名时间")
    private Date signUpDate;

    /**
     * 合同起始时间
     */
    @Column(name = "contract_start")
    @ApiModelProperty(value = "合同起始时间")
    private Date contractStart;

    /**
     * 合同截止时间
     */
    @Column(name = "contract_end")
    @ApiModelProperty(value = "合同截止时间")
    private Date contractEnd;

    /**
     * 司机首次上岗时间
     */
    @Column(name = "go_to_work_time")
    @ApiModelProperty(value = "司机首次上岗时间")
    private Date goToWorkTime;

    /**
     * 备注
     */
    @Column(name = "`remarks`")
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 加盟经理id
     */
    @Column(name = "`join_manager_id`")
    @ApiModelProperty(value = "加盟经理id")
    private Long joinManagerId;

    /**
     * 签约操作人ID
     */
    @Column(name = "sign_id")
    @ApiModelProperty(value = "签约操作人ID")
    private Integer signId;

    /**
     * 意向金缴纳日期
     */
    @Column(name = "pay_date")
    @ApiModelProperty(value = "意向金缴纳日期")
    private Date payDate;

    /**
     * 面试时间
     */
    @Column(name = "interview_time")
    @ApiModelProperty(value = "面试时间")
    private Date interviewTime;

    @Column(name = "external_user_id")
    @ApiModelProperty(value = "外部联系人userid")
    private String externalUserId;

    @Column(name = "corp_user_id")
    @ApiModelProperty(value = "企业微信成员id")
    private String corpUserId;

    @Column(name = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;



}