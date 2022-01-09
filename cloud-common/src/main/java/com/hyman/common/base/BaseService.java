package com.hyman.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by tianc on 18/9/14.
 */
public class BaseService<T> {

    @Autowired
    protected BaseMapper<T> mapper;

    public BaseMapper<T> getMapper() {
        return mapper;
    }

    public T selectById(Integer key) {
        return mapper.selectByPrimaryKey(key);
    }

    public void save(T entity) {
        mapper.insert(entity);
    }

    public void deleteById(Integer key) {
        mapper.deleteByPrimaryKey(key);
    }

    public void update(T entity) {
        mapper.updateByPrimaryKey(entity);
    }

    public void updateNotNull(T entity) {
        mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByCondition(Object condition) {
        return mapper.selectByCondition(condition);
    }
}
