package com.sulin.apildempotence.controller;

import com.sulin.apildempotence.annotation.AutoIdempotent;
import com.sulin.apildempotence.service.TokenService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class DemoController {

    @Autowired
    TokenService tokenService;

    @AutoIdempotent
    @PostMapping("save")
    public String test() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping("token")
    public String getToken() {
        String token = tokenService.createToken();
        if (Strings.isNotEmpty(token)) {
            return token;
        }
        return "null";
    }
}
