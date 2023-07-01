package com.example.coolshare_project.mapper;

import com.example.coolshare_project.entity.Files;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;

@SpringBootTest
public class mapperTest {
    @Autowired//注入
    FileMapper fileMapper;
    @Test
    void thisisatest(){
        Files f=new Files(2,"test.txt","F:\\CoolShare_FIies\\1",254624,40,0,"123",0);
        fileMapper.insertFile(f);
    }
}
