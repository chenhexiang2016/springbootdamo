package com.study.demo.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 在单核CPU的情况下，是不存在可见性问题的，如果是多核CPU，可见性问题就会暴露出来。
 */
public class VolatileDemo {
    public int inc = 0;
    public Boolean flag = false;
    public void incre() {
        inc++;
    }

    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" is start!volatileDemo.inc="+volatileDemo.inc);
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch(Exception e) {
                e.printStackTrace();
            }
            volatileDemo.flag = !volatileDemo.flag;
            System.out.println(Thread.currentThread().getName()+" update volatileDemo.inc!volatileDemo.inc="+volatileDemo.inc);
        },"aaa").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" is start!volatileDemo.inc="+volatileDemo.inc);
            while (true) {
                if (volatileDemo.inc == 1) {
                    System.out.println(Thread.currentThread().getName()+" is over!volatileDemo.inc="+volatileDemo.inc);
                    break;
                }
            }
        },"bbb").start();

        while (volatileDemo.inc == 0) {

        }
        System.out.println(Thread.currentThread().getName()+" is over!volatileDemo.inc="+volatileDemo.inc);
    }
}
