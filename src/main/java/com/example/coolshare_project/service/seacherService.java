package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.SearchJson;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface seacherService {
    public List<Integer> seacherService(SearchJson searchJson);
}
