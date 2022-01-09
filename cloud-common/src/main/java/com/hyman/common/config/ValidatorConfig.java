package com.hyman.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * controller单参数入参校验
 */
@Configuration
public class ValidatorConfig {

    /**
     * 负责不能生效对应的@Range、@Min、@Max等validator包里面提供的注解
     *
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
