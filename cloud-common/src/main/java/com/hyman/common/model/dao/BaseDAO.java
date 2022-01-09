package com.hyman.common.model.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Changyuan Su
 * @date 2019/3/15 14:38
 * @Description: 基础数据实体，结合数据库设计样板
 */
@ApiModel(value = "com.hyman.common.model.dao.BaseDAO")
@Data
public class BaseDAO implements Serializable {

    protected static final long serialVersionUID = -3865553071430881650L;

    /**
     * 自增ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "自增ID")
    protected Long id;

    /**
     * 创建者ID
     */
    @Column(name = "`create_id`")
    @ApiModelProperty(value = "创建者ID")
    protected Long createId;

    /**
     * 创建时间
     */
    @Column(name = "`create_date`")
    @ApiModelProperty(value = "创建时间")
    protected Date createDate;

    /**
     * 最后一次修改人员
     */
    @Column(name = "`update_id`")
    @ApiModelProperty(value = "最后一次修改人员")
    protected Long updateId;

    /**
     * 最后一次修改时间
     */
    @Column(name = "`update_date`")
    @ApiModelProperty(value = "最后一次修改时间")
    protected Date updateDate;

//    /**
//     * 常量使用
//     */
//    @JsonIgnore
//    @JSONField(serialize = false)
//    private static final long uId = 0L;

//    public Long getuId() {
//        return null;
//    }

    /**
     * 创建时赋值
     *
     * @param userId
     */
    public void createSet(@NonNull Long userId) {
        if (this.createDate == null) {
            this.createDate = new Date();
        }
        this.createId = userId;
        this.updateDate = this.createDate;
        this.updateId = userId;
    }

    /**
     * 创建时赋值
     *
     * @param userId
     */
    public void updateSet(@NonNull Long userId) {
        this.updateDate = new Date();
        this.updateId = userId;
    }

}
