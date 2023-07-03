package com.example.coolshare_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RegisterDate {
    private String name;
    private String pwd;
    private LocalDateTime regtimer;
    private String sign;
    private String sex;
    private Date birth;
    private int display;
    private int upublic;

}
