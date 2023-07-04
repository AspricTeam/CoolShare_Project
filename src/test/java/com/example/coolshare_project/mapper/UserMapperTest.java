package com.example.coolshare_project.mapper;

import com.example.coolshare_project.entity.RegisterDate;
import com.example.coolshare_project.entity.RegisterJson;
import com.example.coolshare_project.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void UserMapperTest(){
        String dateString = "2022-01-01";
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date1 = sdf.parse(dateString);
            LocalDateTime now = LocalDateTime.now();
            RegisterDate rde = new RegisterDate("张三","123456",now,"我的签名",
                    "男",date1,0,1);
            int i = userMapper.insertUser(rde);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
