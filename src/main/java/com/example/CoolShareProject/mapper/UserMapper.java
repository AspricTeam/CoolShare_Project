package com.example.CoolShareProject.mapper;

import com.example.CoolShareProject.entity.result.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (u_name, u_pwd, u_registe_time, u_sign, u_sex, u_birth, u_infodisplay, u_ispublic)"+
            "VALUES (#{name}, #{pwd}, #{regtimer}, #{sign}, #{sex}, #{birth}, #{display}, #{upublic})")
    public int insertUser(RegisterDate rde);


    @Select("select u_id from users ORDER BY u_id DESC LIMIT 1")
    public int findId();

    @Select("select u_name from users where u_id=#{u_id} and u_pwd=#{u_pwd}")
    public String loginUser(LoginJson loginJson);

    @Select("SELECT u_id FROM users WHERE u_id LIKE CONCAT(#{kw}, '%')" +
            " OR u_name LIKE CONCAT(#{kw}, '%')")
    public List<Integer> searchUser(SearchJson searchJson);

    @Select("select u_id,u_name,u_status,u_registe_time,u_sign,u_sex,u_birth,u_infodisplay,u_ispublic,u_space " +
            "from users where u_id = #{u_id}")
    public Rsall searchAll(SeachAllJson allJson);
}
