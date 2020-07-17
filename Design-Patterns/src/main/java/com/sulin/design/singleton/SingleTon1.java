package com.sulin.design.singleton;

/**
 * 饿汉式（静态常量）
 * 在类加载的时候就实例化了对象 避免了多线程问题
 */
public class SingleTon1 {

    private SingleTon1() {
    }

    private static SingleTon1 instance = new SingleTon1();

    public static SingleTon1 getInstance() {
        return instance;
    }
}
