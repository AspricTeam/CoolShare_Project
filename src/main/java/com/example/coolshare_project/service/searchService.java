package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.SearchJson;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface searchService {
    public List<Integer> seacherService(SearchJson searchJson, HttpSession session);
}