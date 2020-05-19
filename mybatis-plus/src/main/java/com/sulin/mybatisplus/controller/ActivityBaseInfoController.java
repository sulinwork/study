package com.sulin.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sulin.mybatisplus.aspect.Log;
import com.sulin.mybatisplus.entity.Activity;
import com.sulin.mybatisplus.entity.ActivityBaseInfo;
import com.sulin.mybatisplus.mapper.ActivityBaseInfoMapper;
import com.sulin.mybatisplus.service.ActivityBaseInfoServcie;
import com.sulin.mybatisplus.shop_mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("activities")
public class ActivityBaseInfoController {


    @Autowired
    ActivityBaseInfoMapper activityBaseInfoMapper;

    @Autowired
    ActivityMapper activityMapper;

    @GetMapping
    public List<ActivityBaseInfo> queryAll(String id) {
        ActivityBaseInfo activityBaseInfo = new ActivityBaseInfo();
        activityBaseInfo.setId("383071919592706048");
        List<ActivityBaseInfo> activityBaseInfos = activityBaseInfoMapper.selectList(null);
        //throw new RuntimeException("sdasdas");
        return activityBaseInfos;
    }


    @GetMapping("v2")
    public List<Activity> query() {
        List<Activity> activities = activityMapper.selectList(null);
        return activities;
    }

    @Autowired
    ActivityBaseInfoServcie activityBaseInfoServcie;


    @GetMapping("/v3")
    public void v3() {
        System.out.println(activityBaseInfoServcie.getClass().getName());
    }
}
