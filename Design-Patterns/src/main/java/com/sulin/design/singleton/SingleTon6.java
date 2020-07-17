package com.sulin.design.singleton;

/**
 * 懒汉式(double check)
 */
public class SingleTon6 {

    private SingleTon6() {
    }

    private static volatile SingleTon6 instance;


    public static SingleTon6 getInstance() {
        if (instance == null) {
            synchronized (SingleTon6.class) {
                if (instance == null) {
                    instance = new SingleTon6();
                }
            }
        }
        return instance;
    }

}
