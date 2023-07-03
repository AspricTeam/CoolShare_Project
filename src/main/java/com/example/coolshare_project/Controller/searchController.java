package com.example.coolshare_project.Controller;

import com.example.coolshare_project.entity.SearchJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.coolshare_project.service.seacherService;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class searchController {

    @Autowired
    private  seacherService seacherService;

    @PostMapping(value = "/api/searchUser")
    public List<Integer> userSearch(@RequestBody SearchJson searchJson, HttpSession session){
        List<Integer> list = seacherService.seacherService(searchJson);
        return list;
    }

}
