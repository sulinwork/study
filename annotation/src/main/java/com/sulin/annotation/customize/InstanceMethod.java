package com.sulin.annotation.customize;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;

import java.lang.annotation.*;

/**
 * @author sulin
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Method
public @interface InstanceMethod {
    @AliasFor(
            annotation = Method.class
    )
    String value() default "";
}
