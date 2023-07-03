package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.LoginJson;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface loginService {
    public Long loginService(LoginJson loginJson, HttpSession session);

}
