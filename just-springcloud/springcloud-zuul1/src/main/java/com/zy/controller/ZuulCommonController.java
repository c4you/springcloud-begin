package com.zy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/zuul")
public class ZuulCommonController {

    @Autowired
    private DiscoveryClient client;
    
    @Value("${server.port}")
    private Integer port;
    
    @RequestMapping("/get")
    public Object get() {
        System.out.println(port);
        return port;
    }
    
    @RequestMapping("/find")
    public Object find() {
        List<String> services = client.getServices();
        System.out.println(services);
        List<ServiceInstance> instances = client.getInstances("springcloud-zuul");
        System.out.println(instances);
        return null;
    }
}
