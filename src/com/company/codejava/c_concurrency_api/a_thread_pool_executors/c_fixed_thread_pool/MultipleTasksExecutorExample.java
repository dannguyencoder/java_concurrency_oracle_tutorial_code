package com.company.codejava.c_concurrency_api.a_thread_pool_executors.c_fixed_thread_pool;

import com.company.codejava.c_concurrency_api.a_thread_pool_executors.b_cached_thread_pool_executor.CountDownClock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MultipleTasksExecutorExample.java
 * This program demonstrates how to execute multiple tasks
 * with different kinds of executors.
 * @author www.codejava.net
 */
public class MultipleTasksExecutorExample {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(new CountDownClock("A"));
        pool.execute(new CountDownClock("B"));
        pool.execute(new CountDownClock("C"));
        pool.execute(new CountDownClock("D"));

        pool.shutdown();

        /**
         * The clocks A and B run first, while the clocks C and D are waiting in the queue.
         * After A and B completes execution,
         * the 2 threads continue executing the clocks C and D.
         * That’s the key behavior of a fixed thread pool:
         * limiting the number of concurrent threads and queuing additional tasks.
         * */

    }
}
