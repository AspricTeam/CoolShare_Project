package com.example.CoolShareProject.entity.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rsall {
    private int u_id;
    private String u_name;
    private int u_status;
    private LocalDateTime u_registe_time;
    private String u_sign;
    private String u_sex;
    private java.sql.Date u_birth;
    private int u_infodisplay;
    private int u_ispublic;
    private int u_space;
}
