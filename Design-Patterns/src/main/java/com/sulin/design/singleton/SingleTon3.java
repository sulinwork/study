package com.sulin.design.singleton;

/**
 * 线程不安全的懒汉式
 */
public class SingleTon3 {

    private SingleTon3() {
    }

    private static SingleTon3 instance;


    public static SingleTon3 getInstance() {
        if (instance == null)
            instance = new SingleTon3();
        return instance;
    }

}
