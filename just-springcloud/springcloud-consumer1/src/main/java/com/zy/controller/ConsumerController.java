package com.zy.controller;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping("/consumer")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private static String port = null;

    @RequestMapping("/get")
    public Object get(@RequestBody Map<String, Object> parm) {
        ResponseEntity<Map> postForEntity = restTemplate.postForEntity("http://SPRINGCLOUD-COMMON/com/get", parm,
                Map.class);
        Map<String, Object> body = postForEntity.getBody();
        System.out.println(body);
        String rstPort = MapUtils.getString(body, "port");
        if (StringUtils.equals(port, rstPort)) {
//            System.err.println("相同：" + port + " ,rstPort:" + rstPort);
        }
        port = rstPort;
        return body;
    }

}
