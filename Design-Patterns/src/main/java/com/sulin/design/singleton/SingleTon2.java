package com.sulin.design.singleton;

/**
 * 饿汉式（静态代码块）
 */
public class SingleTon2 {

    static {
        instance = new SingleTon2();
    }

    private SingleTon2() {
    }

    private static SingleTon2 instance;


    public static SingleTon2 getInstance() {
        return instance;
    }
}
