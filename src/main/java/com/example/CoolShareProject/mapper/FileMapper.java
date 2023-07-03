package com.example.CoolShareProject.mapper;
import com.example.CoolShareProject.entity.Files;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface FileMapper {
    //插入一个File文件，返回受影响的行数
    @Insert("INSERT INTO files (f_id, f_name, f_upload_time, f_size_byte, f_ispublic, f_pwd, f_download_time) " +
            "VALUES (NULL, #{f_name}, #{f_upload_time}, #{f_size_byte}, #{f_ispublic}, #{f_pwd}, #{f_download_time})")
    @Options(useGeneratedKeys = true, keyProperty = "f_id")
    int addFile(Files files);
    //返回u_id有的所有文件File对象
    @Select("SELECT files.* FROM files,uf,users where files.f_id=uf.f_id and users.u_id=uf.u_id and users.u_id=#{u_id}")
    ArrayList<Files> getFilesByUid(@Param("u_id") String u_id);
    //通过文件名和id删除整个文件记录，返回受影响的行数
    @Delete("DELETE files FROM files,uf,users WHERE files.f_id=#{f_id} and users.u_id=#{u_id} and files.f_id=uf.f_id and uf.u_id=users.u_id")
    int deleteFileById(@Param("f_id") String f_id,@Param("u_id") String u_id);
    //指定用户和文件的拥有关系
    @Insert("INSERT INTO uf VALUES(#{f_id},#{u_id})")
    public int RelateUF(@Param("f_id") String f_id,@Param("u_id") String u_id);
    //通过文件id重命名
    @Update("UPDATE files SET f_name = #{newname} WHERE f_id=#{f_id}")
    int renameFileById(@Param("f_id")String f_id,String newname);
    //根据文件id获取文件名
    @Select("SELECT f_name FROM files where f_id=#{f_id}")
    String getFileNameById(@Param("f_id")String f_id);
    //根据文件id获取所属用户id
    @Select("SELECT u_id FROM uf where f_id=#{f_id}")
    String getUidByFileId(@Param("f_id")String f_id);
    //根据用户id搜索它的文件
    @Select("SELECT files.* FROM files,uf,users WHERE files.f_id=uf.f_id and users.u_id=uf.u_id and users.u_id=#{u_id} and f_name like CONCAT('%', #{f_name}, '%')")
    ArrayList<Files> searchFile(@Param("u_id")String u_id,@Param("f_name")String f_name);
    //根据id获取文件所有信息
    @Select("SELECT * FROM files where f_id=#{f_id}")
    public Files getFileInfoById(@Param("f_id")String f_id);

}
