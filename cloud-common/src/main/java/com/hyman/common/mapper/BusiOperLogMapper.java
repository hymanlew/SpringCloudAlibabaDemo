package com.hyman.common.mapper;

import com.hyman.common.base.BaseMapper;
import com.hyman.common.model.dao.log.BusiOperLogDAO;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

//@ConditionalOnClass({DataSourceAutoConfiguration.class})
public interface BusiOperLogMapper extends BaseMapper<BusiOperLogDAO> {

    /**
     * 批量插入操作日志
     *
     * @param dtos
     * @return
     */
    int batchInsertSelective(@Param("dtos") Collection<BusiOperLogDAO> dtos);

    int selectLogByBusinessId(@Param("businessId") String businessId);


}
