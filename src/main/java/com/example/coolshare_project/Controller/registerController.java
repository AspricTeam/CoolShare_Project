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
    public registeJson register(@RequestBody RegisterJson reg){
        int uid = registerService.registerServic(reg);
        registeJson registeJson = new registeJson();
        registeJson.setUid(uid);
        return registeJson;
    }
    public static class registeJson{
        private int uid;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
