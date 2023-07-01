package com.example.coolshare_project.mapper;

import com.example.coolshare_project.entity.RegisterDate;
import com.example.coolshare_project.entity.RegisterJson;
import com.example.coolshare_project.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


@Mapper
public interface UserMapper {
//    @Select("select * from users")
//    public List<User> findAllUser();
//
//    @Select("select * from users where u_id=#{u_id}")
//    public User findbyId(int u_id);

    @Insert("insert into users set u_name=#{name},u_pwd=#{pwd}," +
            "u_sign=#{sign},u_sex=#{sex},u_birth=#{birth},u_infodisplay=#{display}," +
            "u_ispublic=#{upublic}")
    public int insertUser(RegisterDate rde);
}
