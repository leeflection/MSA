package com.example.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class UserController {

    @GetMapping("first-service")
    public String first(){
        return "first-service";
    }

    @GetMapping("second-service")
    public String second(){
        return "second-service";
    }
}
