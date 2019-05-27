package com.study.demo.concurrent;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Chenhexiang
 * @Description:
 * @Date: 2019-04-29 09:31
 */
public class HasMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    hashMap.put(System.currentTimeMillis()+Math.random()*100, Math.round(20));
                    countDownLatch.countDown();

                }catch(Exception e) {
                    e.printStackTrace();
                }
            },i+"").start();
        }

        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线城数："+countDownLatch);
        System.out.printf("hasmap长度："+hashMap.size());
    }
}
