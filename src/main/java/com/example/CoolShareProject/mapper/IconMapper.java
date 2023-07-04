package com.example.CoolShareProject.mapper;

import com.example.CoolShareProject.entity.result.GetIconJson;
import com.example.CoolShareProject.entity.result.UpIconJson;
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
