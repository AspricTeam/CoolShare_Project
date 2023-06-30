package com.example.coolshare_project.Controller;

import com.example.coolshare_project.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registerController {
@RequestMapping(value = "/registe")
public String register(@RequestBody User user){

    return "注册成功";
}
}
