package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.RegisterDate;
import com.example.coolshare_project.entity.RegisterJson;
import com.example.coolshare_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class registerServiceImplent implements registerService {
    @Autowired
    private  UserMapper user;

    @Override
    public int registerServic(RegisterJson reg) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        RegisterDate rde = new RegisterDate();
        LocalDateTime now = LocalDateTime.now();
        try {
            String dateString = reg.getU_birth();
            Date date1 = sdf.parse(dateString);
            rde.setName(reg.getU_name());
            rde.setPwd(reg.getU_pwd());
            rde.setRegtimer(now);
            rde.setSign(reg.getU_sign());
            rde.setSex(reg.getU_sex());
            rde.setBirth(date1);
            rde.setDisplay(reg.getU_infodisplay());
            rde.setUpublic(reg.getU_ispublic());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int isOk = user.insertUser(rde);
        int uid = user.findId();
        if(isOk!=0) {
            String folderPath = "F:\\CoolShare_Files";
            File folder = new File(folderPath+"\\"+uid);
            if (!folder.exists()) {
                if (folder.mkdirs()) {
                    System.out.println("文件夹创建成功！");
                    return uid;
                } else {
                    System.out.println("文件夹创建失败！");
                    return -2;
                }
            } else {
                System.out.println("文件夹已存在！");
                return -3;
            }
        } else
            return -1;
    }
}
