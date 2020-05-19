package com.sulin.apildempotence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiLdempotenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiLdempotenceApplication.class, args);
    }


    /**
     * 还可以修改下
     * 变成订单的创建和消费  保证无法重复提交的订单
     * 创建的时候生产token  提交订单的时候销毁token
     */

}
