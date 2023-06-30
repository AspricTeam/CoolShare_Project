package com.example.coolshare_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int u_id;
    private String u_name;
    private String u_pwd;
    //status:0可用，1封禁
    private int status;
    private long u_registe_time;
    private String u_sign;
    private String u_sex;
    private long u_birth;
    private int u_infodisplay;
    private int u_ispublic;

}
