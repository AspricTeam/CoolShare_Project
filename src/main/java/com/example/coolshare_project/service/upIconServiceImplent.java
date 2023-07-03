package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.UpIconJson;
import com.example.coolshare_project.mapper.IconMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
public class upIconServiceImplent implements upIconService{

    @Autowired
    private IconMapper icon;

    @Override
    public int uploadIconService(UpIconJson upIconJson, HttpSession httpSession) {
        //httpSession.setAttribute("name","zhang");
        if (httpSession.getAttribute("name") != null) {
            int isOk = icon.upIcon(upIconJson);
            if (isOk != 0) {
                return 1;
            } else {
                return 0;
            }
        }else{
            return 0;
        }
    }

}
