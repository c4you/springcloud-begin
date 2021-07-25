package com.zy.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/configClient")
public class ConfigClientController{
    
    @Value("${file_upload_path}")
    private String fileUploadPath;
    
    @RequestMapping("/get")
    public Object get(){
        String msg = "config client from config server : " + fileUploadPath;
        System.out.println(msg);
        return msg;
    }

    
}
