package com.zy.filter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

public class MyPostFilter extends ZuulFilter {
    @Value("${server.port}")
    private Integer port;

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        InputStream responseDataStream = context.getResponseDataStream();
        String body = "";
        try {
            body = IOUtils.toString(responseDataStream,Charset.forName("UTF-8"));
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Map map = JSONUtil.toBean(body, Map.class);
        map.put("zuulport", port);
        context.setResponseBody(JSONUtil.toJsonStr(map));

        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}
