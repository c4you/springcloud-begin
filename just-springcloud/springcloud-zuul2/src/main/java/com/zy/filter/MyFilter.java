package com.zy.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.zy.util.RequestUtil;

public class MyFilter extends ZuulFilter{

    @Value("${server.port}")
    private Integer port;
    
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
       System.out.println("my filter run:" + port);
       
       HttpServletRequest request = RequestUtil.getCurrentRequest();
       String contextPath = request.getContextPath();
       System.out.println(contextPath);
       String requestURI = request.getRequestURI();
       System.out.println(requestURI);
        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}
