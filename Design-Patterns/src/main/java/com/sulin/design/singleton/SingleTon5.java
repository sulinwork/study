package com.sulin.design.singleton;

/**
 * 懒汉式(同步代码块)
 */
public class SingleTon5 {

    private SingleTon5() {
    }

    private static SingleTon5 instance;


    public static SingleTon5 getInstance() {
        synchronized (SingleTon5.class) {
            if (instance == null)
                instance = new SingleTon5();
            return instance;
        }
    }

}
