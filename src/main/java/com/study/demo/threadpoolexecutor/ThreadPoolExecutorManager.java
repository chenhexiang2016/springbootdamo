package com.study.demo.threadpoolexecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池管理列 不可变类，不可被继承
 */
public final class ThreadPoolExecutorManager {

    //核心池线程数量大小
    public int CORE_POOL_SIZE = 5;

    //最大线程数量
    public int MAXIMUN_POOL_SIZE = 10;

    //空闲线程最大存活时间
    public int KEEP_ALIVE_TIME = 5;

    public ThreadPoolExecutorManager() {

    }

    public ThreadPoolExecutorManager(int CORE_POOL_SIZE, int MAXIMUN_POOL_SIZE){
        this.CORE_POOL_SIZE = CORE_POOL_SIZE;
        this.MAXIMUN_POOL_SIZE = MAXIMUN_POOL_SIZE;
    }
    /**
     * 通过更改相关参数进行调优
     * @return
     *
     * 当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略，通常有以下四种策略：
     * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
     * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
     * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
     */
    public ThreadPoolExecutor createThreadPoolBean() {
        return new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUN_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(20), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
