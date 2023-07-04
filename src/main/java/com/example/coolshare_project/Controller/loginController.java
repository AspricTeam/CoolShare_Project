package com.example.coolshare_project.Controller;

import com.example.coolshare_project.entity.LoginJson;
import com.example.coolshare_project.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
public class loginController {

    @Autowired
    private loginService loginService;

    @PostMapping("/api/login")
    public LogJson userLogin(@RequestBody LoginJson loginJson, HttpSession session){
        long login = loginService.loginService(loginJson,session);
        LogJson logJson = new LogJson();
        logJson.setLogTime(login);
        return logJson;
    }
    public static class LogJson{
        private Long logTime;

        public Long getLogTime() {
            return logTime;
        }

        public void setLogTime(Long logTime) {
            this.logTime = logTime;
        }
    }
}
