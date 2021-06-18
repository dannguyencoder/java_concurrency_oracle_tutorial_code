package com.company.codejava.c_concurrency_api.d_fork_join_framework.a_recursive_action;

import java.util.concurrent.*;

/**
 * This class illustrates how to create a ForkJoinTask that does not return
 * a result.
 * @author www.codejava.net
 */
public class ArrayTransform extends RecursiveAction {
    int[] array;
    int number;
    int threshold = 100_000;
    int start;
    int end;

    public ArrayTransform(int[] array, int number, int start, int end) {
        this.array = array;
        this.number = number;
        this.start = start;
        this.end = end;
    }

    protected void compute() {
        if (end - start < threshold) {
            computeDirectly();
        } else {
            int middle = (end + start) / 2;

            ArrayTransform subTask1 = new ArrayTransform(array, number, start, middle);
            ArrayTransform subTask2 = new ArrayTransform(array, number, middle, end);

            invokeAll(subTask1, subTask2);
        }
    }

    protected void computeDirectly() {
        for (int i = start; i < end; i++) {
            array[i] = array[i] * number;
        }
    }
}
