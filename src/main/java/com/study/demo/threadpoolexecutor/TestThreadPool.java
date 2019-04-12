package com.study.demo.threadpoolexecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池测试类
 */
public class TestThreadPool {
    public static void main(String[] args) {
        long start_run=System.currentTimeMillis(); //获取开始时间
        ThreadPoolExecutorManager threadPoolExecutorManager = new ThreadPoolExecutorManager(10,10);
        ThreadPoolExecutor threadPoolExecutor = threadPoolExecutorManager.createThreadPoolBean();
        for (int i=0; i<=55; i++) {
            MyTask myTask = new MyTask(i);
            try {
                threadPoolExecutor.execute(myTask);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor.getQueue().size()+"，已执行的任务数目："+threadPoolExecutor.getCompletedTaskCount());

        }
        //逐渐退出线程池
        while (threadPoolExecutor.getActiveCount() >= 0) {
            if(threadPoolExecutor.getActiveCount() <= 0){
                System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                        threadPoolExecutor.getQueue().size()+"，已执行的任务数目："+threadPoolExecutor.getCompletedTaskCount());
                long endTime_run=System.currentTimeMillis(); //获取结束时间
                System.out.println("程序运行总时间： "+(endTime_run-start_run)+"ms");
                break;
            }
        }
    }

    public static class MyTask implements Runnable {
        private int tasknum;
        public MyTask(int tasknum) {
            this.tasknum = tasknum;
        }
        @Override
        public void run() {
            System.out.println("正在执行task:"+tasknum);
            try {
                Thread.sleep(2000);
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("task:"+tasknum+"执行完毕");
        }
    }
}
