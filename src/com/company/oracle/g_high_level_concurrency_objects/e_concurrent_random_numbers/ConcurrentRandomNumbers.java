package com.company.oracle.g_high_level_concurrency_objects.e_concurrent_random_numbers;

import java.util.concurrent.ThreadLocalRandom;

public class ConcurrentRandomNumbers {

    public static void main(String[] args) {
        int r = ThreadLocalRandom.current() .nextInt(4, 77);
    }

}
