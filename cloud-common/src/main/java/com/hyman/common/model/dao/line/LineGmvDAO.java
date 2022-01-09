package com.hyman.common.model.dao.line;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "line_gmv")
public class LineGmvDAO {

    /**
     * 自增ID
     */
    @Id
    private Long id;

    /**
     * 线路编号
     */
    @Column(name = "line_id")
    private String lineId;

    /**
     * 项目类型
     */
    @Column(name = "project_type")
    private String projectType;

    /**
     * 项目销售
     */
    @Column(name = "project_sale")
    private String projectSale;

    /**
     * GMV
     */
    private BigDecimal gmv;

    /**
     * 城市
     */
    private String city;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "driver_mobile")
    private String driverMobile;

    /**
     * 司机类型
     */
    @Column(name = "driver_source_type")
    private String driverSourceType;

    @Column(name = "driver_car_num")
    private String driverCarNum;

    /**
     * 司机车型
     */
    @Column(name = "driver_car_type")
    private String driverCarType;

    /**
     * 司机所属加盟经理
     */
    @Column(name = "join_manager")
    private String joinManager;

    @Column(name = "join_manager_group")
    private String joinManagerGroup;

    /**
     * 出车日期
     */
    @Column(name = "event_date")
    private String eventDate;

    @Column(name = "first_try_event_time")
    private String firstTryEventTime;

    @Column(name = "create_id")
    private Integer createId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_id")
    private Integer updateId;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "driver_id")
    private String driverId;

    @Column(name = "customer_gmv")
    private BigDecimal customerGmv;
    @Column(name = "line_sale_mobile")
    private String lineSaleMobile;
    @Column(name = "join_manager_mobile")
    private String joinManagerMobile;
    @Column(name = "order_num")
    private String orderNumber;
    @Column(name = "line_sale_id")
    private String lineSaleId;
    @Column(name = "join_manager_id")
    private String joinManagerId;
    /**
     *订单中司机所对应的业务类型
     **/
    @Column(name="busi_type")
    private Integer busiType;
    /**
     * 线路名称
     **/
    @Column(name="line_name")
    private String lineName;


    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取线路编号
     *
     * @return line_id - 线路编号
     */
    public String getLineId() {
        return lineId;
    }

    /**
     * 设置线路编号
     *
     * @param lineId 线路编号
     */
    public void setLineId(String lineId) {
        this.lineId = lineId == null ? null : lineId.trim();
    }

    /**
     * 获取项目类型
     *
     * @return project_type - 项目类型
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * 设置项目类型
     *
     * @param projectType 项目类型
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    /**
     * 获取项目销售
     *
     * @return project_sale - 项目销售
     */
    public String getProjectSale() {
        return projectSale;
    }

    /**
     * 设置项目销售
     *
     * @param projectSale 项目销售
     */
    public void setProjectSale(String projectSale) {
        this.projectSale = projectSale == null ? null : projectSale.trim();
    }

    /**
     * 获取GMV
     *
     * @return gmv - GMV
     */
    public BigDecimal getGmv() {
        return gmv;
    }

    /**
     * 设置GMV
     *
     * @param gmv GMV
     */
    public void setGmv(BigDecimal gmv) {
        this.gmv = gmv;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return driver_name
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    /**
     * @return driver_mobile
     */
    public String getDriverMobile() {
        return driverMobile;
    }

    /**
     * @param driverMobile
     */
    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile == null ? null : driverMobile.trim();
    }

    /**
     * 获取司机类型
     *
     * @return driver_source_type - 司机类型
     */
    public String getDriverSourceType() {
        return driverSourceType;
    }

    /**
     * 设置司机类型
     *
     * @param driverSourceType 司机类型
     */
    public void setDriverSourceType(String driverSourceType) {
        this.driverSourceType = driverSourceType == null ? null : driverSourceType.trim();
    }

    /**
     * @return driver_car_num
     */
    public String getDriverCarNum() {
        return driverCarNum;
    }

    /**
     * @param driverCarNum
     */
    public void setDriverCarNum(String driverCarNum) {
        this.driverCarNum = driverCarNum == null ? null : driverCarNum.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    /**
     * 获取司机车型
     *
     * @return driver_car_type - 司机车型
     */
    public String getDriverCarType() {
        return driverCarType;
    }

    /**
     * 设置司机车型
     *
     * @param driverCarType 司机车型
     */
    public void setDriverCarType(String driverCarType) {
        this.driverCarType = driverCarType == null ? null : driverCarType.trim();
    }

    /**
     * 获取司机所属加盟经理
     *
     * @return join_manager - 司机所属加盟经理
     */
    public String getJoinManager() {
        return joinManager;
    }

    /**
     * 设置司机所属加盟经理
     *
     * @param joinManager 司机所属加盟经理
     */
    public void setJoinManager(String joinManager) {
        this.joinManager = joinManager == null ? null : joinManager.trim();
    }

    public String getJoinManagerGroup() {
        return joinManagerGroup;
    }

    public void setJoinManagerGroup(String joinManagerGroup) {
        this.joinManagerGroup = joinManagerGroup;
    }

    /**
     * 获取出车日期
     *
     * @return event_date - 出车日期
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     * 设置出车日期
     *
     * @param eventDate 出车日期
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getFirstTryEventTime() {
        return firstTryEventTime;
    }

    public void setFirstTryEventTime(String firstTryEventTime) {
        this.firstTryEventTime = firstTryEventTime;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getCreateId() {
        return createId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}