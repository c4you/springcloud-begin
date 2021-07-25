package com.zy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CommonFallback implements CommonFeignService {

    @Override
    public Map<String, Object> get(Map<String, Object> parm) {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "回调默认方法");
        System.out.println(result);
        return result;
    }
}
