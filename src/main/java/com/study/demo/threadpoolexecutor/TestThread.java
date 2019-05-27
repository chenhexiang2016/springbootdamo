package com.study.demo.threadpoolexecutor;

import java.util.concurrent.*;

/**
 * 单线程测试类
 */
public class TestThread {
    public static  Integer counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i=0; i<=9; i++) {
                    getCount();
                }
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
                for (int i=0; i<=9; i++) {
                    getCount();
                }
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
        }*/


        //Runnable接口
//
        Thread t1 = new Thread(new ThreadCount());
        t1.start();
        t1.join();
        Thread t2 = new Thread(new ThreadCount());
        t2.start();
        t2.join();
        Thread t3 = new Thread(new ThreadCount());
        t3.start();
        t3.join();

        //callable接口
        ThreadCallableTest threadCallableTest = new ThreadCallableTest();
        FutureTask task = new FutureTask(threadCallableTest);
        new Thread(task).run();
        System.out.println(task.get());
    }


    public static void getCount() {
        counter ++;
        System.out.println(counter);
    }

    public static class ThreadCount implements Runnable {
        @Override
        public void run() {
            counter++;
            System.out.println(Thread.currentThread().getName()+":"+counter);
        }
    }

    public static class ThreadCallableTest implements Callable<String> {
        public volatile Integer num = 0;
        @Override
        public String call() throws Exception {
            return "我是Callable接口实现线程";
        }
    }

}
