package com.company.codejava.c_concurrency_api.a_thread_pool_executors.b_cached_thread_pool_executor;

import java.util.concurrent.*;

/**
 * MultipleTasksExecutorExample.java
 * This program demonstrates how to execute multiple tasks
 * with different kinds of executors.
 * @author www.codejava.net
 */
public class MultipleTasksExecutorExample {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(new CountDownClock("A"));
        pool.execute(new CountDownClock("B"));
        pool.execute(new CountDownClock("C"));
        pool.execute(new CountDownClock("D"));

        pool.shutdown();

        /**
         * Modify this program to add more tasks e.g. add more 3 clocks.
         * Recompile and run the program again,
         * you will see that the number of threads is as equal as the number of submitted tasks.
         * That’s the key behavior of a cached thread pool: new threads are created as needed.
         * */

    }
}
