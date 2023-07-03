package com.example.coolshare_project.service;

import com.example.coolshare_project.entity.GetIconJson;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
public interface getIconService {
    public String getIcon(HttpSession session, GetIconJson getIconJson);
}
