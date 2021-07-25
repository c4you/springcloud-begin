package com.zy.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "springcloud-common", fallback=CommonFallback.class)
public interface CommonFeignService {

    @RequestMapping("/com/get")
    public Map<String, Object> get(@RequestBody Map<String, Object> parm);
}
