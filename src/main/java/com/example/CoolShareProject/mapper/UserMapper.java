package com.example.CoolShareProject.mapper;

import com.example.CoolShareProject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users")
    public List<User> findAllUser();

    @Select("select * from users where u_id=#{u_id}")
    public User findbyId(int u_id);
}
