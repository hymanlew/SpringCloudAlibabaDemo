package com.hyman.common.model.dao.driver;

import com.hyman.common.model.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "com.hyman.common.model.dao.driver.DriverReceiveIntentionInfoDAO")
@Data
@Table(name = "driver_receive_intention_info")
public class DriverReceiveIntentionInfoDAO extends BaseDAO implements Serializable {


    /**
     * 司机id
     */
    @Column(name = "driver_id")
    @ApiModelProperty(value = "司机id")
    private String driverId;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    @ApiModelProperty(value = "字典类型")
    private String dictType;

    /**
     * 字典键值
     */
    @Column(name = "dict_value")
    @ApiModelProperty(value = "字典键值")
    private String dictValue;

    /**
     * 字典键值
     */
    @Column(name = "ext")
    @ApiModelProperty(value = "扩展信息")
    private String ext;

    private static final long serialVersionUID = 3790234328058294690L;
}