package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.RegisterJson;
import org.springframework.stereotype.Service;

@Service
public interface registerService {
    public int  registerServic(RegisterJson reg);
}
