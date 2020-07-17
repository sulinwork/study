package com.sulin.swagger.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserDto {

    @ApiModelProperty(value = "姓名")
    private String name;
}
