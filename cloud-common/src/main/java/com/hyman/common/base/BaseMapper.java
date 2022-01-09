package com.hyman.common.base;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.rowbounds.SelectByConditionRowBoundsMapper;

/**
 * Created by tianc on 18/9/14.
 */
public interface BaseMapper<T> extends ConditionMapper<T>, MySqlMapper<T>, SelectByConditionRowBoundsMapper<T>, Mapper<T> {
}
