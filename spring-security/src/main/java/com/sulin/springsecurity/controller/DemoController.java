package com.sulin.springsecurity.controller;

import com.sulin.springsecurity.utils.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/orders/test")
    public String test() {
        System.out.println("====orders=====");
        return "success";
    }

    @GetMapping("/coupons/test")
    public String test2() {
        System.out.println("====coupons=====");
        return "success";
    }

    @GetMapping("/admin/test")
    public String test3() {
        System.out.println("====test3=====");
        return "admin";
    }

    @GetMapping("/login")
    public Api login() {
        return Api.builder().code(401).message("你还没得登录").build();
    }

//    @PostMapping("/login/form")
//    public String login(String name,String password) {
//        System.out.println("====login=====");
//        return "success";
//    }
//
//    @GetMapping("/logout")
//    public String logout() {
//        System.out.println("====logout=====");
//        return "success";
//    }
}
