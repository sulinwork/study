package com.sulin.mybatis.enums;


import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SexEnum {
    MAN(2, "男"),
    WOMAN(3, "女");

    private int value;

    private String name;

    SexEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static SexEnum find(int value) {
        SexEnum[] values = SexEnum.values();
        for (SexEnum sexEnum : values) {
            if (sexEnum.value == value) {
                return sexEnum;
            }
        }
        return null;
    }
}
