package com.hyman.gate.fallback;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;


/**
 * @Author: hyman
 * @Date: 2019年03月05日14:05:53
 * @Description: gate 失败回退处理
 */
@Slf4j
@Component
public class RouteFallbackProvider implements FallbackFactory<ClientHttpResponse> {

    @Override
    public ClientHttpResponse create(Throwable cause) {
        return new ClientHttpResponse() {

            String route = "";
            public String getRoute() {
                return "*";
            }

            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() {
                return HttpStatus.SERVICE_UNAVAILABLE.value();
            }

            @Override
            public String getStatusText() {
                return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() {
                JSONObject r = new JSONObject();
                r.put("code", "9999");
                Map<String, Object> data = Maps.newHashMap();
                data.put("msg", "系统繁忙，请稍后重试。");
                r.put("data", data);

                log.error("调用:【{}】失败， 异常原因：{}", route, (cause != null && cause.getMessage() != null) ? cause.getMessage() : "请求超时");
                return new ByteArrayInputStream(r.toJSONString().getBytes(Charset.forName("UTF-8")));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}