package com.sulin.springsecurity.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Api<T> {
    private Integer code;
    private String message;
    private T data;
}
