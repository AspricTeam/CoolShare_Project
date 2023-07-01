package com.example.coolshare_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Files {
    private int f_id;
    private String f_name;
    private String f_path;
    private long f_upload_time;
    private int f_size_byte;
    private int f_ispublic;
    private String f_pwd;
    private int f_download_time;
}
