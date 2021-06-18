package com.company.codejava.c_concurrency_api.c_execute_value_returning_task_callable_future;

import java.util.concurrent.*;

/**
 * FactorialCalculator.java
 * This class represents a task that computes and returns factorial value
 * of N numbers.
 * @author www.codejava.net
 */
public class FactorialCalculator implements Callable<Integer> {
    private int n;

    public FactorialCalculator(int n) {
        this.n = n;
    }

    public Integer call() {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
