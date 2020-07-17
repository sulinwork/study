package com.sulin.swagger;

import com.sulin.swagger.entity.User;
import com.sulin.swagger.entity.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping("/demo")
@Api(tags = "demo")
public class DemoController {

    @GetMapping("/index")
    @ApiOperation("index")
    public String index() {
        return "";
    }

    @GetMapping("user")
    @ApiOperation("获取用户信息")
    public User getUserAll(UserDto userDto) {
        User user = new User();
        user.setId("111111");
        user.setUsername("sulin");
        return user;
    }

    @PostMapping("user")
    @ApiOperation("创建用户信息")
    public User getUserAll(User user) {
        return user;
    }

}
