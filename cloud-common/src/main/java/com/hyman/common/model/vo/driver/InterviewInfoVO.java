package com.hyman.common.model.vo.driver;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lishuai
 */
@Data
@NoArgsConstructor
public class InterviewInfoVO extends BaseVO implements Serializable {

    private static final long serialVersionUID = -483565851971762517L;
    /**
     * 司机编号
     */
    private String driverId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 城市
     */
    private Integer workCity;

    private String workCityName;

    /**
     * 来源渠道
     */
    private Integer sourceChannel;

    private String sourceChannelName;

    private Integer ownCarNum;

    /**
     * 从哪里了解我们的加盟信息
     */
    private String whereKnow;

    /**
     * 重代理姓名
     */
    private String heavyAgentName;

    /**
     * 意向配送模式
     */
    private Integer intentDeliveryMode;

    private String intentDeliveryModeName;

    /**
     * 意向货物类型
     */
    private String intentCargoType;

    private String intentCargoTypeName;

    /**
     * 意向工作时间段
     */
    private String intentWorkDuration;

    private String intentWorkDurationName;

    /**
     * 原职业月均收入
     */
    private Double originIncomeAvg;

    /**
     * 期望月均净收入，去油去电（元/月）
     */
    private Double expIncomeAvg;

    /**
     * 子女数
     */
    private Integer childNum;

    /**
     * 货物运输经验（月）
     */
    private Integer experience;

    /**
     * 实际货车驾龄（月）
     */
    private Integer drivingAge;

    /**
     * 本城市居住时长（月）
     */
    private Integer livingAge;

    /**
     * 驾照类型
     */
    private Integer drivingLicenceType;

    private String drivingLicenceTypeName;

    /**
     * 意向驾驶车型
     */
    private Integer intentDrivingCarType;

    private String intentDrivingCarTypeName;

    /**
     * 最大可支付首付款
     */
    private Integer maxAdvancePayment;
    private String maxAdvancePaymentName;

    /**
     * 是否能承担较重搬运
     */
    private Boolean heavyLifting;
    private String heavyLiftingName;

    /**
     * 能否提供个人征信
     */
    private Boolean providePersonalCredit;
    private String providePersonalCreditName;

    /**
     * 投资决策权
     */
    private Integer strategyRight;
    private String strategyRightName;

    /**
     * 有机会跟云鸟合作，你看中的是什么？
     */
    private Integer cooperateFocusPoint;

    private String cooperateFocusPointName;

    /**
     * 最终决定你是否与云鸟合作的关键因素是什么？
     */
    private Integer cooperateKeyFactor;

    private String cooperateKeyFactorName;

    /**
     * 是否是高意向司机
     */
    private Boolean isAdvancedIntention;

    /**
     * 户口性质（ 1农村 2城镇）
     */
    private Integer householdType;

    private String householdTypeName;

    /**
     * 户籍地址-省
     */
    private Integer householdProvince;
    private String householdProvinceName;

    /**
     * 户籍地址-市
     */
    private Integer householdCity;
    private String householdCityName;

    /**
     * 户籍地址-区县
     */
    private Integer householdCounty;
    private String householdCountyName;

    /**
     * 户籍地址-具体区域
     */
    private String householdDistrict;

    /**
     * 居住地址-省
     */
    private Integer liveProvince;
    private String liveProvinceName;

    /**
     * 居住地址-市
     */
    private Integer liveCity;
    private String liveCityName;

    /**
     * 居住地址-区县
     */
    private Integer liveCounty;
    private String liveCountyName;

    /**
     * 居住地址-具体区域
     */
    private String liveDistrict;

    /**
     * 意向工作区域-省
     */
    private Integer intentWorkProvince;
    private String intentWorkProvinceName;

    /**
     * 意向工作区域-市
     */
    private Integer intentWorkCity;
    private String intentWorkCityName;

    /**
     * 意向工作区域-区县
     */
    private Integer intentWorkCounty;
    private String intentWorkCountyName;

    /**
     * 意向工作区域-具体区域
     */
    private String intentWorkDistrict;

    /**
     * 是否工作地车牌
     */
    private Boolean isLocalPlate;

    /**
     * 面试日期
     */
    private Date interviewDate;

    /**
     * 面试地址-省
     */
    private Integer interviewProvince;
    private String interviewProvinceName;

    /**
     * 面试地址-市
     */
    private Integer interviewCity;
    private String interviewCityName;

    /**
     * 面试地址-区县
     */
    private Integer interviewCounty;
    private String interviewCountyName;

    /**
     * 面试地址-具体区域
     */
    private String interviewDistrict;

    /**
     * 零散活占比（%)
     */
    private Double scatteredJobRate;

    /**
     * 是否新能源
     */
    private Boolean isNewEnergy;

    /**
     * 邀约方式
     */
    private Integer inviteType;
    private String inviteTypeName;

    /**
     * 从业时间（月） (请输入0-500之间的数字)
     */
    private Integer workDuration;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 业务线
     */
    private Integer busiType;
    private String busiTypeName;

    /**
     * 是否有车
     */
    private Boolean hasCar;

    /**
     * 当前车型
     */
    private Integer currentCarType;
    private String currentCarTypeName;

    /**
     * 是否有物流经验
     */
    private Boolean hasTransportExp;

    /**
     * 当前是否无业
     */
    private Boolean currentHasWork;
    /**
     * 1表示换业务线 0 表示不换
     */
    private Boolean isChange;

    /**
     * 学历
     */
    private Integer education;

    private String educationName;

    /**
     * 是否司机小白
     */
    private Boolean isNovice;

    private String isNoviceName;

    /**
     * 原行业
     */
    private Integer beforeProfession;

    private String beforeProfessionName;

    /**
     * 该行原因
     */
    private String changeProfessionReason;

    private String changeProfessionReasonName;

    /**
     * 其他找工作方式
     */
    private Integer otherFindJobWay;

    private String otherFindJobWayName;

    /**
     * 期望结款周期
     */
    private Integer intentCloseAccountsDays;

    /**
     * 是否看中线路
     */
    private Boolean isLikeLine;

    private String isLikeLineName;

    /**
     * 看中线路原因
     */
    private String likeLineReason;

    private String likeLineReasonName;

    /**
     * 未看中线路原因
     */
    private String notLikeLineReason;

    private String notLikeLineReasonName;

    //司撮司机侧提供支持字段

    /**
     * 车牌号
     */
    private String plateNo;

    /**
     * 期望收入(含油)(元/月)
     */
    private Double expIncomeConOil;

    /**
     * 期望收入(趟)
     */
    private Double expIncomeTrip;

    /**
     * 装卸接受度
     */
    private Integer heavyLiftingType;

    private String heavyLiftingTypeName;
}
