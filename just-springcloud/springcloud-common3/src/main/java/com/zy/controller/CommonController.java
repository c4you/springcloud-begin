package com.zy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping("/com")
public class CommonController {
	
	@Autowired
	public RestTemplate restTemplate;

	@Value("${server.port}")
	private Integer port;
	
    @RequestMapping("/get")
    public Map<String, Object> get(@RequestBody Map<String, Object> parm) {
        parm.put("port", port);
        System.out.println(parm);
        return parm;
    }
	
	@RequestMapping("/find")
	public Object find() {
		List forObject = restTemplate.getForObject("http://just-consumer/ts/find", List.class);
		return forObject;
	}
}
