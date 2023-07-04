package com.example.CoolShareProject.service;

import com.example.CoolShareProject.entity.result.*;
import com.example.CoolShareProject.mapper.IconMapper;
import com.example.CoolShareProject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImplent implements UserService{

    @Autowired
    private IconMapper iconMapper;
    @Autowired
    private UserMapper user;
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

    @Override
    public Long loginService(LoginJson loginJson, HttpSession session) {
        String  isOk = user.loginUser(loginJson);
        if(!isOk.isEmpty()){
            session.setAttribute("name", "logged");
            return System.currentTimeMillis();
        }else{
            return -1L;
        }
    }

    @Override
    public List<Integer> seacherService(SearchJson searchJson, HttpSession session) {
        List<Integer> list = user.searchUser(searchJson);
        if(!list.isEmpty()&&session.getAttribute("name")!=null){
            return list;
        }else {
            List<Integer> result = new ArrayList<>();
            result.add(-1);
            return result;
        }
    }

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

    @Override
    public int uploadIconService(UpIconJson upIconJson, HttpSession session) {
        //httpSession.setAttribute("name","zhang");
        if (session.getAttribute("name") != null) {
            int isOk = iconMapper.upIcon(upIconJson);
            if (isOk != 0) {
                return 1;
            } else {
                return 0;
            }
        }else{
            return 0;
        }
    }

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
