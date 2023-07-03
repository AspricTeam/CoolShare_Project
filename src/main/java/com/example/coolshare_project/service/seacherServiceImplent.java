package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.SearchJson;
import com.example.coolshare_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class seacherServiceImplent implements seacherService{

    @Autowired
    private UserMapper user;
    @Override
    public List<Integer> seacherService(SearchJson searchJson) {
        List<Integer> list = user.searchUser(searchJson);
        if(!list.isEmpty()){
            return list;
        }else {
            List<Integer> result = new ArrayList<>();
            result.add(-1);
            return result;
        }
    }
}