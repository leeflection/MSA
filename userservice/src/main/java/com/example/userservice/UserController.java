package com.example.userservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController("/")
@Slf4j
@RequiredArgsConstructor
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

    @GetMapping("second-service/check")
    public String checkSecond(){
        return "Hi, there, second check";
    }

//    @GetMapping("first-service/check")
//    public String checkFirst(){
//        return "Hi, there, first check";
//    }
    private final Environment env;
    @GetMapping("first-service/check")
    public String check(HttpServletRequest request){
        log.info("Server port={}",request.getServerPort());
        return String.format("HI Port %s",env.getProperty("local.server.port"));
    }
}
