package com.hyman.cloudzuulgateway9527;

import com.google.common.net.MediaType;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * pre：是在请求路由之前调用，可以用它实现身份验证，在集群中选择请求的微服务，记录调试信息等。
 * routing：是将请求路由到微服务，可以用它构建发送给微服务的请求，并使用 apache httpclient 或 ribbon 请求微服务。
 * post：是在路由到微服务之后执行，可以用它来为响应添加标准的 HTTP Header，收集统计信息和指标，将响应从微服务发送给客户端等。
 * error：是在其他阶段发生错误时执行。
 *
 * filterType()：定义过滤器的类型，它有4种类型，分别是pre、post、routing和error
 * filterOrder()：过滤顺序，它是一个Int类型的值，值越小，越早执行该过滤器
 * shouldFilter()：表示该过滤器是否过滤逻辑，如果为true，则执行run方法，如果为false，则不执行run方法
 * Object run()：写具体的过滤逻辑。
 *
 * springcloud zuul 默认情况下在代理和服务器模式下都启用了 zuulfilter。
 * 如果要禁用某一类型的过滤器，则可以设置 zuul.<SimpleClassName>.<filterType>.disable=true（zuul.SendResponseFilter.post.disable=true）。
 *
 * 展示一个简单的例子,判断请求的参数中是否有token这个参数，如果没有传，则请求不会被路由到具体的服务实例，直接返回响应。
 */
@Component
public class OkHttpRoutingFilter extends ZuulFilter {

    @Autowired
    private ProxyRequestHelper helper;

    /**
     * 预筛选器在请求上下文中设置数据，以便在下游筛选器中使用。主要用例是设置路由筛选器所需的信息。
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 声明是否启用本 filter
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        request.getRemoteAddr();
        Object accessToken = request.getParameter("token");
        if (null == accessToken) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(404);
            try {
                context.getResponse().getWriter().write("token is empty");

            } catch (Exception e) {
            }
            return null;
        }
        return null;
    }
}

