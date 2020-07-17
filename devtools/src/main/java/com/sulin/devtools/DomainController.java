package com.sulin.devtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dmeo")
public class DomainController {

    @GetMapping("/dev-a")
    public String demo(String a,String b) {
        System.out.println(a);
        return "success";
    }
}
