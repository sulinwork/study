package com.sulin.design.singleton;

/**
 * 懒汉式(同步方法)
 */
public class SingleTon4 {

    private SingleTon4() {
    }

    private static SingleTon4 instance;


    public synchronized static SingleTon4 getInstance() {
        if (instance == null)
            instance = new SingleTon4();
        return instance;
    }

}
