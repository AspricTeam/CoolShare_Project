package com.example.coolshare_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class RegisterJson {

    private String u_name;
    private String u_pwd;
    private String u_sign;
    private String u_sex;
    private String u_birth;
    private int u_infodisplay;
    private int u_ispublic;

}
