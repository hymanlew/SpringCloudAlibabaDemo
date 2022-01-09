package com.hyman.common.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * description: MvcInterceptorConfig <br>
// * date: 2020/7/6 11:38 <br>
// * author: hyman <br>
// */
//@Configuration
//public class MvcInterceptorConfig extends WebMvcConfigurationSupport {
//
////    @Autowired
////    private UserContextInterceptor customerInterceptor;
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html","doc.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("actuator")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(customerInterceptor).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//}
