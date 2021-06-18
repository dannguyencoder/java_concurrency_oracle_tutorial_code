package com.company.codejava.c_concurrency_api.d_fork_join_framework.c_parallelism;

import java.util.*;
import java.util.concurrent.*;

/**
 * This program allows you to easily test performance for ForkJoinPool
 * with different values of parallelism and threshold.
 * @author www.codejava.net
 */
public class ParallelismTest {
    static final int SIZE = 10_000_000;

    static int[] array = randomArray();

    public static void main(String[] args) {
        int threshold = Integer.parseInt(args[0]);
        int parallelism = Integer.parseInt(args[1]);

        long startTime = System.currentTimeMillis();

        ArrayCounter mainTask = new ArrayCounter(array, 0, SIZE, threshold);
        ForkJoinPool pool = new ForkJoinPool(parallelism);
        Integer evenNumberCount = pool.invoke(mainTask);

        long endTime = System.currentTimeMillis();

        System.out.println("Number of even numbers: " + evenNumberCount);

        long time = (endTime - startTime);
        System.out.println("Execution time: " + time + " ms");
    }

    static int[] randomArray() {
        int[] array = new int[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

}
