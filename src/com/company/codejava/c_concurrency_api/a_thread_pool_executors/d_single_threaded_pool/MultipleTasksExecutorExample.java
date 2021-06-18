package com.company.codejava.c_concurrency_api.a_thread_pool_executors.d_single_threaded_pool;

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

        ExecutorService pool = Executors.newSingleThreadExecutor();

        pool.execute(new CountDownClock("A"));
        pool.execute(new CountDownClock("B"));
        pool.execute(new CountDownClock("C"));
        pool.execute(new CountDownClock("D"));

        pool.shutdown();

        /**
         * Recompile and run the program,
         * you will see that there’s only one thread executing the 4 clocks sequentially
         * That’s the key behavior of a single-threaded executor:
         * queue tasks to execute in order, one after another.
         * */

    }
}
