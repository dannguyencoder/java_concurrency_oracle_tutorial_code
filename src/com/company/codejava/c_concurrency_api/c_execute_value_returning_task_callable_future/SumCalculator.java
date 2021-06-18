package com.company.codejava.c_concurrency_api.c_execute_value_returning_task_callable_future;

import java.util.concurrent.*;

/**
 * SumCalculator.java
 * This class represents a task that computes and returns value of
 * sum of N numbers.
 * @author www.codejava.net
 */
public class SumCalculator implements Callable<Integer> {
    private int n;

    public SumCalculator(int n) {
        this.n = n;
    }

    public Integer call() {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return sum;
    }
}
