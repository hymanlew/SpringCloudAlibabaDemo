package com.hyman.sentinel.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.apache.commons.lang3.StringUtils;

/**
 * Url 资源清洗：
 * sentinel 中 HTTP 服务的限流默认是由 sentinel-web-servlet 包中的 CommonFilter 来实现，它会把每个不同的 URL 都作为不同的资源来
 * 处理。如下接口，只要 id 不同，则限流监控的资源就不同。这就会导致两个问题：
 *
 * 1，限流统计不准确，实际需求是控制 clean 方法总的 QPS，结果统计的是每个 id url 的 QPS。
 * 2，导致服务中资源数量过多，默认资源数量的阈值是 6000，对于多出的资源，流控规则不会生效。
 *
 * 针对此问题，需要统一统计 /clean/* 的接口资源。因此需要重写 Urlclean 接口来实现资源清洗。
 */
public class UrlCleanController implements UrlCleaner {

    @Override
    public String clean(String s) {

        if(StringUtils.isEmpty(s)){
            return s;
        }
        if(s.startsWith("/clean/")){
            return "/clean/*";
        }
        return s;
    }
}
