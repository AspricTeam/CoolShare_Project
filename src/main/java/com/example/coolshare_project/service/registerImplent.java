package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.RegisterDate;
import com.example.coolshare_project.entity.RegisterJson;
import com.example.coolshare_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class registerImplent implements registerService {
    @Autowired
    private  UserMapper user;

    @Override
    public int registerServic(RegisterJson reg) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        RegisterDate rde = new RegisterDate();
        try {
            String dateString = reg.getBirth();
            Date date1 = sdf.parse(dateString);
            rde.setName(reg.getName());
            rde.setPwd(reg.getPwd());
            rde.setSign(reg.getSign());
            rde.setSex(reg.getSex());
            rde.setBirth(date1);
            rde.setDisplay(reg.getDisplay());
            rde.setUpublic(reg.getUpublic());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int isOk = user.insertUser(rde);
        int uid = user.findId();
        if(isOk!=0)
            return uid;
        else
            return 0;
    }
}
