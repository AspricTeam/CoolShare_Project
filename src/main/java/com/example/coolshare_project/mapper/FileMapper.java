package com.example.coolshare_project.mapper;

import com.example.coolshare_project.entity.Files;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FileMapper {
    @Insert("INSERT INTO files (f_id, f_name, f_path, f_upload_time, f_size_byte, f_ispublic, f_pwd, f_download_time) " +
            "VALUES (NULL, #{f_name}, #{f_path}, #{f_upload_time}, #{f_size_byte}, #{f_ispublic}, #{f_pwd}, #{f_download_time})")
    void insertFile(Files files);
    @Update("UPDATE files SET f_name = #{f_name}, f_path = #{f_path}, f_upload_time = #{f_upload_time}, " +
            "f_size_byte = #{f_size_byte}, f_ispublic = #{f_ispublic}, f_pwd = #{f_pwd}, f_download_time = #{f_download_time} " +
            "WHERE f_id = #{f_id}")
    void updateFile(Files files);

    @Select("SELECT * FROM files WHERE f_id = #{f_id}")
    @Results({
            @Result(property = "f_path", column = "f_path"),
            @Result(property = "f_name", column = "f_name")
    })
    Files findFilePathById(@Param("f_id") int f_id);

}
