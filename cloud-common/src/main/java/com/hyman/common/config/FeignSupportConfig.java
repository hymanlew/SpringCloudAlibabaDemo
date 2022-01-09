package com.hyman.common.config;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author:
 * @create: 2018-10-08
 * @description:
 **/
@Configuration
public class FeignSupportConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }

        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                //tc:RequestTemplate自带Content-length，过滤掉request中的content-length，否则有些feign调用接口时会由于content-length不相等而报400
//                if (TOKEN_HEADER.equals(name) || TOKEN.equals(name) || "content-length".equals(name)) {
//                    continue;
//                }
                if ( "content-length".equals(name)) {
                    continue;
                }
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    template.header(name, value);
                }
            }
        }
    }

}