package com.sulin.annotation.controller;

import com.sulin.annotation.customize.InstanceMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;


@RestController
public class IndexController {

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) throws NoSuchMethodException {
        Method test = this.getClass().getMethod("test");
        InstanceMethod instanceMethod = AnnotationUtils.findAnnotation(test, InstanceMethod.class);
        System.out.println(instanceMethod.value());
        com.sulin.annotation.customize.Method method = AnnotationUtils.findAnnotation(test, com.sulin.annotation.customize.Method.class);
        System.out.println(method.value());
        GetMapping getMapping = AnnotationUtils.findAnnotation(test, GetMapping.class);


        System.out.println(test.isAnnotationPresent(com.sulin.annotation.customize.Method.class));
        Set<com.sulin.annotation.customize.Method> allMergedAnnotations = AnnotatedElementUtils.findAllMergedAnnotations(test, com.sulin.annotation.customize.Method.class);
        com.sulin.annotation.customize.Method mergedAnnotation = AnnotatedElementUtils.findMergedAnnotation(test, com.sulin.annotation.customize.Method.class);
        System.out.println("aaaa");
    }


    @GetMapping
    @InstanceMethod("dasdas")
    public String test() {
        return "";
    }
}
