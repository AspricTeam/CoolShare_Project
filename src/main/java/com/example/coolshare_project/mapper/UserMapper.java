package com.example.coolshare_project.mapper;

import com.example.coolshare_project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("com.example.coolshare_project.mapper")
@Mapper
public interface UserMapper {
    @Select("select * from users")
    public List<User> findAllUser();

    @Select("select * from users where u_id=#{u_id}")
    public User findbyId(int u_id);
}
