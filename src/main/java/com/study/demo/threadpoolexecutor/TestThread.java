package com.study.demo.threadpoolexecutor;

import java.util.concurrent.CountDownLatch;

/**
 * 单线程测试类
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                countDownLatch.countDown();
                System.out.println("countDown的数目是：" + countDownLatch);
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                countDownLatch.countDown();
                System.out.println("countDown的数目是：" + countDownLatch);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
            }
        };
        t2.start();

        try {
            countDownLatch.await();//调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
