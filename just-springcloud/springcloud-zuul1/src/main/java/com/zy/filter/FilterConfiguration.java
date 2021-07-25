package com.zy.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;

@Configuration
public class FilterConfiguration {

    @Bean
    ZuulFilter myFilter() {
        return new MyFilter();
    }
    
    @Bean
    ZuulFilter myPostFilter() {
        return new MyPostFilter();
    }
}
