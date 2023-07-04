package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.LoginJson;
import com.example.coolshare_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
public class loginServiceImplement implements loginService{

    @Autowired
    private UserMapper user;

    @Override
    public Long loginService(LoginJson loginJson,HttpSession session) {
        String  isOk = user.loginUser(loginJson);
        if(!isOk.isEmpty()){
            session.setAttribute("name", "logged");
            return System.currentTimeMillis();
        }else{
            return -1L;
        }
    }

}

