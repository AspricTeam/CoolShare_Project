package com.example.coolshare_project.Controller;

import com.example.coolshare_project.entity.GetIconJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.coolshare_project.service.getIconService;
import javax.servlet.http.HttpSession;

@RestController
public class getIconController {

    @Autowired
    private getIconService getIconService;

    @PostMapping("/api/getico")
    public iconJson iconGet(@RequestBody GetIconJson getIconJson, HttpSession session){
        String gtIcon = getIconService.getIcon(session,getIconJson);
        iconJson iconJson = new iconJson();
        iconJson.setIcon(gtIcon);
        return iconJson;
    }
    public static class iconJson{
        private String icon;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
