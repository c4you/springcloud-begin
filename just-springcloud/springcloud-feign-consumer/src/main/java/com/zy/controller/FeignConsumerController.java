package com.zy.controller;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zy.service.CommonFeignService;

@CrossOrigin
@RestController
@RequestMapping("/feignConsumer")
public class FeignConsumerController {

    @Autowired
    private CommonFeignService service;

    private static String port = null;

    @RequestMapping("/get")
    public Object get(@RequestBody Map<String, Object> parm) {

        Map<String, Object> map = service.get(parm);
        System.out.println(map);
        String rstPort = MapUtils.getString(map, "port");
        if (StringUtils.equals(port, rstPort)) {
            System.err.println("相同：" + port + " ,rstPort:" + rstPort);
        }
        port = rstPort;

        return map;
    }

    public Object getFallback(Map<String, Object> parm) {
        String msg = "feignConsumer 调用默认方法";
        System.out.println(msg);
        return msg;
    }

}
