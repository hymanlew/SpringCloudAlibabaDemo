package com.hyman.nacosconfig.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认情况下，URL 触发限流后会直接返回。而在实际应用中，在都采用 json 格式的数据，所以可自定义限流异常来返回。
 * 也可以直接跳转到一个降级页面，需要在 application.yml 中配置一下。
 */
public class UrlBlockConfig implements UrlBlockHandler {

    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {

        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "访问人数过多");
        httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(map.toString());
    }
}
