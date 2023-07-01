package com.example.coolshare_project.Controller;

import com.example.coolshare_project.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @PostMapping()

    public String userLogin(@RequestBody User user){

        return "sss";
    }

}
