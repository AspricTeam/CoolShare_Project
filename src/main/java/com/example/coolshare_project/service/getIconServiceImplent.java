package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.GetIconJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import com.example.coolshare_project.mapper.IconMapper;

@Service
public class getIconServiceImplent implements getIconService{

    @Autowired
    private IconMapper iconMapper;
    @Override
    public String getIcon(HttpSession session, GetIconJson getIconJson) {
        //session.setAttribute("name","zhang");
        if (session.getAttribute("name") != null) {
            String icon = iconMapper.getIcon(getIconJson);
            return icon;
        }else {
            return "-1";
        }
    }
}
