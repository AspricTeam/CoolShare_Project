package com.example.coolshare_project.Controller;

import com.example.coolshare_project.entity.UpIconJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.coolshare_project.service.upIconService;

import javax.servlet.http.HttpSession;

@RestController
public class uploadIconController {

    @Autowired
    private upIconService upIconService;

    @PostMapping("/api/uploadico")
    public int iconUp(@RequestBody UpIconJson upIcon, HttpSession session){
        int success = upIconService.uploadIconService(upIcon,session);
        return success;
    }
}
