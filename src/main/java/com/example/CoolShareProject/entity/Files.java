package com.example.CoolShareProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Files {
    private long f_id;
    private String f_name;
    private java.sql.Timestamp f_upload_time;
    private long f_size_byte;
    private int f_ispublic;
    private String f_pwd;
    private int f_download_time;

    public Files() {

    }
}
