package com.sulin.swagger;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class BaseController<Entity> {

    public BaseController() {
        Method[] declaredMethods = this.getClass().getSuperclass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
            if (declaredMethod.getParameterCount() > 0) {
                Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
                for (Type genericParameterType : genericParameterTypes) {
                    System.out.println("##" + genericParameterType.getClass());
                }

            }
        }

    }

    @PostMapping("/user")
    public Entity postT(@Validated @RequestBody Entity entity) {
        return entity;
    }
}
