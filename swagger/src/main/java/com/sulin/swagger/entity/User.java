package com.sulin.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("user")
public class User {
    @ApiModelProperty(value = "id", example = "22222222222222", allowableValues = "@id()")
    private String id;

    @ApiModelProperty(value = "username", example = "sulin", allowableValues = "张三,李四,'@float(0,1000,2,2)'")
    private String username;

    @ApiModelProperty(value = "password", example = "123456",readOnly = true)
    private String password;

}
