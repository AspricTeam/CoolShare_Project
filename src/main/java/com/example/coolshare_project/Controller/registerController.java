package com.example.coolshare_project.Controller;

import com.example.coolshare_project.entity.RegisterJson;
import com.example.coolshare_project.service.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class registerController {
    @Autowired
    private registerService registerService;

    @PostMapping(value = "/api/registe")
    public String register(@RequestBody RegisterJson reg){
        if(registerService.registerServic(reg)==1){
            return "成功";
        }
        else{
            return "失败";
        }

    }
}
