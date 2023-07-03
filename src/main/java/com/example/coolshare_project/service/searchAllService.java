package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.SeachAllJson;
import com.example.coolshare_project.entity.result.Rsall;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface searchAllService {
    public Rsall searchAll(SeachAllJson allJson, HttpSession session);
}
