package com.study.demo.patten.design.single;

/**
 * 单例模式 懒汉模式
 * 用的时候在创建实例
 */
public class Singleton1 {
    private static Singleton1 singleton1;
    private Singleton1() {

    }

    public static Singleton1 getIntence() {
        //dcl (double check lock)双端检锁
        /*if (singleton1 == null) {
            //通过sychronized关键字实现同步机制，保证线程间安全
            synchronized (Singleton1.class) {
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;*/
        //通过内部类实现线程间安全
        return Inner.singleton1;
    }
    public static class Inner {
        private static Singleton1 singleton1 = new Singleton1();
    }
}
