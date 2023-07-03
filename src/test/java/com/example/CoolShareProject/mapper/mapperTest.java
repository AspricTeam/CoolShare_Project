package com.example.CoolShareProject.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class mapperTest {
    @Autowired//注入
    FileMapper fileMapper;
    @Test
    void thisisatest(){
        System.out.println("test");
    }
}
