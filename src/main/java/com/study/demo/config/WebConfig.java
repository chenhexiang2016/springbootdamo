package com.study.demo.config;

import com.study.demo.Interceptor.URLInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(new URLInterceptor()).addPathPatterns("/*/*");//指定拦截器类  指定该类拦截的url
        super.addInterceptors(registry);
    }
}

