package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.UpIconJson;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface upIconService {
    public int uploadIconService(UpIconJson upIconJson, HttpSession session);
}
