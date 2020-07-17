package com.sulin.annotation.customize;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
//标识可以被继承
@Inherited
@Documented
public @interface Method {
    String value() default "";
}


