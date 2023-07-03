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
    public SeaJson userSearch(@RequestBody SearchJson searchJson, HttpSession session){
        List<Integer> list = seacherService.seacherService(searchJson,session);
        SeaJson seaJson = new SeaJson();
        seaJson.setSealist(list);
        return seaJson;
    }
    public static class SeaJson{
        private List<Integer> sealist;

        public List<Integer> getSealist() {
            return sealist;
        }

        public void setSealist(List<Integer> sealist) {
            this.sealist = sealist;
        }
    }
}
