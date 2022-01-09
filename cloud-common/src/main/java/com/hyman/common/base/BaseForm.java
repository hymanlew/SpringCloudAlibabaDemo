package com.hyman.common.base;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by tianc on 18/9/14.
 */
public abstract class BaseForm<T> {
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
    public abstract <T> T transfer();
}
