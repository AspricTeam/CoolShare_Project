package com.example.coolshare_project.mapper;

import com.example.coolshare_project.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Mapper
public interface UserMapper {

    @Insert("insert into users set u_name=#{name},u_pwd=#{pwd}," +
            "u_sign=#{sign},u_sex=#{sex},u_birth=#{birth},u_infodisplay=#{display}," +
            "u_ispublic=#{upublic}")
    public int insertUser(RegisterDate rde);

    @Select("select u_id from users ORDER BY u_id DESC LIMIT 1")
    public int findId();

    @Select("select u_name from users where u_id=#{u_id} and u_pwd=#{u_pwd}")
    public String loginUser(LoginJson loginJson);

    @Select("SELECT u_id FROM users WHERE u_id LIKE CONCAT(#{searchRequest}, '%')" +
            " OR u_name LIKE CONCAT(#{searchRequest}, '%')")
    public List<Integer> searchUser(SearchJson searchJson);

}
