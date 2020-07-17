package com.sulin.design.singleton;

/**
 * 静态内部内
 */
public class SingleTon7 {

    private SingleTon7() {
    }

    public static SingleTon7 getInstance() {
        return SingleTonHolder.INSTANCE;
    }

    private static class SingleTonHolder {
        private static final SingleTon7 INSTANCE = new SingleTon7();
    }

}
