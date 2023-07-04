package com.example.coolshare_project.Controller;

import com.example.coolshare_project.entity.SeachAllJson;
import com.example.coolshare_project.entity.result.Rsall;
import com.example.coolshare_project.service.searchAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class searchAllController {

    @Autowired
    private searchAllService searchAll;

    @PostMapping("/api/getallbyuid")
    public Rsall searchAllController(@RequestBody SeachAllJson allJson, HttpSession session){
        Rsall res = searchAll.searchAll(allJson,session);
        return res;
    }
}
