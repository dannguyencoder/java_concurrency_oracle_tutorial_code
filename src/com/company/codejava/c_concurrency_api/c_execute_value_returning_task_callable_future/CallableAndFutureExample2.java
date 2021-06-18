package com.company.codejava.c_concurrency_api.c_execute_value_returning_task_callable_future;

import java.util.concurrent.*;

/**
 * CallableAndFutureExample.java
 * This program demonstrates how to execute value-returning tasks
 * and wait for the results available.
 * @author www.codejava.net
 */
public class CallableAndFutureExample2 {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Integer> factorialResult = pool.submit(new FactorialCalculator(8));


        try {

            Integer factorialValue = null;

            try {

                factorialValue = factorialResult.get(3, TimeUnit.SECONDS);

            } catch (TimeoutException ex ) {
                ex.printStackTrace();
            }

            if (factorialValue != null) {

                System.out.println("Factorial Value = " + factorialValue);

            } else {

                boolean cancelled = factorialResult.cancel(true);

                System.out.println("Task cancelled? " + cancelled);
            }

        } catch (InterruptedException | ExecutionException ex ) {
            ex.printStackTrace();
        }

        pool.shutdown();
    }
}
