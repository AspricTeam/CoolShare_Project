package com.example.coolshare_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class RegisterJson {

    private String name;
    private String pwd;
    private String sign;
    private String sex;
    private String birth;
    private int display;
    private int upublic;


}
