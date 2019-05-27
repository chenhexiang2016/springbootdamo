package com.study.demo.patten.design.single;

/**
 * 单例模式 饿汉模式
 * 用的时候在创建实例
 */
public class Singleton2 {
    private static Singleton2 singleton1 = new Singleton2();
    private Singleton2() {

    }

    public static Singleton2 getIntence() {
        return singleton1;
    }
}
