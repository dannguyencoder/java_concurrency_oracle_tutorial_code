package com.company.codejava.d_concurrent_collections.b_delayqueue;

import java.util.concurrent.*;

public class DelayQueueTest {
    static int CONSUMER_THREADS = 3;

    public static void main(String[] args) {
        DelayQueue<DelayTask> queueTasks = new DelayQueue<>();

        Producer producer = new Producer(queueTasks);
        producer.start();

        Consumer[] consumers = new Consumer[CONSUMER_THREADS];

        for (int i = 0; i < CONSUMER_THREADS; i++) {
            consumers[0] = new Consumer(queueTasks);
            consumers[0].start();
        }

    }
}
