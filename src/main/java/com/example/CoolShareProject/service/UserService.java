package com.example.CoolShareProject.service;

import com.example.CoolShareProject.entity.*;
import com.example.CoolShareProject.entity.result.Rsall;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    public int  registerServic(RegisterJson reg);
    public Long loginService(LoginJson loginJson, HttpSession session);
    public ArrayList<Integer> seacherService(String kw, HttpSession session);
    public Rsall searchAll(SeachAllJson allJson, HttpSession session);
    public int uploadIconService(UpIconJson upIconJson, HttpSession session);
    public String getIcon(HttpSession session, GetIconJson getIconJson);

}
