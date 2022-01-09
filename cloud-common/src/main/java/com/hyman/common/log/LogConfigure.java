package com.hyman.common.log;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Map;

/**
 * @Author: hyman
 * @Date: 2018/6/28 14:21
 * @Description:
 */
@Configuration
public class LogConfigure implements WebMvcConfigurer {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public SqlCostInterceptor initSqlInterceptor() {
        return new SqlCostInterceptor();
    }

    @Bean
    public RequestCostInterceptor initRequestInterceptor() {
        return new RequestCostInterceptor();
    }

    @Bean
    public FilterRegistrationBean<HttpRequestMDCFilter> xssFilterRegistrationBean() {
        FilterRegistrationBean<HttpRequestMDCFilter> filterRegistrationBean = new FilterRegistrationBean<HttpRequestMDCFilter>();
        filterRegistrationBean.setFilter(new HttpRequestMDCFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = ImmutableMap.<String, String>builder()
                .put("mappedCookies", "true")
                .put("mappedHeaders", "true")
                .put("mappedParameters", "true")
                .put("applicationName", applicationName)
                .build();

        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestCostInterceptor());
    }
}
