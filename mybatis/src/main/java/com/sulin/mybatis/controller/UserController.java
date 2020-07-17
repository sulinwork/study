package com.sulin.mybatis.controller;


import com.sulin.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    static {

    }

    @Autowired
    UserMapper userMapper;

    @GetMapping("/users")
    public List<Long> getAll(@RequestParam List<Long> ids, HttpServletRequest request) {

        return ids;

    }
}
