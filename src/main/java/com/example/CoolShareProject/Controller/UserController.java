package com.example.CoolShareProject.Controller;

import com.example.CoolShareProject.entity.*;
import com.example.CoolShareProject.entity.result.*;
import com.example.CoolShareProject.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/api/registe")
    public registeJson register(@RequestBody RegisterJson reg){
        int uid = userService.registerServic(reg);
        registeJson registeJson = new registeJson();
        registeJson.setUid(uid);
        return registeJson;
    }

    @PostMapping("/api/login")
    public LogJsons userLogin(@RequestBody LoginJson loginJson, HttpSession session){
        long login = userService.loginService(loginJson,session);
        LogJsons logJson = new LogJsons();
        logJson.setLogTime(login);
        return logJson;
    }

    @PostMapping(value = "/api/searchuser")
    public SeaJson userSearch(@Param("kw") String kw, HttpSession session){
        ArrayList<Integer> list = userService.seacherService(kw,session);
        SeaJson seaJson = new SeaJson();
        seaJson.setSealist(list);
        return seaJson;
    }

    @PostMapping("/api/getallbyuid")
    public Rsall searchAllController(@RequestBody SeachAllJson allJson, HttpSession session){
        Rsall res = userService.searchAll(allJson,session);
        return res;
    }


    @PostMapping("/api/getico")
    public iconJson iconGet(@RequestBody GetIconJson getIconJson, HttpSession session){
        String gtIcon = userService.getIcon(session,getIconJson);
        iconJson iconJson = new iconJson();
        iconJson.setIcon(gtIcon);
        return iconJson;
    }


    @PostMapping("/api/uploadico")
    public int iconUp(@RequestBody UpIconJson upIcon, HttpSession session){
        int success = userService.uploadIconService(upIcon,session);
        return success;
    }

}
