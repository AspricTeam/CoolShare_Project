package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.SeachAllJson;
import com.example.coolshare_project.entity.result.Rsall;
import com.example.coolshare_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
public class searchAllServiceImplement implements searchAllService{

    @Autowired
    private UserMapper user;
    @Override
    public Rsall searchAll(SeachAllJson allJson, HttpSession session) {
        session.setAttribute("name","zhang");
        Rsall res1 = new Rsall();
        Rsall res2 = new Rsall();
        if (session.getAttribute("name") != null) {
            res1 = user.searchAll(allJson);
            if(res1!=null){
                return res1;
            }else {
                res2.setU_id(-1);
                return res2;
            }
        }else {
            return res2;
        }
    }
}
