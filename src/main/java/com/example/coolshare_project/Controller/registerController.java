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
    public int register(@RequestBody RegisterJson reg){
        int uid = registerService.registerServic(reg);
        if(uid!=0) {
            return uid;
        }
        else{
            return -1;
        }

    }
}
