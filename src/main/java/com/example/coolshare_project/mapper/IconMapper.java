package com.example.coolshare_project.mapper;

import com.example.coolshare_project.entity.GetIconJson;
import com.example.coolshare_project.entity.UpIconJson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IconMapper {

    @Update("update users set u_ico = #{pic} where u_id = #{u_id}")
    public int upIcon(UpIconJson upIconJson);

    @Select("select u_ico from users where u_id = #{u_id}")
    public String getIcon(GetIconJson getIconJson);
}
