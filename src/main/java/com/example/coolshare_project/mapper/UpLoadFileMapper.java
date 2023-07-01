package com.example.coolshare_project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UpLoadFileMapper {
    @Insert("INSERT INTO files (f_id, f_name, f_path, f_upload_time, f_size_byte, f_ispublic, f_pwd, f_download_time) " +
            "VALUES (NULL, #{fileName}, #{filePath}, #{uploadTime}, #{fileSize}, #{isPublic}, #{password}, #{downloadTime})")
    void insertFile(UploadFile uploadFile);
}
