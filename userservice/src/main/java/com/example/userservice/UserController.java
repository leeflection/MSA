package com.example.userservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@Slf4j
public class UserController {

    @GetMapping("first-service")
    public String first(){
        log.info("first 호출됨");
        return "first-service";
    }
    @GetMapping("first-service/message")
    public String firstMessage(@RequestHeader("first-request") String header){
        log.info(header);
        return "first-service";
    }

    @GetMapping("second-service")
    public String second(){
        log.info("second 호출됨");
        return "second-service";
    }
    @GetMapping("second-service/message")
    public String secondMessage(@RequestHeader("second-request") String header){
        log.info(header);
        return "second-service";
    }
}
