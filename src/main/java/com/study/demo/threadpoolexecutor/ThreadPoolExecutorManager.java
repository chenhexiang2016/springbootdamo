package com.study.demo.threadpoolexecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池管理列 不可变类，不可被继承
 */
public final class ThreadPoolExecutorManager {

    //核心池线程数量大小
    public static final int CORE_POOL_SIZE = 5;

    //最大线程数量
    public static final int MAXIMUN_POOL_SIZE = 10;

    //空闲线程最大存活时间
    public static final int KEEP_ALIVE_TIME = 5;

    /**
     * 通过更改相关参数进行调优
     * @return
     */
    public static ThreadPoolExecutor createThreadPoolBean() {
        return new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUN_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(20), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
