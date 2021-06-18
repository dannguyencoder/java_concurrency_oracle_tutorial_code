package com.company.codejava.c_concurrency_api.a_thread_pool_executors.e_custom_thread_pool_executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor {

    public static void main(String[] args) {
        int corePoolSize = 10;
        int maxPoolSize = 1000;
        int keepAliveTime = 120;
        BlockingQueue<Runnable> workQueue = new SynchronousQueue<Runnable>();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                workQueue);
//        pool.execute(new RunnableTask());

        /**
         * You can see that when corePoolSize = maxPoolSize = 1,
         * we have a single-threaded pool executor.
         * */

    }

}
