package com.hyman.cloudzuulgateway9527;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 当 Zuul 中转发指定路由的服务发生熔断时，可以通过创建 FallbackProvider 类型的bean来提供回退响应。在这个bean中，需要指定回退
 * 的路由ID，并提供一个 ClientHttpResponse 作为回退返回。
 * 如果要为所有路由的服务提供默认回退，可以设置 getRoute 方法返回 *或null。
 */
@Component
public class MyFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        //return "microservice-provider-dept";
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
        if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ClientHttpResponse response(final HttpStatus status) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            /**
             * 当服务发生熔断时，返回的信息（fallback === 熔断的服务名称）
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(("fallback ===" + MyFallbackProvider.this.getRoute()).getBytes());
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

